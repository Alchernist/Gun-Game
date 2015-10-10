package gungame.entities.creatures;

import gungame.game.Handler;
import gungame.gfx.Animation;
import gungame.gfx.Assets;
import gungame.states.State;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//Animations
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
		health = 3;
	}
	
	public void hit() {
		if (isDead()) {
			return;
		}
		health -= 1;
	}

	public boolean isDead() {
		return health <= 0;
	}
	
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		getInput();
		
	}

	private void getInput() {
		
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_Q)) {
			//kill the guy on the top left side
		}
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_ESCAPE)) 
			State.setState(handler.getGame().getPauseState());
		if (handler.getKeyManager().keyDown(KeyEvent.VK_W))
			yMove = -speed;
		if (handler.getKeyManager().keyDown(KeyEvent.VK_S))
			yMove = speed;
		if (handler.getKeyManager().keyDown(KeyEvent.VK_A))
			xMove = -speed;
		if (handler.getKeyManager().keyDown(KeyEvent.VK_D))
			xMove = speed;
	}
	
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x), (int) (y), width, height, null);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		//shooting animations
		if(xMove < 0) {
			lastDirection = 2;
			return animLeft.getCurrentFrame();
		}
		else if (xMove > 0) {
			lastDirection = 3;
			return animRight.getCurrentFrame();
		}
		else if (yMove < 0) {
			lastDirection = 1;
			return animUp.getCurrentFrame();
		}
		else if (yMove > 0) {
			lastDirection = 0;
			return animDown.getCurrentFrame();
		}
		else {
			return Assets.player_position[lastDirection][0];
		}
	}

}
