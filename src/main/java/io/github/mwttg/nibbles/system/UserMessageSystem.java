package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.component.Assets;
import io.github.mwttg.nibbles.component.Constants;
import io.github.mwttg.nibbles.component.Position;
import io.github.mwttg.nibbles.entity.AppleEntity;
import io.github.mwttg.nibbles.entity.LevelEntity;
import io.github.mwttg.nibbles.entity.SnakeEntity;
import org.lwjgl.glfw.GLFW;

public final class UserMessageSystem {

  private UserMessageSystem() {}

  public static void showMessage(
      final long windowId,
      final SnakeEntity snakeEntity,
      final LevelEntity levelEntity,
      final AppleEntity appleEntity) {
    if (snakeEntity.isDead()) {
      deadMessage(windowId, snakeEntity, levelEntity, appleEntity);
    }

    if (appleEntity.allApplesDone() && !levelEntity.isLastLevel()) {
      snakeEntity.stopSnake();
      nextMessage(windowId, snakeEntity, levelEntity, appleEntity);
    }

    if (appleEntity.allApplesDone() && levelEntity.isLastLevel()) {
      snakeEntity.stopSnake();
      wonMessage();
    }
  }

  private static void wonMessage() {
    Assets.getInstance()
        .getMessageWon()
        .draw(
            Assets.getInstance().getUniform(),
            Constants.MESSAGE_TRANSFORM,
            Constants.VIEW,
            Constants.PROJECTION);
  }

  private static void nextMessage(
      final long windowId,
      final SnakeEntity snakeEntity,
      final LevelEntity levelEntity,
      final AppleEntity appleEntity) {
    Assets.getInstance()
        .getMessageNext()
        .draw(
            Assets.getInstance().getUniform(),
            Constants.MESSAGE_TRANSFORM,
            Constants.VIEW,
            Constants.PROJECTION);

    if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_ENTER) == GLFW.GLFW_PRESS) {
      levelEntity.nextLevel();
      final Position startPosition = levelEntity.getSnakeStartPosition();
      snakeEntity.reset(startPosition);
      appleEntity.reset();
      KeyboardSystem.reset();
    }
  }

  private static void deadMessage(
      final long windowId,
      final SnakeEntity snakeEntity,
      final LevelEntity levelEntity,
      final AppleEntity appleEntity) {
    Assets.getInstance()
        .getMessageDead()
        .draw(
            Assets.getInstance().getUniform(),
            Constants.MESSAGE_TRANSFORM,
            Constants.VIEW,
            Constants.PROJECTION);

    if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_ENTER) == GLFW.GLFW_PRESS) {
      KeyboardSystem.reset();
      levelEntity.reset();
      snakeEntity.reset(levelEntity.getSnakeStartPosition());
      appleEntity.reset();
    }
  }
}
