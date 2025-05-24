package io.github.mwttg.nibbles.component;

import io.github.mwttg.pixelartillery2d.graphic.*;
import io.github.mwttg.pixelartillery2d.sound.Sound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assets {

  private static final Logger LOG = LoggerFactory.getLogger(Assets.class);
  private static Assets INSTANCE;

  private final Sprite messageDead;
  private final Sprite messageNext;
  private final Sprite messageWon;

  private final Sprite spriteBackground;
  private final Sprite spriteSnakeHeadUp;
  private final Sprite spriteSnakeHeadDown;
  private final Sprite spriteSnakeHeadLeft;
  private final Sprite spriteSnakeHeadRight;
  private final Sprite spriteLastApple;
  private final Sprite spriteSingleApple;

  private final InstancedStaticSprite spriteSnakeTail;
  private final InstancedStaticSprite spriteWall;

  private final Sound soundMove;
  private final Sound soundEat;
  private final Sound soundDead;

  private final int shaderId;
  private final Uniform uniform;
  private final int instancedShaderId;
  private final InstancedUniform instancedUniform;

  private Assets() {
    LOG.info("Load Game Assets...");

    this.shaderId =
        ShaderProgram.createFrom("./data/shaders/vertex.glsl", "./data/shaders/fragment.glsl");
    this.uniform = Uniform.create(shaderId);
    this.instancedShaderId =
        ShaderProgram.createFrom(
            "./data/shaders/vertex-instanced.glsl", "./data/shaders/fragment.glsl");
    this.instancedUniform = InstancedUniform.create(instancedShaderId);

    this.spriteBackground = StaticSprite.create(64, 36, "./data/sprites/background.png");

    this.messageDead = StaticSprite.create(15.0f, 5.0f, "./data/sprites/message_dead.png");
    this.messageNext = StaticSprite.create(15.0f, 5.0f, "./data/sprites/message_next.png");
    this.messageWon = StaticSprite.create(15.0f, 5.0f, "./data/sprites/message_won.png");

    this.spriteSnakeHeadUp = StaticSprite.create(1.0f, 1.0f, "./data/sprites/head_up.png");
    this.spriteSnakeHeadDown = StaticSprite.create(1.0f, 1.0f, "./data/sprites/head_down.png");
    this.spriteSnakeHeadLeft = StaticSprite.create(1.0f, 1.0f, "./data/sprites/head_left.png");
    this.spriteSnakeHeadRight = StaticSprite.create(1.0f, 1.0f, "./data/sprites/head_right.png");
    this.spriteSingleApple = StaticSprite.create(1.0f, 1.0f, "./data/sprites/apple.png");
    this.spriteLastApple = StaticSprite.create(1.0f, 1.0f, "./data/sprites/last_apple.png");

    this.spriteSnakeTail = InstancedStaticSprite.create(1.0f, 1.0f, "./data/sprites/tail.png");
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

  public Sprite getSpriteBackground() {
    return spriteBackground;
  }

  public Sprite getMessageDead() {
    return messageDead;
  }

  public Sprite getMessageNext() {
    return messageNext;
  }

  public Sprite getMessageWon() {
    return messageWon;
  }

  public Sprite getSpriteSnakeHeadUp() {
    return spriteSnakeHeadUp;
  }

  public Sprite getSpriteSnakeHeadDown() {
    return spriteSnakeHeadDown;
  }

  public Sprite getSpriteSnakeHeadLeft() {
    return spriteSnakeHeadLeft;
  }

  public Sprite getSpriteSnakeHeadRight() {
    return spriteSnakeHeadRight;
  }

  public Sprite getSpriteLastApple() {
    return spriteLastApple;
  }

  public Sprite getSpriteSingleApple() {
    return spriteSingleApple;
  }

  public InstancedStaticSprite getSpriteSnakeTail() {
    return spriteSnakeTail;
  }

  public InstancedStaticSprite getSpriteWall() {
    return spriteWall;
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
