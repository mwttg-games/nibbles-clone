package io.github.mwttg.nibbles.entity;

import org.joml.Matrix4f;

public record Position(float x, float y) {

  public Matrix4f getTransform(final float z) {
    return new Matrix4f().translate(x, y, z);
  }
}
