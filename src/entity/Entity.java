package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import my_first2D_game.GamePanel;

public class Entity {
	
	GamePanel gp;
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
    
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	public int diaSpeed;
	public int objectIndex;
	public int dsno = 0;
	
	public String imgPath;
	public int characterNum = 0;
	public String arrayImgPath[] = new String[10];
	public BufferedImage[][] getSpritImages;
	
	public int actionLockCounter = 0;
	
	public int maxLife;
	public int life;
    
    public Entity(GamePanel gp) {
    	this.gp = gp;
    }
    
    // OBJECT AND NPC
    public void setAction() {};
    public void update() {
    	
    	setAction();
    	
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
		
		if (spriteCounter > 50) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
			spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}

    	public void draw(Graphics2D g2) {
    		
    		BufferedImage image = null;
    		
    		int screenX = (int)(worldX - gp.player.worldX + gp.player.screenX) ;
    		int screenY = (int)(worldY - gp.player.worldY + gp.player.screenY) ;
    		
    		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
    			worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
    			worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
    			worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
    			
    			switch(direction) {
    			case "s":
    					image = s1;
    			break;
    			case "up":			
    					image = up1;
    			break;
    			case "down":
    					image = down1;
    			break;
    			case "left":
    					image = left1;
    			break;
    			case "right":
    					image = right1;
    			break;
    			}
    		}
    			
    			g2.setColor(new Color(0, 0, 0, 100));
    			g2.fillOval(screenX+12, screenY+40, 20, 20);
    			g2.drawImage(image , screenX, screenY, gp.tileSize, gp.tileSize, null);
    	}
    	
    // -------------
    
    public void characterNo() {
    	arrayImgPath[0] = "/player_images/Spritesheet_Player4_Char1.png";
    	arrayImgPath[1] = "/player_images/Spritesheet_Player01_Char2.png";
    	
    	imgPath = arrayImgPath[characterNum];
    }
    
    public BufferedImage[][] setUpSpriteSheet(String path, int x, int y) {
    	

    	
		try {
			
			spriteSheet = ImageIO.read(getClass().getResourceAsStream(path));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedImage[][] allDirections = new BufferedImage[y][x]; // 4 directions, 4 frames each
		for (int dir = 0; dir < allDirections.length; dir++) {
		    for (int i = 0; i < allDirections[0].length; i++) {
		        allDirections[dir][i] = spriteSheet.getSubimage(i * 48, dir * 48, 48, 48);
		    }
		}
		return allDirections;
    }
}
