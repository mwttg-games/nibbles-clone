package io.github.mwttg.nibbles;

import io.github.mwttg.nibbles.entity.LevelEntity;
import io.github.mwttg.nibbles.entity.SnakeEntity;
import io.github.mwttg.nibbles.entity.snake.Direction;
import io.github.mwttg.nibbles.utilities.Keyboard;
import io.github.mwttg.nibbles.utilities.Assets;
import io.github.mwttg.pixelartillery2d.timer.Timer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL41;

public class GameLoop {

  private final Timer timer;
  private final Keyboard keyboard;
  private final LevelEntity levelEntity;
  private final SnakeEntity snakeEntity;

  GameLoop() {
    Assets.getInstance();
    this.timer = Timer.initialize();
    this.keyboard = Keyboard.initialize();
    this.levelEntity = LevelEntity.initialize();
    this.snakeEntity = SnakeEntity.initialize(60, 10);
  }

  void execute(final long windowId) {
    while (!GLFW.glfwWindowShouldClose(windowId)) {

      final float deltaTime = timer.getDeltaTime();
      final Direction direction = keyboard.getDirection(windowId);
      snakeEntity.update(direction, levelEntity, deltaTime);

      // render
      GL41.glClear(GL41.GL_COLOR_BUFFER_BIT | GL41.GL_DEPTH_BUFFER_BIT);

      levelEntity.draw();
      snakeEntity.draw();

      GLFW.glfwSwapBuffers(windowId);
      GLFW.glfwPollEvents();
    }
  }
}
