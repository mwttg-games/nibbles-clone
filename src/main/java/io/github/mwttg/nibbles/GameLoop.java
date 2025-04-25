package io.github.mwttg.nibbles;

import io.github.mwttg.nibbles.snake.Direction;
import io.github.mwttg.nibbles.snake.Keyboard;
import io.github.mwttg.nibbles.snake.Snake;
import io.github.mwttg.nibbles.utilities.Timer;
import io.github.mwttg.pixelartillery2d.graphic.ShaderProgram;
import io.github.mwttg.pixelartillery2d.graphic.Uniform;
import org.joml.Matrix4f;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL41;

public class GameLoop {

  // used resolution 1920x1080 scaled to 640x360 using a grid of 10x10 pixels
  // one Tile = 10x10 --> Screen 64x45 Tiles
  private static final float RIGHT = 640.0f / Constants.TILE_WIDTH; // 64
  private static final float TOP = 360.0f / Constants.TILE_HEIGHT; // 45

  private final Timer timer;
  private final int shaderId;

  private final Keyboard keyboard;
  private final Snake snake;

  GameLoop() {
    this.timer = Timer.initialize();
    this.shaderId = ShaderProgram.createDefaultShader();

    final Uniform uniform = Uniform.create(shaderId);
    final Matrix4f projection =
        new Matrix4f().setOrtho(0.0f, RIGHT, 0.0f, TOP, Constants.NEAR_PLANE, Constants.FAR_PLANE);
    final Matrix4f view =
        new Matrix4f().setLookAt(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);

    this.keyboard = new Keyboard();
    this.snake = new Snake(uniform, view, projection);
  }

  void execute(final long windowId) {
    while (!GLFW.glfwWindowShouldClose(windowId)) {
      // timing
      final var deltaTime = timer.getDeltaTime();

      final Direction direction = keyboard.getDirection(windowId);

      // physics
      snake.update(direction, deltaTime);

      // render
      GL41.glClear(GL41.GL_COLOR_BUFFER_BIT | GL41.GL_DEPTH_BUFFER_BIT);
      GL41.glUseProgram(shaderId);

      snake.draw();

      GLFW.glfwSwapBuffers(windowId);
      GLFW.glfwPollEvents();
    }
  }
}
