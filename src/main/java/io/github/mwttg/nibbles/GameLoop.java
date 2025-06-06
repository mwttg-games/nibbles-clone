package io.github.mwttg.nibbles;

import io.github.mwttg.nibbles.component.Assets;
import io.github.mwttg.nibbles.component.Direction;
import io.github.mwttg.nibbles.entity.AppleEntity;
import io.github.mwttg.nibbles.entity.LevelEntity;
import io.github.mwttg.nibbles.entity.SnakeEntity;
import io.github.mwttg.nibbles.system.*;
import io.github.mwttg.pixelartillery2d.timer.Timer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL41;

public class GameLoop {

  private Timer timer;
  private LevelEntity levelEntity;
  private SnakeEntity snakeEntity;
  private AppleEntity appleEntity;

  GameLoop() {
    Assets.getInstance();
    this.timer = Timer.initialize();
    this.levelEntity = LevelEntity.initialize();
    this.snakeEntity = SnakeEntity.initialize(levelEntity.getSnakeStartPosition());
    this.appleEntity = AppleEntity.initialize();
  }

  void execute(final long windowId) {
    while (!GLFW.glfwWindowShouldClose(windowId)) {

      // update
      final float deltaTime = timer.getDeltaTime();
      final Direction direction = KeyboardSystem.getDirection(windowId);

      SnakeCollisionSystem.checkCollision(snakeEntity, levelEntity);
      ApplePlaceSystem.placeApple(appleEntity, levelEntity, snakeEntity);
      SnakeMoveSystem.move(snakeEntity, direction, deltaTime);
      AppleEatSystem.eatApple(snakeEntity, appleEntity);

      // render
      GL41.glClear(GL41.GL_COLOR_BUFFER_BIT | GL41.GL_DEPTH_BUFFER_BIT);

      LevelDrawSystem.drawLevel(levelEntity);
      AppleDrawSystem.drawApples(appleEntity);
      SnakeDrawSystem.drawSnake(snakeEntity);
      UserMessageSystem.showMessage(windowId, snakeEntity, levelEntity, appleEntity);

      GLFW.glfwSwapBuffers(windowId);
      GLFW.glfwPollEvents();
    }
  }
}
