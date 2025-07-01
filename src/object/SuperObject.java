package object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import my_first2D_game.GamePanel;

public class SuperObject {
	
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	
	public void draw(Graphics2D g2, GamePanel gp) {
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX ;
		int screenY = worldY - gp.player.worldY + gp.player.screenY ;
		
		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
			worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			g2.setColor(new Color(0, 0, 0, 100));
			g2.fillOval(screenX+12, screenY+40, 20, 20);
			g2.drawImage(image , screenX, screenY, gp.tileSize, gp.tileSize, null);
		}
		
	}
}
