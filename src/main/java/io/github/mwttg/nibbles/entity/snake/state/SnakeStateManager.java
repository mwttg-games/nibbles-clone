package io.github.mwttg.nibbles.entity.snake.state;

import io.github.mwttg.nibbles.entity.LevelEntity;
import io.github.mwttg.nibbles.entity.snake.Direction;
import io.github.mwttg.nibbles.entity.snake.Snake;
import io.github.mwttg.pixelartillery2d.timer.Timer;

public class SnakeStateManager {

  private static final float TIME_TO_NEXT_MOVE = 0.15f;

  private final SnakeState moveUp;
  private final MoveDownState moveDown;
  private final MoveLeftState moveLeft;
  private final MoveRightState moveRight;
  private final GrowState growState;

  private SnakeState previousState;
  private SnakeState currentState;
  private float timeWentBy;

  private final Timer timer;

  private SnakeStateManager(
      final SnakeState moveUp,
      final MoveDownState moveDown,
      final MoveLeftState moveLeft,
      final MoveRightState moveRight,
      final GrowState growState) {
    this.moveUp = moveUp;
    this.moveDown = moveDown;
    this.moveLeft = moveLeft;
    this.moveRight = moveRight;
    this.growState = growState;
    this.previousState = moveLeft;
    this.currentState = moveLeft;
    this.timer = Timer.initialize();
    this.timeWentBy = 0.0f;
  }

  public static SnakeStateManager initialize() {
    return new SnakeStateManager(
        new MoveUpState(),
        new MoveDownState(),
        new MoveLeftState(),
        new MoveRightState(),
        new GrowState());
  }

  public void draw(final Snake snake) {
    // TODO: Workaround because for GrowState Head Direction not available, yet
    if (currentState != growState) {
      currentState.draw(snake);
    } else {
      previousState.draw(snake);
    }
  }

  public Snake update(final Snake snake, final Direction direction, final LevelEntity levelEntity) {
    // TODO: Grow State makes Snake stop for one interval
    timeWentBy = timeWentBy + timer.getDeltaTime();
    if (timeWentBy > TIME_TO_NEXT_MOVE) {
      timeWentBy = 0.0f;
      changeState(snake, direction, levelEntity);
      currentState.playSound();
      return currentState.update(snake);
    }
    return snake;
  }

  private void changeState(
      final Snake snake, final Direction direction, final LevelEntity levelEntity) {
    final SnakeState newState =
        currentState.handleStateTransition(snake, direction, levelEntity, this);
    if (newState != currentState) {
      previousState = currentState;
      currentState = newState;
    }
  }

  public SnakeState getMoveUp() {
    return moveUp;
  }

  public MoveDownState getMoveDown() {
    return moveDown;
  }

  public MoveLeftState getMoveLeft() {
    return moveLeft;
  }

  public MoveRightState getMoveRight() {
    return moveRight;
  }

  public GrowState getGrowState() {
    return growState;
  }

  public SnakeState getPreviousState() {
    return previousState;
  }
}
