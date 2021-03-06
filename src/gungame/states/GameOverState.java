package gungame.states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import gungame.game.Handler;
import gungame.gfx.Assets;

public class GameOverState extends State {
	private BufferedImage settingsScreen;
	private int currentChoice = 0;
	private Font font;
	private int score;

	public GameOverState(Handler handler) {
		super(handler);
		settingsScreen = Assets.settings_screen;

		try {
			font = new Font("Arial", Font.PLAIN, 30);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getInput() {
		score = ((GameState) handler.getGame().getGameState()).getScore();
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_ENTER)) {
			select();
		}
	}

	private void select() {
		if (currentChoice == 0) {
			// start
			handler.getGame().resetGame();
			State.setState(handler.getGame().getMenuState());
		}
	}

	public void tick() {
		getInput();
	}

	public void render(Graphics g) {
		// render menu block
		g.drawImage(settingsScreen, 0, 0, 640, 480, null);

		// render title
		g.drawString("Game Over. You're score is: " + score, 260, 170);

		// draw menu options
		g.setFont(font);
		g.drawString("Press Enter to go back", 320, 240);
	}

}
