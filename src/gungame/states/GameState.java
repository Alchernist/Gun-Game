package gungame.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import gungame.entities.creatures.Player;
import gungame.entities.creatures.enemies.ArmouredSoldier;
import gungame.entities.creatures.enemies.Enemy;
import gungame.entities.creatures.enemies.Soldier;
import gungame.game.Handler;

public class GameState extends State {
	
	private Player player;
	private ArrayList<Enemy> enemies;
	private Random rand;
	private int spot, typeOfEnemy;
	private boolean[] spotsTaken;
	private int seconds;
	private Integer score;

	//actual game goes here
	public GameState(Handler handler) {
		super(handler);
		player = new Player(handler, 240.0f, 150.0f);
		enemies = new ArrayList<Enemy>(); //6 spots
		
		rand = new Random();
		spot = 0;
		typeOfEnemy = 0; //0 is empty, 1 is soldier, 2 is hostage, 3 is armoured
		spotsTaken = new boolean[6];
		seconds = 0;
		score = 0;
	}
	
	public int getScore() {
		return score;
	}
	
	public void placeEnemy() {
		spot = rand.nextInt(6);
		if (spotsTaken[spot])
			return;
		typeOfEnemy = rand.nextInt(4);
		Enemy e;
		if (typeOfEnemy == 0) 
			return;
		else if (typeOfEnemy == 1) {
			e = new Soldier(handler, 10, 10, spot);
		}
		else {
			e = new ArmouredSoldier(handler, 10, 10, spot);
		}
		spotsTaken[spot] = true;
		enemies.add(e);
	}

	public void drawEnemies(Graphics g) {
		for (Enemy e: enemies) {
			e.render(g);
		}
	}
	
	public void getInput() {
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_ESCAPE)) {
			State.setState(handler.getGame().getPauseState());
		}
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_Q)) {
			if (spotsTaken[0]) {
				damageEnemy(0); //hit the enemy at this spot
			}
			else {
				player.hit(); //player missed target, so deal damage to self
			}
			player.setPosition(0);
		}
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_A)) {
			if (spotsTaken[1]) {
				damageEnemy(1); //hit the enemy at this spot
			}
			else {
				player.hit(); //player missed target, so deal damage to self
			}
			player.setPosition(1);
		}
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_Z)) {
			if (spotsTaken[2]) {
				damageEnemy(2); //hit the enemy at this spot
			}
			else {
				player.hit(); //player missed target, so deal damage to self
			}
			player.setPosition(2);
		}
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_O)) {
			if (spotsTaken[3]) {
				damageEnemy(3); //hit the enemy at this spot
			}
			else {
				player.hit(); //player missed target, so deal damage to self
			}
			player.setPosition(3);
		}
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_K)) {
			if (spotsTaken[4]) {
				damageEnemy(4); //hit the enemy at this spot
			}
			else {
				player.hit(); //player missed target, so deal damage to self
			}
			player.setPosition(4);
		}
		if (handler.getKeyManager().keyDownOnce(KeyEvent.VK_M)) {
			if (spotsTaken[5]) {
				damageEnemy(5); //hit the enemy at this spot
			}
			else {
				player.hit(); //player missed target, so deal damage to self
			}
			player.setPosition(5);
		}
	}
	
	public void damageEnemy(int spot) {
		for (Enemy e: enemies) {
			if (e.getSpot() == spot) {
				e.hit();
				return;
			}
		}
	}
	
	public void tick() { //make a speed variable that changes time of next enemy
		getInput();
		if (seconds >= 180) {
			placeEnemy();
			seconds = 0;
		}
		
		//update all enemies
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).tick();
		}
		
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).attack()) {
				player.hit();
				enemies.get(i).kill();
			}
			if (enemies.get(i).isDead()) {
				spotsTaken[enemies.get(i).getSpot()] = false;
				score += enemies.get(i).getScore();
				enemies.set(i, null);
				enemies.remove(i);
				i++;
			}
		}
		seconds++;
		player.tick();
		if (player.isDead()) {
			State.setState(handler.getGame().getGameOverState()); //change this to gameover state
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 640, 480);
		player.render(g);
		drawEnemies(g);
		g.setColor(Color.BLACK);
		g.drawString("Score: " + score.toString(), 100, 100); //format this in a neater manner
	}

}
