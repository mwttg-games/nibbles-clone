package io.github.mwttg.nibbles.entity.snake.state;

import io.github.mwttg.nibbles.entity.snake.Direction;
import io.github.mwttg.nibbles.entity.snake.Snake;

public class GrowState implements SnakeState {

  @Override
  public void playSound() {}

  @Override
  public void draw(final Snake snake) {}

  @Override
  public Snake update(final Snake snake) {
    return null;
  }

  @Override
  public SnakeState handleStateTransition(
      final Snake snake, Direction direction, SnakeStateManager stateManager) {
    return null;
  }
}
