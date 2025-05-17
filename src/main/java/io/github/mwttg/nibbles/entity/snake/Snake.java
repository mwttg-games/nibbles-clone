package io.github.mwttg.nibbles.entity.snake;

import io.github.mwttg.nibbles.Constants;
import io.github.mwttg.nibbles.entity.Position;
import java.util.ArrayList;
import java.util.List;
import org.joml.Matrix4f;

public record Snake(Position head, List<Position> tail) {

  public static Snake initialize(final int x, final int y) {
    final Position head = new Position(x, y);
    final Position tail = new Position(x + 1, y);
    return new Snake(head, List.of(tail));
  }

  public int getNormalizedX() {
    return (int) head.x();
  }

  public int getNormalizedY() {
    return (int) head.y();
  }

  public Snake move(final Direction direction) {
    final List<Position> newTail = moveTail();
    final Position newHead = moveHead(direction);
    return new Snake(newHead, newTail);
  }

  public Snake grow(final int units) {
    final List<Position> newTail = new ArrayList<>(tail);
    final Position add = tail.getLast();
    for (int step = 0; step < units; step++) {
      newTail.addLast(add);
    }
    return new Snake(head, newTail);
  }

  private Position moveHead(final Direction direction) {
    return switch (direction) {
      case UP -> new Position(head.x(), head.y() + 1.0f);
      case DOWN -> new Position(head.x(), head.y() - 1.0f);
      case LEFT -> new Position(head.x() - 1.0f, head.y());
      case RIGHT -> new Position(head.x() + 1.0f, head.y());
    };
  }

  private List<Position> moveTail() {
    final List<Position> result = new ArrayList<>(tail);
    result.addFirst(head);
    result.removeLast();
    return result;
  }

  public Matrix4f getHeadTransform() {
    return head.getTransform(Constants.SNAKE_Z_LAYER);
  }

  public List<Matrix4f> getTailTransforms() {
    return tail.stream().map(tail -> tail.getTransform(Constants.SNAKE_Z_LAYER)).toList();
  }

  public boolean doesBitOwnTail() {
    return tail.contains(head);
  }
}
