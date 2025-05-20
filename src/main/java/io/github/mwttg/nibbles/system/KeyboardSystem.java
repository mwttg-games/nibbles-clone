package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.component.Direction;
import org.lwjgl.glfw.GLFW;

public final class KeyboardSystem {

    private static Direction PREVIOUS = Direction.LEFT;

    private KeyboardSystem() {
    }

    public static Direction getDirection(final long windowId)  {

        if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_UP) == GLFW.GLFW_PRESS) {
            PREVIOUS = Direction.UP;
            return Direction.UP;
        }
        if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_DOWN) == GLFW.GLFW_PRESS) {
            PREVIOUS = Direction.DOWN;
            return Direction.DOWN;
        }
        if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_LEFT) == GLFW.GLFW_PRESS) {
            PREVIOUS = Direction.LEFT;
            return Direction.LEFT;
        }
        if (GLFW.glfwGetKey(windowId, GLFW.GLFW_KEY_RIGHT) == GLFW.GLFW_PRESS) {
            PREVIOUS = Direction.RIGHT;
            return Direction.RIGHT;
        }

        return PREVIOUS;
    }
}
