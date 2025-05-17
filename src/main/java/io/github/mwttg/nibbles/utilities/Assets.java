package io.github.mwttg.nibbles.utilities;

import io.github.mwttg.pixelartillery2d.graphic.*;
import io.github.mwttg.pixelartillery2d.sound.Sound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assets {

  private static final Logger LOG = LoggerFactory.getLogger(Assets.class);
  private static Assets INSTANCE;

  private final StaticSprite spriteBackground;
  private final StaticSprite spriteSnakeHeadUp;
  private final StaticSprite spriteSnakeHeadDown;
  private final StaticSprite spriteSnakeHeadLeft;
  private final StaticSprite spriteSnakeHeadRight;

  private final InstancedStaticSprite spriteSnakeTail;
  private final InstancedStaticSprite spriteWall;
  private final InstancedStaticSprite spriteApple;

  private final Sound soundMove;
  private final Sound soundEat;
  private final Sound soundDead;

  private final int shaderId;
  private final Uniform uniform;
  private final int instancedShaderId;
  private final InstancedUniform instancedUniform;

  private Assets() {
    LOG.info("Load Game Assets...");

    this.shaderId = ShaderProgram.createDefaultShader();
    this.uniform = Uniform.create(shaderId);
    this.instancedShaderId = ShaderProgram.createDefaultInstancedShader();
    this.instancedUniform = InstancedUniform.create(instancedShaderId);

    this.spriteBackground = StaticSprite.create(64, 36, "./data/sprites/background.png");

    this.spriteSnakeHeadUp = StaticSprite.create(1.0f, 1.0f, "./data/sprites/head_up.png");
    this.spriteSnakeHeadDown = StaticSprite.create(1.0f, 1.0f, "./data/sprites/head_down.png");
    this.spriteSnakeHeadLeft = StaticSprite.create(1.0f, 1.0f, "./data/sprites/head_left.png");
    this.spriteSnakeHeadRight = StaticSprite.create(1.0f, 1.0f, "./data/sprites/head_right.png");

    this.spriteSnakeTail = InstancedStaticSprite.create(1.0f, 1.0f, "./data/sprites/tail.png");
    this.spriteApple = InstancedStaticSprite.create(1.0f, 1.0f, "./data/sprites/apple.png");
    this.spriteWall = InstancedStaticSprite.create(1.0f, 1.0f, "./data/sprites/wall.png");

    this.soundMove = Sound.create("./data/sounds/move.wav");
    this.soundEat = Sound.create("./data/sounds/eat.wav");
    this.soundDead = Sound.create("./data/sounds/dead.wav");
  }

  public static Assets getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Assets();
    }

    return INSTANCE;
  }

  public int getShaderId() {
    return shaderId;
  }

  public Uniform getUniform() {
    return uniform;
  }

  public int getInstancedShaderId() {
    return instancedShaderId;
  }

  public InstancedUniform getInstancedUniform() {
    return instancedUniform;
  }

  public StaticSprite getSpriteBackground() {
    return spriteBackground;
  }

  public StaticSprite getSpriteSnakeHeadUp() {
    return spriteSnakeHeadUp;
  }

  public StaticSprite getSpriteSnakeHeadDown() {
    return spriteSnakeHeadDown;
  }

  public StaticSprite getSpriteSnakeHeadLeft() {
    return spriteSnakeHeadLeft;
  }

  public StaticSprite getSpriteSnakeHeadRight() {
    return spriteSnakeHeadRight;
  }

  public InstancedStaticSprite getSpriteSnakeTail() {
    return spriteSnakeTail;
  }

  public InstancedStaticSprite getSpriteWall() {
    return spriteWall;
  }

  public InstancedStaticSprite getSpriteApple() {
    return spriteApple;
  }

  public Sound getSoundMove() {
    return soundMove;
  }

  public Sound getSoundEat() {
    return soundEat;
  }

  public Sound getSoundDead() {
    return soundDead;
  }
}
