package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.component.Assets;
import io.github.mwttg.nibbles.component.Position;
import io.github.mwttg.nibbles.entity.AppleEntity;
import io.github.mwttg.nibbles.entity.SnakeEntity;
import java.util.ArrayList;
import java.util.List;

public final class AppleEatSystem {

  private static final int GROW_UNITS = 5;

  private AppleEatSystem() {}

  public static void eatApple(final SnakeEntity snakeEntity, final AppleEntity appleEntity) {
    final Position head = snakeEntity.getHead();
    final List<Position> tail = snakeEntity.getTail();
    final Position apple = appleEntity.getPosition();

    if (!apple.equals(head)) {
      return;
    }

    Assets.getInstance().getSoundEat().play();
    appleEntity.setCurrentAppleEaten();
    final List<Position> newTail = growSnakeTail(tail);
    snakeEntity.setTail(newTail);
  }

  private static List<Position> growSnakeTail(final List<Position> oldTail) {
    final List<Position> newTail = new ArrayList<>(oldTail);
    final Position addPosition = oldTail.getLast();
    for (int step = 0; step < GROW_UNITS; step++) {
      newTail.addLast(addPosition);
    }
    return newTail;
  }
}
