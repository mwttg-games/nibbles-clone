package io.github.mwttg.nibbles.entity.level;

import io.github.mwttg.nibbles.entity.Position;

import java.util.Set;

public record WallsAndStartPosition(Set<Position> walls, Position start) {}
