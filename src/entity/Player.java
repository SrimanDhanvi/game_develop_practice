package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import my_first2D_game.GamePanel;
import my_first2D_game.Keyhandler;

public class Player extends Entity{
	
	GamePanel gp;
	Keyhandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	public Player(GamePanel gp, Keyhandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - gp.tileSize/2;
		screenY = gp.screenHeight/2 - gp.tileSize/2;
		
		solidArea = new Rectangle(8 ,32 ,32 ,16);
		
		setDefaultValues();
		getplayerImage();
	}
	
	public void setDefaultValues() {
		worldX = 0*gp.tileSize;
		worldY = 0*gp.tileSize;
		speed = 3;
		direction = "s"; // default
	}
	
	public void getplayerImage() {
		
		try {
			
			spriteSheet = ImageIO.read(getClass().getResourceAsStream("/player_images/Spritesheet_Player4.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedImage[][] allDirections = new BufferedImage[5][4]; // 4 directions, 4 frames each
		for (int dir = 0; dir < allDirections.length; dir++) {
		    for (int i = 0; i < allDirections[0].length; i++) {
		        allDirections[dir][i] = spriteSheet.getSubimage(i * 48, dir * 48, 48, 48);
		    }
		}
		
		s1 = allDirections[0][0];
		s2 = allDirections[3][3];
		up1 = allDirections[0][3];
		up2 = allDirections[1][0];
		down1 = allDirections[0][1];
		down2 = allDirections[0][2];
		left1 = allDirections[1][3];
		left2 = allDirections[2][0];
		right1 = allDirections[1][1];
		right2 = allDirections[1][2];
		hitRight = allDirections[2][1];
		hitLeft = allDirections[2][2];
		hitFront = allDirections[2][3];
		hitFront1 = allDirections[3][0];
		hitFront2 = allDirections[3][1];
		hitBack = allDirections[3][2];
		hitBack2 = allDirections[4][0];
		hitRight2 = allDirections[4][1];
		hitLeft2 = allDirections[4][2];
		
		
	}
	
	public void update() {
		
		direction = "s";
		direction2 = "";
		direcImg = null;
		
		if (keyH.upPressed == true || keyH.downPressed == true 
				||keyH.leftPressed == true ||keyH.rightPressed == true|| keyH.HitPressed == true) {

			if (keyH.HitPressed == true && keyH.upPressed == true && keyH.leftPressed == true) {
				direction = "up";
				direction2 = "left";
				direcImg = "up";
			}
			else if (keyH.HitPressed == true && keyH.upPressed == true && keyH.rightPressed == true) {
				direction = "up";
				direction2 = "right" ;
				direcImg = "up";
			}
			else if (keyH.HitPressed == true && keyH.downPressed == true && keyH.rightPressed == true) {
				direction = "down";
				direction2 = "right" ;
				direcImg = "down";
			}
			else if (keyH.HitPressed == true && keyH.downPressed == true && keyH.leftPressed == true) {
				direction = "down";
				direction2 = "left" ;
				direcImg = "down";
			}
			else if (keyH.HitPressed == true && keyH.upPressed == true) {
				direction = "up";
				direcImg = "up";
			}
			else if (keyH.HitPressed == true && keyH.downPressed == true) {
				direction = "down";
				direcImg = "down";
			}
			else if (keyH.HitPressed == true && keyH.leftPressed == true) {
				direction = "left";
				direcImg = "left";
		    }
			else if (keyH.HitPressed == true && keyH.rightPressed == true) {
				direction = "right";
				direcImg = "right";
		    } else if (keyH.HitPressed == true) {
		    	direcImg = "s";
			}		
		
		
		else if (keyH.upPressed == true && keyH.leftPressed == true) {
			direction = "up";
			direction2 = "left" ;
		}
		else if (keyH.upPressed == true && keyH.rightPressed == true) {
			direction = "up";
			direction2 = "right" ;
		}
		else if (keyH.downPressed == true && keyH.rightPressed == true) {
			direction = "down";
			direction2 = "right" ;
		}
		else if (keyH.downPressed == true && keyH.leftPressed == true) {
			direction = "down";
			direction2 = "left" ;
		}
		else if (keyH.upPressed == true && keyH.leftPressed == false) {
			direction = "up";
		}
		else if (keyH.downPressed == true) {
			direction = "down";
		}
		else if (keyH.leftPressed == true) {
			direction = "left";
	    }
		else if (keyH.rightPressed == true) {
			direction = "right";
	    } 
		
		int diaSpeed = (int)(speed/Math.sqrt(2));
		
		collisionOn = false;
		gp.cChecker.checkTile(this);
		
		if (collisionOn == false) {
			
			switch(direction) {
			case "up":
				worldY -= speed;
				break;
			case "down":
				worldY += speed;
			    break;
			case"left":
				worldX -= speed;
				break;
			case"right":
				worldX += speed;
			   break;
			}
			
			
			switch(direction2) {
			case "up":
				worldY -= diaSpeed;
				break;
			case "down":
				worldY += diaSpeed;
			    break;
			case"left":
				worldX -= diaSpeed;
				break;
			case"right":
				worldX += diaSpeed;
			   break;
			}
		} 
		
	}
		spriteCounter++;
		
		if (spriteCounter > 20) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
			spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
//		System.out.println(worldX);
//		System.out.println(worldY);
}
	
	public void draw(Graphics2D g2) {
		
//		g2.setColor(new Color(255, 255, 255, 10));
//		g2.fillOval(screenX-6, screenY+16, 60, 60);
		
		{
        Point2D center = new Point2D.Float(screenX+24, screenY+41);
        float radius = 25;
        float[] dist = {0.5f, 1.0f};  // From center to edge
        Color[] colors = { new Color(0, 0, 0, 0), new Color(0, 255, 255, 100)};  // Bright center to transparent

        RadialGradientPaint rgp = new RadialGradientPaint(center, radius, dist, colors);

        g2.setPaint(rgp);
        g2.fillOval(screenX-2, screenY+16, 50, 50);
		}
        
		
		BufferedImage image = null;
		
		if (direcImg == null) {
		switch(direction) {
		case "s":
			if (spriteNum == 1) {
				image = s1;
			}
			if (spriteNum == 2) {
				image = s2;
			}
		break;
		case "up":			
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
		break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}
		break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			}
		break;
		case "right":
			if (spriteNum == 1) {
				image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			}
		break;
		}
		} else {
		switch (direcImg) {
		case "s":
			image = hitFront;
		break;
		case "up":			
			if (spriteNum == 1) {
				image = hitBack;
			}
			if (spriteNum == 2) {
				image = hitBack2;
			}
		break;
		case "down":
			if (spriteNum == 1) {
				image = hitFront1;
			}
			if (spriteNum == 2) {
				image = hitFront2;
			}
		break;
		case "left":
			if (spriteNum == 1) {
				image = hitLeft;
			}
			if (spriteNum == 2) {
				image = hitLeft2;
			}
		break;
		case "right":
			if (spriteNum == 1) {
				image = hitRight;
			}
			if (spriteNum == 2) {
				image = hitRight2;
			}
		break;
		}
		}
		
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		
	}

}
