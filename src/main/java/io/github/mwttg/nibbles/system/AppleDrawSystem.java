package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.Constants;
import io.github.mwttg.nibbles.entity.AppleEntity;
import io.github.mwttg.nibbles.Assets;
import java.util.List;
import org.joml.Matrix4f;

public final class AppleDrawSystem {

  private AppleDrawSystem() {}

  public static void drawApples(final AppleEntity entity) {
    final List<Matrix4f> appleTransforms = entity.getTransforms();
    Assets.getInstance()
        .getSpriteApple()
        .draw(
            Assets.getInstance().getInstancedUniform(),
            appleTransforms,
            Constants.VIEW,
            Constants.PROJECTION);
  }
}
