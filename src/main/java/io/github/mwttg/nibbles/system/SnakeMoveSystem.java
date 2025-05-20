package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.Constants;
import io.github.mwttg.nibbles.component.Position;
import io.github.mwttg.nibbles.entity.SnakeEntity;
import io.github.mwttg.nibbles.component.Direction;
import io.github.mwttg.nibbles.Assets;

import java.util.ArrayList;
import java.util.List;

public final class SnakeMoveSystem {

  private SnakeMoveSystem() {}

  public static void move(
      final SnakeEntity snakeEntity, final Direction direction, final float deltaTime) {
    snakeEntity.addDeltaTime(deltaTime);
    final float deltaTimeSinceLastMove = snakeEntity.getDeltaTimeSinceLastMove();

    if (!snakeEntity.isAlive()) {
      return;
    }

    if (deltaTimeSinceLastMove < Constants.SNAKE_TIME_TO_NEXT_MOVE) {
      return;
    }

    Assets.getInstance().getSoundMove().play();
    snakeEntity.resetDeltaTime();
    snakeEntity.setDirection(direction);

    final Position oldHead = snakeEntity.getHead();
    final Position newHead = moveHead(direction, oldHead);

    final List<Position> oldTail = snakeEntity.getTail();
    final List<Position> newTail = moveTail(oldHead, oldTail);

    snakeEntity.setHead(newHead);
    snakeEntity.setTail(newTail);
  }

  private static Position moveHead(final Direction direction, final Position head) {
    return switch (direction) {
      case UP -> new Position(head.x(), head.y() + 1);
      case DOWN -> new Position(head.x(), head.y() - 1);
      case LEFT -> new Position(head.x() - 1, head.y());
      case RIGHT -> new Position(head.x() + 1, head.y());
    };
  }

  private static List<Position> moveTail(final Position head, final List<Position> tail) {
    final List<Position> result = new ArrayList<>(tail);
    result.addFirst(head);
    result.removeLast();
    return result;
  }
}
