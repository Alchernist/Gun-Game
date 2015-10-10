package gungame.entities.creatures;

import gungame.game.Handler;

import java.awt.Graphics;

public class Enemy extends Creature {
	
	protected int damage;
	protected int spot;
	protected int a, b; //location of enemy
	
	public boolean isDead() {
		return health <= 0;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void hit() {
		if (isDead()) {
			return;
		}
		health -= 1;
	}

	public Enemy(Handler handler, float x, float y, int spot) { //delete x y parameters
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.spot = spot;
		
		setLocation();
		
	}
	
	public void setLocation() { //b values dependent on height and width
		switch(spot) {
		case 0:
			a = 10;
			b = 10;
			break;
		case 1:
			a = 10;
			b = 195;
			break;
		case 2:
			a = 10;
			b = 430;
			break;
		case 3:
			a = 600;
			b = 10;
			break;
		case 4:
			a = 600;
			b = 195;
			break;
		case 5:
			a = 600;
			b = 430;
			break;
		}
	}
	
	public int getSpot() {
		return spot;
	}

	public void tick() {

	}
	
	public void render(Graphics g) {
		g.drawRect(a, b, 30, 40);
	}
}
