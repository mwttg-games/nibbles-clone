package io.github.mwttg.nibbles.entity.snake.state;

import io.github.mwttg.nibbles.entity.LevelEntity;
import io.github.mwttg.nibbles.entity.snake.Direction;
import io.github.mwttg.nibbles.entity.snake.Snake;
import io.github.mwttg.nibbles.utilities.Assets;

public class DieState implements SnakeState {

  private boolean isDead = false;

  @Override
  public void playSound() {
    if (!isDead) {
      Assets.getInstance().getSoundDead().play();
      isDead = true;
    }
  }

  @Override
  public void draw(final Snake snake) {}

  @Override
  public Snake update(final Snake snake) {
    return snake;
  }

  @Override
  public SnakeState handleStateTransition(
      final Snake snake,
      final Direction direction,
      final LevelEntity levelEntity,
      final SnakeStateManager stateManager) {
    return stateManager.getDieState();
  }
}
