package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
			
			spriteSheet = ImageIO.read(getClass().getResourceAsStream("/player_images/Spritesheet_Player.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedImage[][] allDirections = new BufferedImage[3][4]; // 4 directions, 4 frames each
		for (int dir = 0; dir < 3; dir++) {
		    for (int i = 0; i < 4; i++) {
		        allDirections[dir][i] = spriteSheet.getSubimage(i * 48, dir * 48, 48, 48);
		    }
		}
		
		s = allDirections[0][0];
		up1 = allDirections[0][3];
		up2 = allDirections[1][0];
		down1 = allDirections[0][1];
		down2 = allDirections[0][2];
		left1 = allDirections[1][3];
		left2 = allDirections[2][0];
		right1 = allDirections[1][1];
		right2 = allDirections[1][2];
		
	}
	
	public void update() {
		
		direction = "s";
		direction2 = "";
		
		if (keyH.upPressed == true || keyH.downPressed == true 
				||keyH.leftPressed == true ||keyH.rightPressed == true) {
		
		if (keyH.upPressed == true && keyH.leftPressed == true) {
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

		
		spriteCounter++;
		
		if (spriteCounter > 15) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
			spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
	}
		
//		System.out.println(worldX);
//		System.out.println(worldY);
}
	
	public void draw(Graphics2D g2) {
		
//		g2.setColor(new Color(255, 255, 255, 10));
//		g2.fillOval(screenX-6, screenY+16, 60, 60);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "s":
			image = s;
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
		
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		
	}

}
