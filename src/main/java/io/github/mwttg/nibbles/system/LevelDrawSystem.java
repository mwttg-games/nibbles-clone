package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.component.Assets;
import io.github.mwttg.nibbles.Constants;
import io.github.mwttg.nibbles.entity.LevelEntity;
import java.util.List;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL41;

public final class LevelDrawSystem {

  private static final Matrix4f BACKGROUND_TRANSFORM =
      new Matrix4f().translate(0.0f, 0.0f, Constants.LEVEL_Z_LAYER);

  private LevelDrawSystem() {}

  public static void drawLevel(final LevelEntity entity) {
    final List<Matrix4f> wallTransforms = entity.getWallTransforms();
    drawBackground();
    drawWalls(wallTransforms);
  }

  private static void drawBackground() {
    GL41.glUseProgram(Assets.getInstance().getShaderId());
    Assets.getInstance()
        .getSpriteBackground()
        .draw(
            Assets.getInstance().getUniform(),
            BACKGROUND_TRANSFORM,
            Constants.VIEW,
            Constants.PROJECTION);
  }

  private static void drawWalls(final List<Matrix4f> wallTransforms) {
    GL41.glUseProgram(Assets.getInstance().getInstancedShaderId());
    Assets.getInstance()
        .getSpriteWall()
        .draw(
            Assets.getInstance().getInstancedUniform(),
            wallTransforms,
            Constants.VIEW,
            Constants.PROJECTION);
  }
}
