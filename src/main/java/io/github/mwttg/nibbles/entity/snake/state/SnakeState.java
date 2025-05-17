package io.github.mwttg.nibbles.entity.snake.state;

import io.github.mwttg.nibbles.entity.snake.Direction;
import io.github.mwttg.nibbles.entity.snake.Snake;

public interface SnakeState {

  void playSound();

  void draw(final Snake snake);

  Snake update(final Snake snake);

  SnakeState handleStateTransition(
      final Snake snake, final Direction direction, final SnakeStateManager stateManager);
}
