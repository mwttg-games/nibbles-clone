package io.github.mwttg.nibbles.entity;

import io.github.mwttg.nibbles.Constants;
import io.github.mwttg.nibbles.entity.level.Level;
import io.github.mwttg.nibbles.utilities.Assets;
import java.util.List;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL41;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelEntity {

  private static final Logger LOG = LoggerFactory.getLogger(LevelEntity.class);
  private static final Matrix4f BACKGROUND_TRANSFORM =
      new Matrix4f().translate(0.0f, 0.0f, Constants.LEVEL_Z_LAYER);

  private final Level level;

  private LevelEntity() {
    this.level = Level.initialize();
  }

  public static LevelEntity initialize() {
    LOG.info("Initialize Level ...");
    return new LevelEntity();
  }

  public void draw() {
    GL41.glUseProgram(Assets.getInstance().getShaderId());
    Assets.getInstance()
        .getSpriteBackground()
        .draw(
            Assets.getInstance().getUniform(),
            BACKGROUND_TRANSFORM,
            Constants.VIEW,
            Constants.PROJECTION);

    GL41.glUseProgram(Assets.getInstance().getInstancedShaderId());
    final List<Matrix4f> wallTransforms = level.getWallTransforms();
    Assets.getInstance()
        .getSpriteWall()
        .draw(
            Assets.getInstance().getInstancedUniform(),
            wallTransforms,
            Constants.VIEW,
            Constants.PROJECTION);

    final List<Matrix4f> appleTransforms = level.getAppleTransforms();
    Assets.getInstance()
        .getSpriteApple()
        .draw(
            Assets.getInstance().getInstancedUniform(),
            appleTransforms,
            Constants.VIEW,
            Constants.PROJECTION);
  }

  public Level getLevel() {
    return level;
  }
}
