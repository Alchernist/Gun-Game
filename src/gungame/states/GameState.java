package gungame.states;

import gungame.game.Handler;

import java.awt.Graphics;

public class GameState extends State {

	//actual game goes here
	public GameState(Handler handler) {
		super(handler);
		
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawLine(5, 10, 15, 20);
	}

}
