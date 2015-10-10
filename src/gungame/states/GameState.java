package gungame.states;

import gungame.entities.creatures.Player;
import gungame.game.Handler;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameState extends State {
	
	private Player player;

	//actual game goes here
	public GameState(Handler handler) {
		super(handler);
		player = new Player(handler, 220.0f, 200.0f);
		
	}

	public void tick() {
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_ESCAPE)) {
			State.setState(handler.getGame().getPauseState());
		}
	}

	public void render(Graphics g) {
		player.render(g);
		g.drawLine(5, 10, 15, 20);
	}

}
