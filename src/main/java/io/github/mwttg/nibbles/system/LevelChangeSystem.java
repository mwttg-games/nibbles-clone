package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.component.Position;
import io.github.mwttg.nibbles.entity.AppleEntity;
import io.github.mwttg.nibbles.entity.LevelEntity;
import io.github.mwttg.nibbles.entity.SnakeEntity;

public final class LevelChangeSystem {

  private LevelChangeSystem() {}

  public static void changeLevel(
      final SnakeEntity snakeEntity, final LevelEntity levelEntity, final AppleEntity appleEntity) {
    if (!appleEntity.allApplesDone()) {
      return;
    }

    levelEntity.nextLevel();
    final Position startPosition = levelEntity.getSnakeStartPosition();
    snakeEntity.reset(startPosition);
    appleEntity.reset();
    KeyboardSystem.reset();
  }
}
