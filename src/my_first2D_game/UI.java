package my_first2D_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UI {

	GamePanel gp;
	Font customFont_20;
	BufferedImage killSymbol_Image;
	BufferedImage healthSymbol_Image;
	BufferedImage tenKill_Image;
	BufferedImage messageImg;
	public boolean messageOn = false;
	public String message = "";
	Color textColor;
	int messageCounter = 0;
	
	public UI(GamePanel gp) {
		this.gp = gp;

        	customFont_20 = new Font ("TT Supermolot Neue Trl Bd It" , Font.PLAIN, 15);
        	try {
        		killSymbol_Image = ImageIO.read(getClass().getResourceAsStream("/symbols/Kills_symbol.png"));
        		healthSymbol_Image = ImageIO.read(getClass().getResourceAsStream("/symbols/Health_Symbol.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void showMessage(String text, Color color, int a) {
		
		message = text;
		messageOn = true;
		textColor = color;
		if (a == 1) {
			messageImg = healthSymbol_Image;
		}
	}
	
	public void draw(Graphics g2) {
		
//		235, 84, 2, 255 - orange
//		106, 240, 17, 255 - green
		g2.setFont(customFont_20);
		g2.setColor(new Color(235, 84, 2, 180));
		g2.drawImage(killSymbol_Image, 20, 5, gp.tileSize, gp.tileSize, null);
		g2.drawString("Kills", 60 , 20);
		
		if(messageOn) {
			
			g2.setFont(g2.getFont().deriveFont(10f));
			g2.setColor(textColor);
			g2.drawImage(messageImg, gp.screenWidth/2-20, 5, gp.tileSize, gp.tileSize, null);
			g2.drawString(message, gp.screenWidth/2-22, 70);
			
			messageCounter++;
			
			if(messageCounter > 120) {
				messageCounter = 0;
				messageOn = false;
			}
			
		}
		
	}
	
}
