package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.component.Constants;
import io.github.mwttg.nibbles.component.Position;
import io.github.mwttg.nibbles.entity.AppleEntity;
import io.github.mwttg.nibbles.entity.LevelEntity;
import java.util.Random;
import java.util.Set;

public final class ApplePlaceSystem {

  private ApplePlaceSystem() {}

  public static void placeApple(final AppleEntity appleEntity, final LevelEntity levelEntity) {
    if (!appleEntity.isCurrentAppleEaten()) {
      return;
    }

    final Random random = new Random();
    final Set<Position> wallPositions = levelEntity.getWalls();
    Position position;
    do {
      final int x = random.nextInt(Constants.MAX_X - Constants.MIN_X) + Constants.MIN_X;
      final int y = random.nextInt(Constants.MAX_Y - Constants.MIN_Y) + Constants.MIN_Y;
      position = new Position(x, y);
    } while (wallPositions.contains(position));

    appleEntity.nextApple(position);
  }
}
