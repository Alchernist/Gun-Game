package gungame.entities.creatures;

import gungame.game.Handler;

import java.awt.Graphics;

public class Enemy extends Creature {
	
	protected int damage;
	
	public boolean isDead() {
		return health <= 0;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void hit(int damage) {
		if (isDead()) {
			return;
		}
		health -= damage;
	}

	public Enemy(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	}

	public void tick() {

	}

	public void render(Graphics g) {
		
	}
}
