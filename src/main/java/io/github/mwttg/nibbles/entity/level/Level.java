package io.github.mwttg.nibbles.entity.level;

import io.github.mwttg.nibbles.Constants;
import io.github.mwttg.nibbles.entity.Position;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.joml.Matrix4f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record Level(Set<Position> walls, Set<Position> apples) {

  private static final Logger LOG = LoggerFactory.getLogger(Level.class);

  public static Level initialize() {
    final Set<Position> walls = initializeWalls();
    final Set<Position> apples = initializeApples(walls);
    return new Level(walls, apples);
  }

  private static Set<Position> initializeWalls() {
    LOG.info("   Initialize Walls ...");
    return new HashSet<>();
  }

  private static Set<Position> initializeApples(final Set<Position> walls) {
    LOG.info("   Initialize Apples ...");
    final Random random = new Random();
    final Set<Position> result = new HashSet<>();

    for (int index = 0; index < Constants.MAX_APPLES; index++) {
      Position position;
      do {
        final int x = random.nextInt(Constants.MAX_X - Constants.MIN_X) + Constants.MIN_X;
        final int y = random.nextInt(Constants.MAX_Y - Constants.MIN_Y) + Constants.MIN_Y;
        position = new Position(x, y);
      } while (walls.contains(position));
      result.add(position);
    }

    return result;
  }

  public boolean isWallAtPosition(final Position position) {
    final Position normalizedPosition = removeFraction(position);
    return walls.contains(normalizedPosition);
  }

  public boolean isAppleAtPosition(final Position position) {
    final Position normalizedPosition = removeFraction(position);
    return apples.contains(normalizedPosition);
  }

  public void removeAppleFromPosition(final Position position) {
    final Position normalizedPosition = removeFraction(position);
    apples.remove(normalizedPosition);
  }

  private Position removeFraction(final Position position) {
    final int x = (int) position.x();
    final int y = (int) position.y();
    return new Position(x, y);
  }

  public List<Matrix4f> getAppleTransforms() {
    return apples.stream().map(apple -> apple.getTransform(Constants.APPLES_Z_LAYER)).toList();
  }

  public List<Matrix4f> getWallTransforms() {
    return walls.stream().map(wall -> wall.getTransform(Constants.WALLS_Z_LAYER)).toList();
  }
}
