package gungame.entities.projectiles;

import java.awt.Graphics;

import gungame.entities.Entity;
import gungame.game.Handler;

public class Projectile extends Entity {
	
	private int a, b;

	public Projectile(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		// TODO Auto-generated constructor stub
		
		a = 0;
		b = 0;
	}

	
	public static int findGCD(float f, float g){
		if(g == 0){
			return (int)f;
		}
		
		return findGCD(g, f%g);
	}
	
	public void slope(int x2,int y2){
		int gcd = (int) (findGCD(x - x2, y - y2));
		a = (int) ((x - x2)/gcd);
		b = (int) ((y - y2)/gcd);
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x = x + a;
		y = y + b;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawArc((int) x, (int) y, width , height, 0, 360);
	}
	
}
