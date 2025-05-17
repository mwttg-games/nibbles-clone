package io.github.mwttg.nibbles.entity.snake.state;

import io.github.mwttg.nibbles.entity.snake.Direction;
import io.github.mwttg.nibbles.entity.snake.Snake;
import io.github.mwttg.pixelartillery2d.timer.Timer;

public class SnakeStateManager {

  private static final float TIME_TO_NEXT_MOVE = 0.15f;

  private final SnakeState moveUp;
  private final MoveDownState moveDown;
  private final MoveLeftState moveLeft;
  private final MoveRightState moveRight;

  private SnakeState previousState;
  private SnakeState currentState;
  private float timeWentBy;

  private final Timer timer;

  private SnakeStateManager(
      final SnakeState moveUp,
      final MoveDownState moveDown,
      final MoveLeftState moveLeft,
      final MoveRightState moveRight) {
    this.moveUp = moveUp;
    this.moveDown = moveDown;
    this.moveLeft = moveLeft;
    this.moveRight = moveRight;
    this.previousState = moveLeft;
    this.currentState = moveLeft;
    this.timer = Timer.initialize();
    this.timeWentBy = 0.0f;
  }

  public static SnakeStateManager initialize() {
    return new SnakeStateManager(
        new MoveUpState(), new MoveDownState(), new MoveLeftState(), new MoveRightState());
  }

  public void draw(final Snake snake) {
    currentState.draw(snake);
  }

  public Snake update(final Snake snake, final Direction direction) {
    timeWentBy = timeWentBy + timer.getDeltaTime();
    if (timeWentBy > TIME_TO_NEXT_MOVE) {
      timeWentBy = 0.0f;
      changeState(snake, direction);
      currentState.playSound();
      return currentState.update(snake);
    }
    return snake;
  }

  private void changeState(final Snake snake, final Direction direction) {
    final SnakeState newState = currentState.handleStateTransition(snake, direction, this);
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
}
