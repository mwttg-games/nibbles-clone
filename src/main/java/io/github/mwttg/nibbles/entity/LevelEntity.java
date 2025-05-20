package io.github.mwttg.nibbles.entity;

import io.github.mwttg.nibbles.Constants;
import java.util.List;
import java.util.Set;

import io.github.mwttg.nibbles.component.Position;
import io.github.mwttg.nibbles.component.Rooms;
import org.joml.Matrix4f;

public class LevelEntity {

  private Set<Position> walls;

  private LevelEntity(final Set<Position> walls) {
    this.walls = walls;
  }

  public static LevelEntity initialize() {
    return new LevelEntity(Rooms.level1().walls());
  }

  public Set<Position> getWalls() {
    return walls;
  }

  public List<Matrix4f> getWallTransforms() {
    return walls.stream()
        .map(pos -> new Matrix4f().translate(pos.x(), pos.y(), Constants.WALLS_Z_LAYER))
        .toList();
  }
}
