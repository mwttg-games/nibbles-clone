package io.github.mwttg.nibbles.snake;

import org.lwjgl.glfw.GLFW;

public class Keyboard {

  private Direction direction;

  public Keyboard() {
    this.direction = Direction.UP;
  }

  // TODO: BUG! if snake is moving UP and you press fast enough(e.g.) LEFT and then DOWN snake turn
  // 180 degree
  public Direction getDirection(final long windowId) {
    if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_UP) == GLFW.GLFW_PRESS
        && direction != Direction.DOWN) {
      direction = Direction.UP;
    }
    if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_DOWN) == GLFW.GLFW_PRESS
        && direction != Direction.UP) {
      direction = Direction.DOWN;
    }
    if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_LEFT) == GLFW.GLFW_PRESS
        && direction != Direction.RIGHT) {
      direction = Direction.LEFT;
    }
    if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_RIGHT) == GLFW.GLFW_PRESS
        && direction != Direction.LEFT) {
      direction = Direction.RIGHT;
    }

    return direction;
  }
}
