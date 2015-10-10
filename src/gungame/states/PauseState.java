package gungame.states;

import gungame.game.Handler;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class PauseState extends State {
	private String[] options = { "Resume", "Options", "Quit" };
	private int currentChoice = 0;
	private Font font;

	public PauseState(Handler handler) {
		super(handler);

		try {
			font = new Font("Arial", Font.PLAIN, 30);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getInput() {
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_UP)) {
			currentChoice--;
			if (currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_DOWN)) {
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
		}
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_ENTER)) {
			select();
		}
	}

	private void select() {
		if (currentChoice == 0) {
			// start
			State.setState(handler.getGame().getGameState());
		} else if (currentChoice == 1) {
			// help
		} else {
			State.setState(handler.getGame().getMenuState());
		}
	}

	public void tick() {
		getInput();
	}

	public void render(Graphics g) {
		// render menu block
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 640, 480);

		// draw menu options
		g.setFont(font);
		g.setColor(Color.GREEN);
		g.drawString("Pause", 250, 200);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g.setColor(Color.BLACK);
				;
			} else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 320, 240 + i * 40);
		}

	}
}
