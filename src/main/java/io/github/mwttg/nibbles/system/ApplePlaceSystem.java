package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.component.Constants;
import io.github.mwttg.nibbles.component.Position;
import io.github.mwttg.nibbles.entity.AppleEntity;
import io.github.mwttg.nibbles.entity.LevelEntity;
import io.github.mwttg.nibbles.entity.SnakeEntity;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public final class ApplePlaceSystem {

  private ApplePlaceSystem() {}

  public static void placeApple(
      final AppleEntity appleEntity, final LevelEntity levelEntity, final SnakeEntity snakeEntity) {
    if (!appleEntity.isCurrentAppleEaten()) {
      return;
    }

    final Random random = new Random();
    final Set<Position> wallPositions = levelEntity.getWalls();
    final Set<Position> tailPositions = new HashSet<>(snakeEntity.getTail());
    final Position headPosition = snakeEntity.getHead();
    Position position;
    do {
      final int x = random.nextInt(Constants.MAX_X - Constants.MIN_X) + Constants.MIN_X;
      final int y = random.nextInt(Constants.MAX_Y - Constants.MIN_Y) + Constants.MIN_Y;
      position = new Position(x, y);
    } while (wallPositions.contains(position)
        || tailPositions.contains(position)
        || headPosition.equals(position));

    appleEntity.nextApple(position);
  }
}
