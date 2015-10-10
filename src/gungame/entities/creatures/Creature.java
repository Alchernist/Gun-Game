package gungame.entities.creatures;

import gungame.entities.Entity;
import gungame.game.Handler;

public abstract class Creature extends Entity {
	
	public static final int DEFAULT_HEALTH = 1;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 200,
							DEFAULT_CREATURE_HEIGHT = 200;
	
	protected int health;
	protected float speed;
	protected int lastDirection;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		lastDirection = 0;
	}
	
	//GETTERS SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
}