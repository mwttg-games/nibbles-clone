package io.github.mwttg.nibbles.component;

import org.joml.Matrix4f;

public interface Constants {

  // OpenGL Misc
  int WIDTH = 1920;
  int HEIGHT = 1080;
  float NEAR_PLANE = 0.01f;
  float FAR_PLANE = 301.0f;
  int TILE_WIDTH = 10;
  int TILE_HEIGHT = 10;

  // used resolution 1920x1080 scaled to 640x360 using a grid of 10x10 pixels
  // one Tile = 10x10 --> Screen 64x36 Tiles
  int SCALED_RESOLUTION_X = 640;
  int SCALED_RESOLUTION_Y = 360;
  float RIGHT = (float) SCALED_RESOLUTION_X / Constants.TILE_WIDTH; // 64
  float TOP = (float) SCALED_RESOLUTION_Y / Constants.TILE_HEIGHT; // 36

  Matrix4f PROJECTION =
      new Matrix4f().setOrtho(0.0f, RIGHT, 0.0f, TOP, Constants.NEAR_PLANE, Constants.FAR_PLANE);
  Matrix4f VIEW = new Matrix4f().setLookAt(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);

  // SNAKE
  float SNAKE_Z_LAYER = -1.0f;
  float SNAKE_TIME_TO_NEXT_MOVE = 0.15f;

  // APPLES
  int MAX_APPLES = 10;
  float APPLES_Z_LAYER = -2.0f;

  // WALLS
  float WALLS_Z_LAYER = -2.0f;

  // LEVEL
  int MIN_X = 1;
  int MAX_X = (SCALED_RESOLUTION_X / TILE_WIDTH) - 1;
  int MIN_Y = 1;
  int MAX_Y = (SCALED_RESOLUTION_Y / TILE_WIDTH) - 1;
  float LEVEL_Z_LAYER = -3.0f;

  // SOUND
  float VOLUME = 0.15f;

  // MESSAGES
  float MESSAGE_Z_LAYER = -0.5f;
  Matrix4f MESSAGE_TRANSFORM = new Matrix4f().translate(25.0f, 16.0f, MESSAGE_Z_LAYER);
}
