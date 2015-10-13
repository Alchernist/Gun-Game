package gungame.entities.creatures.enemies;

import gungame.game.Handler;
import gungame.gfx.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Blob extends Enemy {
	
	private BufferedImage image; //example left top
	private int as, bs;

	public Blob(Handler handler, float x, float y, int spot) {
		super(handler, x, y, spot);
		health = 1;
		damage = 3;
		lifeSpan = 3;
		score = 1;
		init();
		time = 0;
		System.out.println("Created Blob");

	}
	
	public void init() {
		switch(spot) {
		case 0:
			image = Assets.blueblob;
			a = 10;
			b = 10;
			as = 1;
			bs = 1;
			break;
		case 1:
			image = Assets.blueblob;
			a = 10;
			b = 185;
			as = 1;
			break;
		case 2:
			image = Assets.blueblob;
			a = 10;
			b = 350;
			as = 1;
			bs = -1;
			break;
		case 3:
			image = Assets.blueblob;
			a = 500;
			b = 10;
			as = -1;
			bs = 1;
			break;
		case 4:
			image = Assets.blueblob;
			a = 500;
			b = 185;
			as = -1;
			break;
		case 5:
			image = Assets.blueblob;
			a = 500;
			b = 350;
			as = -1;
			bs = -1;
			break;
		}
	}
	
	public boolean attack() {
		if (time >= 200) { // 3 seconds to live
			time = 0;
			return true;
	}
		return false;
	}

	public void tick() {
		time++;
		a += as;
		b += bs;
	}

	public void render(Graphics g) {
		g.drawImage(image, a, b, 50, 50, null);
	}
}
