package my_first2D_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UI extends Dialouges{

	GamePanel gp;
	Graphics g2;
	Font customFont_20;
	BufferedImage killSymbol_Image;
	BufferedImage healthSymbol_Image;
	BufferedImage tenKill_Image;
	BufferedImage messageImg;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	String D1, D2;
	int dno = 0;
	public int dsno = 0;
	Color textColor;
	
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
	
	public int getXforCentredText(String text) {
		int lengthOfText = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int TextX = gp.screenWidth/2- lengthOfText/2;
		
		return TextX;
	}
	
	public void showMessage(String text, Color color, int a) {
		
		message = text;
		messageOn = true;
		textColor = color;
		if (a == 1) {
			messageImg = healthSymbol_Image;
		}
	}
	
	
	
	public void setDialouge(int dsno) {
		
		this.dsno = dsno;
	}
	
	
	public void draw(Graphics g2) {
		
		this.g2 = g2;
		
//		235, 84, 2, 255 - orange
//		106, 240, 17, 255 - green
		g2.setFont(customFont_20);
		
		if(messageOn) {
			messageOnTop();
		}
		
		if(gp.keyH.F3) {
			PerformanceDisplay();
		}	
			
		if (gp.GameState == gp.pauseState) {
			drawPauseScreen();
		}
		
		if (dsno == 1) {
			dialougeSet1();
		}
	}
	
	public void drawPauseScreen() {
		g2.setColor(new Color(0, 0, 0, 100));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		g2.setFont(g2.getFont().deriveFont(30f));
		g2.setColor(Color.white);
		g2.drawString("Time Stilled", getXforCentredText("Time Stilled"), 110);
	}
	
	public void messageOnTop() {
		
		g2.setFont(g2.getFont().deriveFont(10f));
		g2.setColor(textColor);
		g2.drawImage(messageImg, gp.screenWidth/2 - 24, 5, gp.tileSize, gp.tileSize, null);
		g2.drawString(message, getXforCentredText(message), 70);
		
		messageCounter++;
		
		if(messageCounter > 120) {
			messageCounter = 0;
			messageOn = false;
		}
	}
	
	public void PerformanceDisplay() {
		g2.setFont(g2.getFont().deriveFont(10f));
		g2.setColor(Color.white);
		g2.drawString("X, Y: " + gp.player.worldX + ", " + gp.player.worldY, 10, 100);
		g2.drawString("Draw Time: " + gp.passed, 10, 110);
	}
	
	public void dialougeBox() {
		g2.setColor(Color.white);
		g2.drawRect(10, gp.screenHeight-210, gp.screenWidth-20, 200);
		g2.setColor(new Color(87, 129, 145, 150));
		g2.fillRect(10, gp.screenHeight-210, gp.screenWidth-20, 200);
		g2.setFont(g2.getFont().deriveFont(10f));
		g2.setColor(Color.white);
		g2.drawString("Press Enter", gp.screenWidth-80, gp.screenHeight-30);
	}
	
	public void dialougeSet1() {
		dialougeBox();

		g2.setFont(g2.getFont().deriveFont(10f));
		g2.setColor(Color.white);

		if (dno == 0) {
			D1 = Dialouge1;
			D2 = emo1;
		}
		
		if (dno == 1) {
			D1 = Dialouge2;
			D2 = emo2;
		}
		
		if (dno == 2) {
			D1 = Dialouge3;
			D2 = emo3;
		}
		
		if (dno == 3) {
			D1 = emo4;
			D2 = Dialouge4;
		}
		
		if (dno == 4) {
			D1 = Dialouge5;
			D2 = emo5;
		}
		
		if (dno == 5) {
			D1 = Dialouge6;
			D2 = emo6;
		}
		
		if (dno == 6) {
			D1 = Dialouge7;
			D2 = "";
		}
		
		if (dno == 7) {
			D1 = emo8;
			D2 = Dialouge8;
		}
		
		if (dno == 8) {
			dsno = 0;
			dno = 0;
		}
		
		g2.drawString(D1, 30, gp.screenHeight-180);
		g2.drawString(D2, 30, gp.screenHeight-160);
	}

}
	
