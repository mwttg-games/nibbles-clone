package io.github.mwttg.nibbles.entity;

import io.github.mwttg.nibbles.Constants;
import java.util.List;
import java.util.Set;

import io.github.mwttg.nibbles.component.Position;
import org.joml.Matrix4f;

public class AppleEntity {

  private Set<Position> positions;

  private AppleEntity(final Set<Position> positions) {
    this.positions = positions;
  }

  public static AppleEntity initialize(final Set<Position> positions) {
    return new AppleEntity(positions);
  }

  public Set<Position> getPositions() {
    return positions;
  }

  public List<Matrix4f> getTransforms() {
    return positions.stream()
            .map(pos -> new Matrix4f().translate(pos.x(), pos.y(), Constants.APPLES_Z_LAYER))
            .toList();
  }

  public void removeApple(final Position position) {
    positions.remove(position);
  }
}
