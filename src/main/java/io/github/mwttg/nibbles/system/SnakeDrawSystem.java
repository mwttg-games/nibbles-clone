package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.component.Assets;
import io.github.mwttg.nibbles.component.Constants;
import io.github.mwttg.nibbles.component.Direction;
import io.github.mwttg.nibbles.entity.SnakeEntity;
import java.util.List;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL41;

public final class SnakeDrawSystem {

  private SnakeDrawSystem() {}

  public static void drawSnake(final SnakeEntity snakeEntity) {
    final Direction direction = snakeEntity.getDirection();
    final Matrix4f headTransform = snakeEntity.getHeadTransform();
    final List<Matrix4f> tailTransforms = snakeEntity.getTailTransforms();

    drawTail(tailTransforms);
    drawHead(headTransform, direction);
  }

  private static void drawTail(final List<Matrix4f> tailTransforms) {
    GL41.glUseProgram(Assets.getInstance().getInstancedShaderId());
    Assets.getInstance()
        .getSpriteSnakeTail()
        .draw(
            Assets.getInstance().getInstancedUniform(),
            tailTransforms,
            Constants.VIEW,
            Constants.PROJECTION);
  }

  private static void drawHead(final Matrix4f headTransform, final Direction direction) {
    GL41.glUseProgram(Assets.getInstance().getShaderId());
    switch (direction) {
      case UP ->
          Assets.getInstance()
              .getSpriteSnakeHeadUp()
              .draw(
                  Assets.getInstance().getUniform(),
                  headTransform,
                  Constants.VIEW,
                  Constants.PROJECTION);
      case DOWN ->
          Assets.getInstance()
              .getSpriteSnakeHeadDown()
              .draw(
                  Assets.getInstance().getUniform(),
                  headTransform,
                  Constants.VIEW,
                  Constants.PROJECTION);
      case LEFT ->
          Assets.getInstance()
              .getSpriteSnakeHeadLeft()
              .draw(
                  Assets.getInstance().getUniform(),
                  headTransform,
                  Constants.VIEW,
                  Constants.PROJECTION);
      case RIGHT ->
          Assets.getInstance()
              .getSpriteSnakeHeadRight()
              .draw(
                  Assets.getInstance().getUniform(),
                  headTransform,
                  Constants.VIEW,
                  Constants.PROJECTION);
    }
  }
}
