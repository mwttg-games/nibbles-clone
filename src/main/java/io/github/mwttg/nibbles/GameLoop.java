package io.github.mwttg.nibbles;

import io.github.mwttg.nibbles.entity.LevelEntity;
import io.github.mwttg.nibbles.entity.SnakeEntity;
import io.github.mwttg.nibbles.entity.snake.Direction;
import io.github.mwttg.nibbles.snake.Keyboard;
import io.github.mwttg.nibbles.utilities.Assets;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL41;

public class GameLoop {

  private final Keyboard keyboard;
  private final LevelEntity levelEntity;
  private final SnakeEntity snakeEntity;

  GameLoop() {
    Assets.getInstance();
    this.keyboard = Keyboard.initialize();
    this.levelEntity = LevelEntity.initialize();
    this.snakeEntity = SnakeEntity.initialize(60, 10);
  }

  void execute(final long windowId) {
    while (!GLFW.glfwWindowShouldClose(windowId)) {

      final Direction direction = keyboard.getDirection(windowId);
      snakeEntity.update(direction);

      // render
      GL41.glClear(GL41.GL_COLOR_BUFFER_BIT | GL41.GL_DEPTH_BUFFER_BIT);

      levelEntity.draw();
      snakeEntity.draw();

      GLFW.glfwSwapBuffers(windowId);
      GLFW.glfwPollEvents();
    }
  }
}
