package io.github.mwttg.nibbles;

import io.github.mwttg.nibbles.utilities.Timer;
import io.github.mwttg.pixelartillery2d.graphic.ShaderProgram;
import io.github.mwttg.pixelartillery2d.graphic.Sprite;
import io.github.mwttg.pixelartillery2d.graphic.StaticSprite;
import io.github.mwttg.pixelartillery2d.graphic.Uniform;
import org.joml.Matrix4f;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL41;

public class GameLoop {

  private final Timer timer;
  private final int shaderId;
  private final Uniform uniform;
  private final Matrix4f projection;
  private final Matrix4f view;

  GameLoop() {
    this.timer = Timer.initialize();
    this.shaderId = ShaderProgram.createDefaultShader();
    this.uniform = Uniform.create(shaderId);

    this.projection =
        new Matrix4f()
            .setOrtho(0.0f, 20.0f, 0.0f, 10.0f, Constants.NEAR_PLANE, Constants.FAR_PLANE);
    this.view = new Matrix4f().setLookAt(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
  }

  void execute(final long windowId) {
    final Sprite testSprite = StaticSprite.create(20.0f, 10.0f, "./data/sprites/test.png");
    final Matrix4f model = new Matrix4f().translate(0.0f, 0.0f, -1.0f);

    while (!GLFW.glfwWindowShouldClose(windowId)) {
      // timing
      final var deltaTime = timer.getDeltaTime();

      // input

      // physics

      // render
      GL41.glClear(GL41.GL_COLOR_BUFFER_BIT | GL41.GL_DEPTH_BUFFER_BIT);
      GL41.glUseProgram(shaderId);

      testSprite.draw(uniform, model, view, projection);

      GLFW.glfwSwapBuffers(windowId);
      GLFW.glfwPollEvents();
    }
  }
}
