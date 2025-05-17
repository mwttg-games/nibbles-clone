package io.github.mwttg.nibbles.snake;

import io.github.mwttg.nibbles.entity.snake.Direction;
import org.lwjgl.glfw.GLFW;

public final class Keyboard {

  private Direction previous;

  private Keyboard() {
    this.previous = Direction.LEFT;
  }

  public static Keyboard initialize() {
    return new Keyboard();
  }

  public Direction getDirection(final long windowId) {
    if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_UP) == GLFW.GLFW_PRESS) {
      previous = Direction.UP;
      return Direction.UP;
    }
    if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_DOWN) == GLFW.GLFW_PRESS) {
      previous = Direction.DOWN;
      return Direction.DOWN;
    }
    if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_LEFT) == GLFW.GLFW_PRESS) {
      previous = Direction.LEFT;
      return Direction.LEFT;
    }
    if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_RIGHT) == GLFW.GLFW_PRESS) {
      previous = Direction.RIGHT;
      return Direction.RIGHT;
    }

    return previous;
  }
}
