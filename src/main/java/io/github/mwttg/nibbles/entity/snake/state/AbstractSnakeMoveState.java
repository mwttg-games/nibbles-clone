package io.github.mwttg.nibbles.entity.snake.state;

import io.github.mwttg.nibbles.Constants;
import io.github.mwttg.nibbles.entity.snake.Snake;
import io.github.mwttg.nibbles.utilities.Assets;
import io.github.mwttg.pixelartillery2d.graphic.Sprite;
import java.util.List;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL41;

public abstract class AbstractSnakeMoveState {

  public void draw(final Snake snake) {
    // draw head
    GL41.glUseProgram(Assets.getInstance().getShaderId());
    final Matrix4f headTransform = snake.getHeadTransform();
    getHeadSprite()
        .draw(
            Assets.getInstance().getUniform(), headTransform, Constants.VIEW, Constants.PROJECTION);

    // draw tail
    GL41.glUseProgram(Assets.getInstance().getInstancedShaderId());
    final List<Matrix4f> transforms = snake.getTailTransforms();
    Assets.getInstance()
        .getSpriteSnakeTail()
        .draw(
            Assets.getInstance().getInstancedUniform(),
            transforms,
            Constants.VIEW,
            Constants.PROJECTION);
  }

  protected abstract Sprite getHeadSprite();
}
