package gungame.entities.creatures.enemies;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gungame.game.Handler;
import gungame.gfx.Assets;

public class Soldier extends Enemy {
	
	private BufferedImage image; //example left top

	public Soldier(Handler handler, float x, float y, int spot) {
		super(handler, x, y, spot);
		health = 1;
		damage = 1;
		lifeSpan = 3;
		score = 1;
		
		init();
		
		
	}
	
	public void init() {
		switch(spot) {
		case 0:
			image = Assets.grass;
			a = 10;
			b = 10;
			break;
		case 1:
			image = Assets.grass;
			a = 10;
			b = 195;
			break;
		case 2:
			image = Assets.grass;
			a = 10;
			b = 430;
			break;
		case 3:
			image = Assets.grass;
			a = 600;
			b = 10;
			break;
		case 4:
			image = Assets.grass;
			a = 600;
			b = 195;
			break;
		case 5:
			image = Assets.grass;
			a = 600;
			b = 430;
			break;
		}
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(image, a, b, null);
	}
	
}
