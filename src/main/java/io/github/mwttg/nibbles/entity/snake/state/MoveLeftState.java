package io.github.mwttg.nibbles.entity.snake.state;

import io.github.mwttg.nibbles.entity.snake.Direction;
import io.github.mwttg.nibbles.entity.snake.Snake;
import io.github.mwttg.nibbles.utilities.Assets;
import io.github.mwttg.pixelartillery2d.graphic.Sprite;

public class MoveLeftState extends AbstractSnakeMoveState implements SnakeState {

  @Override
  protected Sprite getHeadSprite() {
    return Assets.getInstance().getSpriteSnakeHeadLeft();
  }

  @Override
  public void playSound() {
    Assets.getInstance().getSoundMove().play();
  }

  @Override
  public Snake update(final Snake snake) {
    return snake.move(Direction.LEFT);
  }

  @Override
  public SnakeState handleStateTransition(
      final Snake snake, final Direction direction, final SnakeStateManager stateManager) {
    if (direction == Direction.UP) {
      return stateManager.getMoveUp();
    } else if (direction == Direction.DOWN) {
      return stateManager.getMoveDown();
    } else {
      return stateManager.getMoveLeft();
    }
  }
}
