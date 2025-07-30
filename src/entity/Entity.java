package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import my_first2D_game.GamePanel;

public class Entity {
	
	GamePanel gp;
	public int worldX, worldY ;
	public int speed;
	
	public BufferedImage s1, s2, up1, up2, down1, down2, left1, left2, right1, right2,
	  hitRight, hitLeft, hitFront, hitFront1, hitFront2, hitBack, hitBack2, hitRight2, hitLeft2;
	public BufferedImage spriteSheet;
	public String direction;
	public String direction2;
	public String direcImg;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
    
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	public int diaSpeed;
	public int objectIndex;
	public int a = 0;
	
	public BufferedImage[][] getSpritImages;
	
    
    public Entity(GamePanel gp) {
    	this.gp = gp;
    }
    
    public BufferedImage[][] setUpSpriteSheet(String path, int x, int y) {
		try {
			
			spriteSheet = ImageIO.read(getClass().getResourceAsStream(path));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedImage[][] allDirections = new BufferedImage[y][x]; // 4 directions, 4 frames each
		for (int dir = 0; dir < allDirections.length; dir++) {
		    for (int i = 0; i < allDirections[0].length; i++) {
		        allDirections[dir][i] = spriteSheet.getSubimage(i * 48, dir * 48, 48, 48);
		    }
		}
		return allDirections;
    }
}
