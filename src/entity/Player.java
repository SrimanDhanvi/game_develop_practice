package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import my_first2D_game.GamePanel;
import my_first2D_game.Keyhandler;

public class Player extends Entity{
	
	
	Keyhandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	public Player(GamePanel gp, Keyhandler keyH) {
		
		super(gp);
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - gp.tileSize/2;
		screenY = gp.screenHeight/2 - gp.tileSize/2;
		
		solidArea = new Rectangle(8 ,32 ,32 ,16);
		solidArea.x=8;
		solidArea.y=32;
		solidArea.width=32;
		solidArea.height=16;
		
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
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
	
		characterNo();
		
		getSpritImages = setUpSpriteSheet(imgPath,4 ,5);
		
		
		s1 = getSpritImages[0][0];
		s2 = getSpritImages[3][3];
		up1 = getSpritImages[0][3];
		up2 = getSpritImages[1][0];
		down1 = getSpritImages[0][1];
		down2 = getSpritImages[0][2];
		left1 = getSpritImages[1][3];
		left2 = getSpritImages[2][0];
		right1 = getSpritImages[1][1];
		right2 = getSpritImages[1][2];
		hitRight = getSpritImages[2][1];
		hitLeft = getSpritImages[2][2];
		hitFront = getSpritImages[2][3];
		hitFront1 = getSpritImages[3][0];
		hitFront2 = getSpritImages[3][1];
		hitBack = getSpritImages[3][2];
		hitBack2 = getSpritImages[4][0];
		hitRight2 = getSpritImages[4][1];
		hitLeft2 = getSpritImages[4][2];
		
		
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
		
		diaSpeed = (int)(speed/Math.sqrt(2));
		
		//Check tile collision
		collisionOn = false;
		gp.cChecker.checkTile(this);
		
		//Check object collision
		objectIndex = gp.cChecker.checkObject(this, true);
		pickUpObject(objectIndex);
		
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

	public void pickUpObject(int i) {
		
		// different cases for different objects touched by the player
		if(i != 999) {
			switch(i) {
			case 0:
				gp.playSE(2);
				gp.obj[0] = null;
				gp.ui.showMessage(1);
				break;
			case 1:
				if(gp.ui.dsno == 0) {
				gp.ui.setDialouge(1);
				break;
				}
			}
		}
		
		// remove the variable and replace it with no. of kills.
		a++;
		gp.aSetter.objRespawn(0, a>20);
		
		if(a>20) {
			a = 0;
		}


	}
	
	public void draw(Graphics2D g2) {
		
		
//		{
//        Point2D center = new Point2D.Float(screenX+24, screenY+41);
//        float radius = 25;
//        float[] dist = {0.5f, 1.0f};  // From center to edge
//        Color[] colors = { new Color(0, 0, 0, 0), new Color(0, 255, 255, 100)};  // Bright center to transparent
//
//        RadialGradientPaint rgp = new RadialGradientPaint(center, radius, dist, colors);
//
//        g2.setPaint(rgp);
//        g2.fillOval(screenX-2, screenY+16, 50, 50);
//		}
		
		g2.setColor(new Color(0, 0, 0, 100));
		g2.fillOval(screenX+3, screenY+22, 40, 40);
        
		
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
