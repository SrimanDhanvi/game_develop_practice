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

}
