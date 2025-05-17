package io.github.mwttg.nibbles.entity.snake.state;

import io.github.mwttg.nibbles.entity.snake.Direction;
import io.github.mwttg.nibbles.entity.snake.Snake;
import io.github.mwttg.nibbles.utilities.Assets;
import io.github.mwttg.pixelartillery2d.graphic.Sprite;

public class MoveDownState extends AbstractSnakeMoveState implements SnakeState {

  @Override
  protected Sprite getHeadSprite() {
    return Assets.getInstance().getSpriteSnakeHeadDown();
  }

  @Override
  public void playSound() {
    Assets.getInstance().getSoundMove().play();
  }

  @Override
  public Snake update(final Snake snake) {
    return snake.move(Direction.DOWN);
  }

  @Override
  public SnakeState handleStateTransition(
      final Snake snake, final Direction direction, final SnakeStateManager stateManager) {
    if (direction == Direction.LEFT) {
      return stateManager.getMoveLeft();
    } else if (direction == Direction.RIGHT) {
      return stateManager.getMoveRight();
    } else {
      return stateManager.getMoveDown();
    }
  }
}
