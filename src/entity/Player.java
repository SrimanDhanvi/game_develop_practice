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
			
			s = ImageIO.read(getClass().getResourceAsStream("/player_images/Design1_static.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/player_images/Design1_Back_walk1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player_images/Design1_Back_walk2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player_images/Design1_Front_walk1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player_images/Design1_Front_walk2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player_images/Design1_side_LeftWalk1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player_images/Design1_side_LeftWalk2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player_images/Design1_side_RightWalk1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player_images/Design1_side_RightWalk2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		
		direction = "s";
		
		if (keyH.upPressed == true || keyH.downPressed == true 
				||keyH.leftPressed == true ||keyH.rightPressed == true) {
		
		if (keyH.upPressed == true) {
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
		
		g2.setColor(new Color(255, 255, 255, 10));
		g2.fillOval(screenX-6, screenY+16, 60, 60);
		
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
