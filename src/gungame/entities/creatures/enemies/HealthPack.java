package gungame.entities.creatures.enemies;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gungame.game.Handler;
import gungame.gfx.Assets;
import gungame.states.GameState;

public class HealthPack extends Enemy {
	
	private BufferedImage image; //example left top

	public HealthPack(Handler handler, float x, float y, int spot) {
		super(handler, x, y, spot);
		health = 1;
		damage = 0;
		lifeSpan = 1;
		init();
		time = 0;
		System.out.println("Created Soldier");
	}
	
	public boolean isDead() {
		if (health < 0) 
			((GameState) handler.getGame().getGameState()).getPlayer().heal(1);
		return health <= 0;
	}
	
	public void kill() {
		health = 0;
	}
	
	public void hit() {
		if (isDead()) {
			return;
		}
		health -= 10;
	}
	
	public void init() {
		image = Assets.healthpack;
	}
	
	public boolean attack() {
		if (time >= 60) // 3 seconds to live
			return true;
		return false;
	}

	public void tick() {
		time++;
	}

	public void render(Graphics g) {
		g.drawImage(image, a, b, 50, 50, null);
	}
	
}
