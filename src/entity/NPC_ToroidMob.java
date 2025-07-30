package entity;

import my_first2D_game.GamePanel;

public class NPC_ToroidMob extends Entity{

	public NPC_ToroidMob(GamePanel gp) {
		super(gp);
		
		direction = "static";
		speed = 1;
		
		getToroidImages();
	}
	
	public void getToroidImages() {
		getSpritImages = setUpSpriteSheet("/npcs/toriod_spriteSheet.png", 1, 0);
		
		s1 = getSpritImages[0][0];
		up1 = getSpritImages[0][1];
		up2 = getSpritImages[0][0];
		down1 = getSpritImages[0][1];
		down2 = getSpritImages[0][0];
		right1 = getSpritImages[0][1];
		right2 = getSpritImages[0][0];
		left1 = getSpritImages[0][1];
		left2 = getSpritImages[0][1];
	}
	
	
	
}
