package io.github.mwttg.nibbles.entity.snake.state;

import io.github.mwttg.nibbles.entity.LevelEntity;
import io.github.mwttg.nibbles.entity.snake.Direction;
import io.github.mwttg.nibbles.entity.snake.Snake;
import io.github.mwttg.nibbles.utilities.Assets;

public class GrowState implements SnakeState {

  @Override
  public void playSound() {
    Assets.getInstance().getSoundEat().play();
  }

  @Override
  public void draw(final Snake snake) {}

  @Override
  public Snake update(final Snake snake) {
    return snake.grow(5);
  }

  @Override
  public SnakeState handleStateTransition(
      final Snake snake,
      final Direction direction,
      final LevelEntity levelEntity,
      final SnakeStateManager stateManager) {
    levelEntity.getLevel().removeAppleFromPosition(snake.head());
    return stateManager.getPreviousState();
  }
}
