package my_first2D_game;

import entity.Entity;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = Math.floorDiv(entityLeftWorldX, gp.tileSize);
		int entityRightCol = Math.floorDiv(entityRightWorldX, gp.tileSize);
		int entityTopRow =  Math.floorDiv(entityTopWorldY, gp.tileSize);
		int entityBottomRow = Math.floorDiv(entityBottomWorldY, gp.tileSize);
		
		int tileNum1, tileNum2;
		
		switch (entity.direction) {
		case "up":
			entityTopRow = Math.floorDiv(entityTopWorldY - entity.speed,gp.tileSize);
			tileNum1 = gp.chunkManger.getTileID(entityLeftCol, entityTopRow);
			tileNum2 = gp.chunkManger.getTileID(entityRightCol, entityTopRow);
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "down":
			entityBottomRow = Math.floorDiv(entityBottomWorldY + entity.speed, gp.tileSize);
			tileNum1 = gp.chunkManger.getTileID(entityLeftCol, entityBottomRow);
			tileNum2 = gp.chunkManger.getTileID(entityRightCol, entityBottomRow);
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "left":
			entityLeftCol = Math.floorDiv(entityLeftWorldX - entity.speed, gp.tileSize);
			tileNum1 = gp.chunkManger.getTileID(entityLeftCol, entityTopRow);
			tileNum2 = gp.chunkManger.getTileID(entityLeftCol, entityBottomRow);
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "right":
			entityRightCol = Math.floorDiv(entityRightWorldX + entity.speed, gp.tileSize);
			tileNum1 = gp.chunkManger.getTileID(entityRightCol, entityTopRow);
			tileNum2 = gp.chunkManger.getTileID(entityRightCol, entityBottomRow);
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		}
		
	}
	
	public int checkObject(Entity entity, boolean player) {
		
		int index = 999;
		
		for(int i=0;i < gp.obj.length;i++) {
			if(gp.obj[i] != null) {
				//Get entity's solid area position
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				// Get player's solid area position
				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
				
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if (gp.obj[i].collision == true) {
								entity.collisionOn = true;
							}
							if (player == true) {
								index = i;
							}
						}
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if (gp.obj[i].collision == true) {
								entity.collisionOn = true;
							}
							if (player == true) {
								index = i;
							}
						}
					}
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if (gp.obj[i].collision == true) {
								entity.collisionOn = true;
							}
							if (player == true) {
								index = i;
							}
						}
					}
					break;
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				
				gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
				gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
			}
		}
		
		return index;
	}

}
