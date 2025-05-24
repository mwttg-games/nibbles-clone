package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.component.Assets;
import io.github.mwttg.nibbles.component.Constants;
import io.github.mwttg.nibbles.component.Position;
import io.github.mwttg.nibbles.entity.LevelEntity;
import io.github.mwttg.nibbles.entity.SnakeEntity;
import java.util.List;
import java.util.Set;

public final class SnakeCollisionSystem {

  private SnakeCollisionSystem() {}

  public static void checkCollision(final SnakeEntity snakeEntity, final LevelEntity levelEntity) {
    final Position head = snakeEntity.getHead();
    final boolean doesHitBorder = doesSnakeHeadHitsLevelBorder(head);

    final Set<Position> walls = levelEntity.getWalls();
    final boolean doesHitWall = doesSnakeHeadHitsLevelWall(head, walls);

    final List<Position> tail = snakeEntity.getTail();
    final boolean doesHitTail = doesSnakeHitsOwnTail(head, tail);

    if (!doesHitBorder && !doesHitWall && !doesHitTail) {
      return;
    }

    if (!snakeEntity.isAlive()) {
      return;
    }

    Assets.getInstance().getSoundDead().play();
    snakeEntity.setAlive(false);
  }

  private static boolean doesSnakeHeadHitsLevelBorder(final Position head) {
    if (head.x() == Constants.MIN_X - 1) { // left Level border
      return true;
    }
    if (head.x() == Constants.MAX_X) { // right Level border
      return true;
    }
    if (head.y() == Constants.MIN_Y - 1) { // bottom Level border
      return true;
    }
    if (head.y() == Constants.MAX_Y) { // top Level border
      return true;
    }

    return false;
  }

  private static boolean doesSnakeHeadHitsLevelWall(
      final Position head, final Set<Position> walls) {
    return walls.contains(head);
  }

  private static boolean doesSnakeHitsOwnTail(final Position head, final List<Position> tail) {
    return tail.contains(head);
  }
}
