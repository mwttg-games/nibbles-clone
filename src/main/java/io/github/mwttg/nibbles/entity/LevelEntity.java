package io.github.mwttg.nibbles.entity;

import io.github.mwttg.nibbles.component.Constants;
import io.github.mwttg.nibbles.component.Levels;
import io.github.mwttg.nibbles.component.Position;
import java.util.List;
import java.util.Set;
import org.joml.Matrix4f;

public class LevelEntity {

  private Set<Position> walls;
  private int currentLevel;

  private LevelEntity() {
    this.currentLevel = 1;
    this.walls = Levels.LEVEL_BY_ID.get(currentLevel).walls();
  }

  public static LevelEntity initialize() {
    return new LevelEntity();
  }

  public void reset() {
    this.currentLevel = 1;
    this.walls = Levels.LEVEL_BY_ID.get(currentLevel).walls();
  }

  public void nextLevel() {
    currentLevel = currentLevel + 1;
    walls = Levels.LEVEL_BY_ID.get(currentLevel).walls();
  }

  public Position getSnakeStartPosition() {
    return Levels.LEVEL_BY_ID.get(currentLevel).start();
  }

  public boolean isLastLevel() {
    return currentLevel == Levels.LAST_LEVEL;
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
