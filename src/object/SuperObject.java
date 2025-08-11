package object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import my_first2D_game.GamePanel;

public class SuperObject {
	
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public int objectCounter = 0;
	public Rectangle solidArea;
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	public int screenX;
	public int screenY;
	
	
	public void draw(Graphics2D g2, GamePanel gp) {
		
		
		screenX = (int)(worldX - gp.player.worldX + gp.player.screenX) ;
		screenY = (int)(worldY - gp.player.worldY + gp.player.screenY) ;
		
		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
			worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			g2.setColor(new Color(0, 0, 0, 100));
			g2.fillOval(screenX+12, screenY+40, 20, 20);
			g2.drawImage(image , screenX, screenY, gp.tileSize, gp.tileSize, null);
		}
//		System.out.println("Health obj at: " + gp.obj[1].worldX + ", " + gp.obj[1].worldY);
		
	}

}
