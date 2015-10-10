package gungame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	//place images here and use them by typing Assets.picture
	private static final int width = 32, height = 32;
	
	public static BufferedImage soldier_left_top, soldier_left, soldier_left_bottom;
	public static BufferedImage soldier_right_top, soldier_right, soldier_right_bottom;
	
	public static BufferedImage[] armoured_soldier_left, armoured_soldier_right;
	public static BufferedImage armoured_soldier_left1, armoured_soldier_left2, armoured_soldier_left3;
	public static BufferedImage armoured_soldier_right1, armoured_soldier_right2, armoured_soldier_right3;
	
	public static BufferedImage player_left_top, player_left, player_left_bottom;
	public static BufferedImage player_right_top, player_right, player_right_bottom;
	
	
	public static BufferedImage player, dirt, grass, stone, tree;
	public static BufferedImage game_screen, menu_screen, pause_screen, settings_screen;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/ff6recastpalettes.png"));
		
		game_screen = ImageLoader.loadImage("/textures/gamebackground.png");
		menu_screen = sheet.crop(width, 0, width, height);
		pause_screen = sheet.crop(width * 2, 0, width, height);
		settings_screen = sheet.crop(width * 2, 0, width, height);
		
		//player pictures
		player_left_top = ImageLoader.loadImage("/player/player_left_top.png");
		player_left = ImageLoader.loadImage("/player/player_left.png");
		player_left_bottom = ImageLoader.loadImage("/player/player_left_bottom.png");
		player_right_top = ImageLoader.loadImage("/player/player_right_top.png");
		player_right = ImageLoader.loadImage("/player/player_right.png");
		player_right_bottom = ImageLoader.loadImage("/player/player_right_bottom.png");
		
		//soldier pictures
		soldier_left_top = ImageLoader.loadImage("/enemies/Soldier/soldier_left_top.png");
		soldier_left = ImageLoader.loadImage("/enemies/Soldier/soldier_left.png");
		soldier_left_bottom = ImageLoader.loadImage("/enemies/Soldier/soldier_left_bottom.png");
		soldier_right_top = ImageLoader.loadImage("/enemies/Soldier/soldier_right_top.png");
		soldier_right = ImageLoader.loadImage("/enemies/Soldier/soldier_right.png");
		soldier_right_bottom = ImageLoader.loadImage("");
		
		//armoured soldier
		armoured_soldier_left1 = ImageLoader.loadImage("/enemies/armouredSoldier/armoured_soldier_left1.png");
		armoured_soldier_left2 = ImageLoader.loadImage("/enemies/armouredSoldier/armoured_soldier_left2.png");
		armoured_soldier_left3 = ImageLoader.loadImage("/enemies/armouredSoldier/armoured_soldier_left3.png");
		armoured_soldier_right1 = ImageLoader.loadImage("/enemies/armouredSoldier/armoured_soldier_right1.png");
		armoured_soldier_right2 = ImageLoader.loadImage("/enemies/armouredSoldier/armoured_soldier_right2.png");
		armoured_soldier_right3 = ImageLoader.loadImage("/enemies/armouredSoldier/armoured_soldier_right3.png");
		
		armoured_soldier_left = new BufferedImage[3];
		armoured_soldier_right = new BufferedImage[3];
		
		armoured_soldier_left[0] = armoured_soldier_left1;
		armoured_soldier_left[1] = armoured_soldier_left2;
		armoured_soldier_left[2] = armoured_soldier_left3;
		
		armoured_soldier_right[0] = armoured_soldier_right1;
		armoured_soldier_right[1] = armoured_soldier_right2;
		armoured_soldier_right[2] = armoured_soldier_right3;
		
		//PLAYER SPRITES PROVIDED BY: AddFact
		player = sheet.crop(width * 4, 0, width, height);
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, 0, width, height);
	}
	
}