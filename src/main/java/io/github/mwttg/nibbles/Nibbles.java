package io.github.mwttg.nibbles;

import io.github.mwttg.nibbles.component.Constants;
import io.github.mwttg.pixelartillery2d.cleanup.CleanUp;
import io.github.mwttg.pixelartillery2d.graphic.GameWindow;
import io.github.mwttg.pixelartillery2d.graphic.OpenGlConfiguration;
import io.github.mwttg.pixelartillery2d.sound.SoundDevice;
import io.github.mwttg.pixelartillery2d.sound.SoundListener;
import org.lwjgl.glfw.GLFW;

public class Nibbles {

  public static void main(final String[] args) {
    SoundDevice.initialize();
    SoundListener.setGain(Constants.VOLUME);

    final long windowId = GameWindow.create(openGlConfiguration());
    GLFW.glfwSetInputMode(windowId, GLFW.GLFW_CURSOR, GLFW.GLFW_CURSOR_HIDDEN);
    final GameLoop gameLoop = new GameLoop();
    gameLoop.execute(windowId);

    CleanUp.purge();
  }

  public static OpenGlConfiguration openGlConfiguration() {
    return new OpenGlConfiguration(
        "Nibbles",
        Constants.WIDTH,
        Constants.HEIGHT,
        true,
        true,
        Constants.NEAR_PLANE,
        Constants.FAR_PLANE);
  }
}
