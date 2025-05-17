package io.github.mwttg.nibbles.entity;

import io.github.mwttg.nibbles.entity.snake.Direction;
import io.github.mwttg.nibbles.entity.snake.Snake;
import io.github.mwttg.nibbles.entity.snake.state.SnakeStateManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SnakeEntity {

  private static final Logger LOG = LoggerFactory.getLogger(SnakeEntity.class);

  private final SnakeStateManager snakeStateManager;
  private Snake snake;

  private SnakeEntity(final Snake snake) {
    this.snake = snake;
    this.snakeStateManager = SnakeStateManager.initialize();
  }

  public static SnakeEntity initialize(final int x, final int y) {
    LOG.info("Initialize Snake ...");
    final Snake snake = Snake.initialize(x, y);
    return new SnakeEntity(snake);
  }

  public void draw() {
    snakeStateManager.draw(snake);
  }

  public void update(final Direction direction) {
    snake = snakeStateManager.update(snake, direction);
  }
}
