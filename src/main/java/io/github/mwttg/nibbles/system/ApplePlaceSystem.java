package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.Constants;
import io.github.mwttg.nibbles.entity.LevelEntity;
import io.github.mwttg.nibbles.component.Position;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public final class ApplePlaceSystem {

  private ApplePlaceSystem() {}

  public static  Set<Position> placeAllApples(final LevelEntity levelEntity) {
    final Set<Position> wallPositions = levelEntity.getWalls();
    final Set<Position> applePositions = new HashSet<>();

    final Random random = new Random();
    for (int index = 0; index < Constants.MAX_APPLES; index++) {
      Position position;
      do {
        final int x = random.nextInt(Constants.MAX_X - Constants.MIN_X) + Constants.MIN_X;
        final int y = random.nextInt(Constants.MAX_Y - Constants.MIN_Y) + Constants.MIN_Y;
        position = new Position(x, y);
      } while (wallPositions.contains(position));
      applePositions.add(position);
    }

    return applePositions;
  }
}
