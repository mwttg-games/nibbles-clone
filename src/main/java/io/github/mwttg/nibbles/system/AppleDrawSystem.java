package io.github.mwttg.nibbles.system;

import io.github.mwttg.nibbles.Assets;
import io.github.mwttg.nibbles.Constants;
import io.github.mwttg.nibbles.entity.AppleEntity;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL41;

public class AppleDrawSystem {

  private AppleDrawSystem() {}

  public static void drawApples(final AppleEntity appleEntity) {
    final Matrix4f transform = appleEntity.getTransforms();

    GL41.glUseProgram(Assets.getInstance().getShaderId());

    if (appleEntity.isLastApple()) {
      Assets.getInstance()
          .getSpriteLastApple()
          .draw(Assets.getInstance().getUniform(), transform, Constants.VIEW, Constants.PROJECTION);
      return;
    }

    Assets.getInstance()
        .getSpriteSingleApple()
        .draw(Assets.getInstance().getUniform(), transform, Constants.VIEW, Constants.PROJECTION);
  }
}
