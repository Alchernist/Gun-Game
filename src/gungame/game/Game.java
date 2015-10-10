package gungame.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import gungame.display.Display;
import gungame.gfx.Assets;
import gungame.input.KeyManager;
import gungame.states.GameOverState;
import gungame.states.GameState;
import gungame.states.MenuState;
import gungame.states.PauseState;
import gungame.states.SettingsState;
import gungame.states.State;

public class Game implements Runnable {

	private Display display;
	public String title;
	private int width, height;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	// States
	private State gameState;
	private State menuState;
	private State pauseState;
	private State settingsState;
	private State gameOverState;

	// Input
	private KeyManager keyManager;

	// Handler
	private Handler handler;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
	}

	private void init() {
		// initializes graphics
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();

		handler = new Handler(this);

		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		pauseState = new PauseState(handler);
		settingsState = new SettingsState(handler);
		gameOverState = new GameOverState(handler);
		State.setState(menuState);

	}

	private void tick() {

		keyManager.tick();
		if (State.getState() != null) {
			State.getState().tick();
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		// clear screen
		g.clearRect(0, 0, width, height);

		// start drawing
		if (State.getState() != null) {
			State.getState().render(g);
		}

		// end drawing
		bs.show();
		g.dispose();
	}

	public State getGameState() {
		return gameState;
	}

	public State getMenuState() {
		return menuState;
	}

	public State getPauseState() {
		return pauseState;
	}

	public State getSettingsState() {
		return settingsState;
	}
	
	public State getGameOverState() {
		return gameOverState;
	}
	
	public void resetGame() {
		gameState = null;
		gameState = new GameState(handler);
	}

	public void run() {

		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) { // game loop
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
