package gungame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	//place images here and use them by typing Assets.picture
	private static final int width = 32, height = 32;
	
	public static BufferedImage soldier_left_top, soldier_left, soldier_left_bottom;
	public static BufferedImage soldier_right_top, soldier_right, soldier_right_bottom;
	
	public static BufferedImage player_left_top, player_left, player_left_bottom;
	public static BufferedImage player_right_top, player_right, player_right_bottom;
	
	
	public static BufferedImage player, dirt, grass, stone, tree;
	public static BufferedImage menu_screen, pause_screen, settings_screen;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/ff6recastpalettes.png"));
		
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
		soldier_left_top = ImageLoader.loadImage("/enemies/soldier_left_top.png");
		soldier_left = ImageLoader.loadImage("/enemies/soldier_left.png");
		soldier_left_bottom = ImageLoader.loadImage("/enemies/soldier_left_bottom.png");
		soldier_right_top = ImageLoader.loadImage("/enemies/soldier_right_top.png");
		soldier_right = ImageLoader.loadImage("/enemies/soldier_right.png");
		soldier_right_bottom = ImageLoader.loadImage("/enemies/soldier_right_bottom.png");
		
		
		//PLAYER SPRITES PROVIDED BY: AddFact
		player = sheet.crop(width * 4, 0, width, height);
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, 0, width, height);
	}
	
}