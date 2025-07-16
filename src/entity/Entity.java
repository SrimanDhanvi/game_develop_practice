package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	
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
    
	public Rectangle solidArea;
	public boolean collisionOn = false;
}
