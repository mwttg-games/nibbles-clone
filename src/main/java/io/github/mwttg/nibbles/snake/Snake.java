package io.github.mwttg.nibbles.snake;

import io.github.mwttg.pixelartillery2d.graphic.Sprite;
import io.github.mwttg.pixelartillery2d.graphic.StaticSprite;
import io.github.mwttg.pixelartillery2d.graphic.Uniform;
import org.joml.Matrix4f;

public class Snake {

  private static final float Z = 0.0f;

  private final Uniform uniform;
  private final Matrix4f view;
  private final Matrix4f projection;
  private final Sprite sprite;

  private float x;
  private float y;
  private float updateTime;

  public Snake(final Uniform uniform, final Matrix4f view, final Matrix4f projection) {
    this.uniform = uniform;
    this.view = view;
    this.projection = projection;
    this.sprite = StaticSprite.create(1.0f, 1.0f, "./data/sprites/snake.png");

    this.x = 32.0f;
    this.y = 18.0f;
    this.updateTime = 0.3f;
  }

  public void draw() {
    final Matrix4f model = new Matrix4f().translate(x, y, Z);
    sprite.draw(uniform, model, view, projection);
  }

  public void update(final Direction direction, final float deltaTime) {
    updateTime = updateTime + deltaTime;

    if (updateTime > 0.3f) { // TODO make 0.3f dynamic to increase speed

      switch (direction) {
        case UP -> y = y + 1.0f;
        case DOWN -> y = y - 1.0f;
        case LEFT -> x = x - 1.0f;
        case RIGHT -> x = x + 1.0f;
      }

      updateTime = 0.0f;
    }
  }
}
