package io.github.mwttg.nibbles.entity;

import io.github.mwttg.nibbles.Constants;
import io.github.mwttg.nibbles.entity.snake.Direction;
import io.github.mwttg.nibbles.entity.snake.Snake;
import io.github.mwttg.nibbles.utilities.Assets;
import org.lwjgl.opengl.GL41;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SnakeEntity {

  private static final Logger LOG = LoggerFactory.getLogger(SnakeEntity.class);

  private Snake snake;
  private Direction direction;
  private boolean alive;
  private float timeWentBy;

  private SnakeEntity(final Snake snake) {
    this.snake = snake;
    this.alive = true;
    this.direction = Direction.LEFT;
    this.timeWentBy = 0.0f;
  }

  public static SnakeEntity initialize(final int x, final int y) {
    LOG.info("Initialize Snake ...");
    final Snake snake = Snake.initialize(x, y);
    return new SnakeEntity(snake);
  }

  public void draw() {
    drawTail();
    drawHead();
  }

  private void drawTail() {
    GL41.glUseProgram(Assets.getInstance().getInstancedShaderId());
    Assets.getInstance()
        .getSpriteSnakeTail()
        .draw(
            Assets.getInstance().getInstancedUniform(),
            snake.getTailTransforms(),
            Constants.VIEW,
            Constants.PROJECTION);
  }

  private void drawHead() {
    GL41.glUseProgram(Assets.getInstance().getShaderId());
    switch (direction) {
      case UP ->
          Assets.getInstance()
              .getSpriteSnakeHeadUp()
              .draw(
                  Assets.getInstance().getUniform(),
                  snake.getHeadTransform(),
                  Constants.VIEW,
                  Constants.PROJECTION);
      case DOWN ->
          Assets.getInstance()
              .getSpriteSnakeHeadDown()
              .draw(
                  Assets.getInstance().getUniform(),
                  snake.getHeadTransform(),
                  Constants.VIEW,
                  Constants.PROJECTION);
      case LEFT ->
          Assets.getInstance()
              .getSpriteSnakeHeadLeft()
              .draw(
                  Assets.getInstance().getUniform(),
                  snake.getHeadTransform(),
                  Constants.VIEW,
                  Constants.PROJECTION);
      case RIGHT ->
          Assets.getInstance()
              .getSpriteSnakeHeadRight()
              .draw(
                  Assets.getInstance().getUniform(),
                  snake.getHeadTransform(),
                  Constants.VIEW,
                  Constants.PROJECTION);
    }
  }

  public void update(final Direction direction, final LevelEntity levelEntity, final float deltaTime) {
    this.direction = direction;
    timeWentBy = timeWentBy + deltaTime;

    if (alive && (snake.doesBitOwnTail() || snake.doesHeadHitsWall(levelEntity))) {
      Assets.getInstance().getSoundDead().play();
      alive = false;
      // TODO reset Snake / remove life
    }

    if (snake.doesHeadHitsApple(levelEntity)) {
      Assets.getInstance().getSoundEat().play();
      levelEntity.getLevel().removeAppleFromPosition(snake.head());
      snake = snake.grow(5);
    }

    if (timeWentBy > Constants.SNAKE_TIME_TO_NEXT_MOVE && alive) {
      Assets.getInstance().getSoundMove().play();
      snake = snake.move(direction);
      timeWentBy = 0.0f;
    }
  }
}
