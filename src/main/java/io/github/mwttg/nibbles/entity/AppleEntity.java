package io.github.mwttg.nibbles.entity;

import io.github.mwttg.nibbles.Constants;
import io.github.mwttg.nibbles.component.Position;
import org.joml.Matrix4f;

public class AppleEntity {

  private Position position;
  private int currentApple;
  private boolean isCurrentAppleEaten;

  private AppleEntity() {
    currentApple = 1;
    isCurrentAppleEaten = true;
  }

  public static AppleEntity initialize() {
    return new AppleEntity();
  }

  public Position getPosition() {
    return position;
  }

  public Matrix4f getTransforms() {
    return new Matrix4f().translate(position.x(), position.y(), Constants.APPLES_Z_LAYER);
  }

  public boolean isCurrentAppleEaten() {
    return isCurrentAppleEaten;
  }

  public void setCurrentAppleEaten() {
    isCurrentAppleEaten = true;
  }

  public void nextApple(final Position position) {
    isCurrentAppleEaten = false;
    this.position = position;
    currentApple = currentApple + 1;
  }

  public boolean isLastApple() {
    return currentApple == Constants.MAX_APPLES;
  }

  public boolean allApplesDone() {
    return currentApple == Constants.MAX_APPLES + 1;
  }
}
