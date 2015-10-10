package gungame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import gungame.game.Handler;
import gungame.gfx.Assets;
import gungame.states.State;

public class Player extends Creature {
	
	private int position;
	private BufferedImage image;
	//Animations
	//private Animation animDown, animUp, animLeft, animRight;
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//Animations
//		animDown = new Animation(500, Assets.player_down);
//		animUp = new Animation(500, Assets.player_up);
//		animLeft = new Animation(500, Assets.player_left);
//		animRight = new Animation(500, Assets.player_right);
		health = 3;
		position = 0; //idle
	}
	
	public void setPosition(int direction) {
		position = direction;
	}
	
	public void changePosition() {
		switch(position) {
		case 0:
			image = Assets.player_left_top;
			break;
		case 1:
			image = Assets.player_left;
			break;
		case 2:
			image = Assets.player_left_bottom;
			break;
		case 3:
			image = Assets.player_right_top;
			break;
		case 4:
			image = Assets.player_right;
			break;
		case 5:
			image = Assets.player_right_bottom;
			break;
		}
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
//		animDown.tick();
//		animUp.tick();
//		animLeft.tick();
//		animRight.tick();
		changePosition();
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
		g.drawImage(image, (int) (x), (int) (y), width, height, null);
		g.setColor(Color.GREEN);
		g.fillOval(300, 20, 15, 15);
		if (health == 2) {
			g.fillOval(320, 20, 15, 15);
			g.setColor(Color.RED);
			g.fillOval(340, 20, 15, 15);
		}
		else if (health == 1) {
			g.setColor(Color.RED);
			g.fillOval(320, 20, 15, 15);
			g.fillOval(340, 20, 15, 15);
		}
		else {
			g.fillOval(320, 20, 15, 15);
			g.fillOval(340, 20, 15, 15);
		}
		
	}
	
//	private BufferedImage getCurrentAnimationFrame() {
//		//shooting animations
//		if(xMove < 0) {
//			lastDirection = 2;
//			return animLeft.getCurrentFrame();
//		}
//		else if (xMove > 0) {
//			lastDirection = 3;
//			return animRight.getCurrentFrame();
//		}
//		else if (yMove < 0) {
//			lastDirection = 1;
//			return animUp.getCurrentFrame();
//		}
//		else if (yMove > 0) {
//			lastDirection = 0;
//			return animDown.getCurrentFrame();
//		}
//		else {
//			return Assets.player_position[lastDirection][0];
//		}
//	}

}
