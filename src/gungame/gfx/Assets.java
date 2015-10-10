package gungame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	//place images here and use them by typing Assets.picture
	private static final int width = 32, height = 32;
	
	public static BufferedImage player, dirt, grass, stone, tree;
	public static BufferedImage enemy;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[][] player_position;
	public static BufferedImage menu_screen, pause_screen, settings_screen;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/ff6recastpalettes.png"));
		
		menu_screen = sheet.crop(width, 0, width, height);
		pause_screen = sheet.crop(width * 2, 0, width, height);
		settings_screen = sheet.crop(width * 2, 0, width, height);
		
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		
		player_down[0] = sheet.crop(width * 4, 0, width, height);
		player_down[1] = sheet.crop(width * 5, 0, width, height);
		player_up[0] = sheet.crop(width * 6, 0, width, height);
		player_up[1] = sheet.crop(width * 7, 0, width, height);
		player_right[0] = sheet.crop(width * 4, height, width, height);
		player_right[1] = sheet.crop(width * 5, height, width, height);
		player_left[0] = sheet.crop(width * 6, height, width, height);
		player_left[1] = sheet.crop(width * 7, height, width, height);
		
		player_position = new BufferedImage[4][2];
		player_position[0] = player_down;
		player_position[1] = player_up;
		player_position[2] = player_left;
	    player_position[3] = player_right;
		//PLAYER SPRITES PROVIDED BY: AddFact
		player = sheet.crop(width * 4, 0, width, height);
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, 0, width, height);
	}
	
}