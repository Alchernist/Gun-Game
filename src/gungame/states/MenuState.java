package gungame.states;

import gungame.game.Handler;
import gungame.gfx.Assets;
import gungame.sounds.SoundPlayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class MenuState extends State {
	private BufferedImage menuScreen;
	private String[] options = { "Start", "Settings", "Quit" };
	private int currentChoice = 0;
	private Color titleColor;
	private Font titleFont;
	private Font font;

	public MenuState(Handler handler) {
		super(handler);
		menuScreen = Assets.menu_screen;

		try {
			titleColor = new Color(0, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 30);
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
			//start
			SoundPlayer.playSound("res/sounds/song.wav");
			State.setState(handler.getGame().getGameState());
		}
		else if (currentChoice == 1) {
			State.setState(handler.getGame().getSettingsState());
		}
		else {
			System.exit(0);
		}
	}

	public void tick() {
		getInput();
	}

	public void render(Graphics g) {
		// render menu block
		g.drawImage(menuScreen, 0, 0, 640, 480, null);

		// render title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Gun Game!", 260, 170);

		// draw menu options
		g.setFont(font);
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
