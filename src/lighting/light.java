package lighting;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import my_first2D_game.GamePanel;

public class light extends Quant{
	
	GamePanel gp;
	
	public light(GamePanel gp) {
		this.gp = gp;
	}


	public void draw(Graphics2D g2) {
		
		darkness = new BufferedImage(gp.screenWidth, gp.screenHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D gDark = darkness.createGraphics();
		
		gDark.setColor(new Color(0, 0, 0, 100));
		gDark.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		
        if (!gp.tileM.lightTileX.isEmpty()&& !gp.tileM.lightTileY.isEmpty()) {
		gDark.setComposite(AlphaComposite.SrcOver);
		gDark.setColor(new Color(0, 255, 150, 30));
		gDark.fillOval(gp.tileM.lightTileX.get(0), gp.tileM.lightTileY.get(0)+40, gp.tileSize, gp.tileSize);
		
		gDark.setColor(new Color(147, 201, 186, 20));
		gDark.fillOval(gp.tileM.lightTileX.get(0)-20, gp.tileM.lightTileY.get(0)+40, gp.tileSize+40, gp.tileSize+40);
		
		gDark.setColor(new Color(118, 168, 149, 50));
		gDark.fillOval(gp.tileM.lightTileX.get(0)-40, gp.tileM.lightTileY.get(0)+40, gp.tileSize+80, gp.tileSize+80);
        }

		
		gDark.dispose();
        
		g2.drawImage(darkness, 0, 0, null);
	}
	
}
