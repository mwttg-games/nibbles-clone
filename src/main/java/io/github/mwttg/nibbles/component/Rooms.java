package io.github.mwttg.nibbles.component;

import java.util.HashSet;
import java.util.Set;

public final class Rooms {

  //    private final Map<Integer, WallsAndStartPosition> roomsById;

  private Rooms() {
    //        roomsById = new HashMap<>();
    //        roomsById.put(1, level1());
    //        roomsById.put(2, level2());
  }

  //    public static Rooms initialize() {
  //        return new Rooms();
  //    }

  //    public Map<Integer, WallsAndStartPosition> getRoomsById() {
  //        return roomsById;
  //    }

  public static WallsAndStartPosition level1() {
    Set<Position> walls = new HashSet<>();
    for (int i = 12; i < 55; i++) {
      walls.add(new Position(i, 17));
    }
    return new WallsAndStartPosition(walls, new Position(32, 10));
  }

  public static WallsAndStartPosition level2() {
    Set<Position> walls = new HashSet<>();
    for (int i = 8; i < 28; i++) {
      walls.add(new Position(10, i));
      walls.add(new Position(54, i));
    }
    return new WallsAndStartPosition(walls, new Position(32, 18));
  }

  public static WallsAndStartPosition level3() {
    Set<Position> walls = new HashSet<>();
    for (int i = 0; i < 30; i++) {
      walls.add(new Position(i + 1, 10));
      walls.add(new Position(64 - 1 - i, 26));
    }
    for (int i = 0; i < 20; i++) {
      walls.add(new Position(54, i + 1));
      walls.add(new Position(10, 36 - 1 - i));
    }
    return new WallsAndStartPosition(walls, new Position(32, 18));
  }

  public static WallsAndStartPosition level4() {
    Set<Position> walls = new HashSet<>();
    for (int i = 0; i < 41; i++) {
      walls.add(new Position(i + 12, 7));
      walls.add(new Position(64 - 12 - i, 29));
    }
    for (int i = 0; i < 19; i++) {
      walls.add(new Position(54, i + 9));
      walls.add(new Position(10, 36 - 9 - i));
    }
    return new WallsAndStartPosition(walls, new Position(32, 18));
  }

  public static WallsAndStartPosition level5() {
    Set<Position> walls = new HashSet<>();
    for (int i = 0; i < 31; i++) {
      walls.add(new Position(8, i));
      walls.add(new Position(16, 36 - i));
      walls.add(new Position(24, i));
      walls.add(new Position(32, 36 - i));
      walls.add(new Position(40, i));
      walls.add(new Position(48, 36 - i));
      walls.add(new Position(56, i));
    }
    return new WallsAndStartPosition(walls, new Position(36, 3));
  }

  public static WallsAndStartPosition level6() {
    Set<Position> walls = new HashSet<>();
    for (int i = 0; i < 36; i = i + 2) {
      walls.add(new Position(32, i));
    }
    return new WallsAndStartPosition(walls, new Position(36, 3));
  }

  public static WallsAndStartPosition level7() {
    Set<Position> walls = new HashSet<>();
    for (int i = 0; i < 28; i++) {
      walls.add(new Position(i + 4, i + 4));
      walls.add(new Position(59 - i, 31 - i));
    }
    return new WallsAndStartPosition(walls, new Position(36, 3));
  }

  public static WallsAndStartPosition level8() {
    Set<Position> walls = new HashSet<>();
    for (int i = 1; i < 35; i = i + 2) {
      walls.add(new Position(8, i));
      walls.add(new Position(16, i + 1));
      walls.add(new Position(24, i));
      walls.add(new Position(32, i + 1));
      walls.add(new Position(40, i));
      walls.add(new Position(48, i + 1));
      walls.add(new Position(56, i));
    }
    return new WallsAndStartPosition(walls, new Position(36, 3));
  }
}
