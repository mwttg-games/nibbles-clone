package io.github.mwttg.nibbles.entity;

import io.github.mwttg.nibbles.Constants;
import io.github.mwttg.nibbles.component.Direction;
import io.github.mwttg.nibbles.component.Position;
import java.util.List;
import org.joml.Matrix4f;

public class SnakeEntity {

  private Position head;
  private List<Position> tail;
  private boolean isAlive;
  private Direction direction;
  private float deltaTimeSinceLastMove;

  private SnakeEntity(final int x, final int y) {
    this.head = new Position(x, y);
    this.tail = List.of(new Position(x + 1, y));
    this.isAlive = true;
    this.direction = Direction.LEFT;
    this.deltaTimeSinceLastMove = 0.0f;
  }

  public static SnakeEntity initialize(final int x, final int y) {
    return new SnakeEntity(x, y);
  }

  public void reset(final Position startPosition) {
    this.head = startPosition;
    this.tail = List.of(new Position(startPosition.x() + 1, startPosition.y()));
    this.isAlive = true;
    this.direction = Direction.LEFT;
    this.deltaTimeSinceLastMove = 0.0f;
  }

  public Position getHead() {
    return head;
  }

  public Matrix4f getHeadTransform() {
    return new Matrix4f().translate(head.x(), head.y(), Constants.SNAKE_Z_LAYER);
  }

  public void setHead(Position head) {
    this.head = head;
  }

  public List<Position> getTail() {
    return tail;
  }

  public List<Matrix4f> getTailTransforms() {
    return tail.stream()
        .map(pos -> new Matrix4f().translate(pos.x(), pos.y(), Constants.SNAKE_Z_LAYER))
        .toList();
  }

  public void setTail(List<Position> tail) {
    this.tail = tail;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void setAlive(boolean alive) {
    isAlive = alive;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public float getDeltaTimeSinceLastMove() {
    return deltaTimeSinceLastMove;
  }

  public void addDeltaTime(final float deltaTime) {
    deltaTimeSinceLastMove = deltaTimeSinceLastMove + deltaTime;
  }

  public void resetDeltaTime() {
    deltaTimeSinceLastMove = 0.0f;
  }
}
