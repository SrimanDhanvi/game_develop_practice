package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import my_first2D_game.GamePanel;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[26];
		getTileImage();
	}
	
	public void getTileImage() {
		
		
		try {
			
		tile[0] = new Tile();	
		tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Darker_Default_cement_tile.png"));//0
		
		tile[1] = new Tile();
		tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Darker_Cracked_cement_tile.png"));//1
		
		tile[2] = new Tile();
		tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Darker_Small_Cracked_cement_tile.png"));//2
		
		tile[3] = new Tile();
		tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall3_object.png"));//3
		tile[3].collision = true;
		
		tile[4] = new Tile();
		tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall4_object.png"));//4
		tile[4].collision = true;
		
		tile[5] = new Tile();
		tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Metal_plate.png"));//5
		
		
		tile[6] = new Tile();
		tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Metal_floor_tile.png"));//6
		
		tile[7] = new Tile();
		tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Metal _Box_tile.png"));//7
		
		tile[8] = new Tile();
		tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Cage_tile1.png"));//8
		tile[8].collision = true;
		
		tile[9] = new Tile();
		tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Cage_tile2.png"));//9
		
		tile[10] = new Tile();
		tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Pipes_tile.png"));//10
		tile[10].collision = true;
		
		tile[11] = new Tile();
		tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Pipes_end.png"));//11
		
		tile[12] = new Tile();
		tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Default_cement_tile.png"));//12
		
		tile[13] = new Tile();
		tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Mud_Default_cement_tile.png"));//13
		
		tile[14] = new Tile();
		tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Mud_Cracked_cement_tile.png"));//14
		
		tile[15] = new Tile();
		tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall_turn_bottom_left.png"));//15
		tile[15].collision = true;
		
		tile[16] = new Tile();
		tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall_turn_Bottom_right.png"));//16
		tile[16].collision = true;
		
		tile[17] = new Tile();
		tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall_Top_left.png"));//17
		tile[17].collision = true;
		
		tile[18] = new Tile();
		tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall_Top_Right.png"));//18
		tile[18].collision = true;
		
		tile[19] = new Tile();
		tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall_Left.png"));//19
		tile[19].collision = true;
		
		tile[20] = new Tile();
		tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall_Right.png"));//20
		tile[20].collision = true;
		
		tile[21] = new Tile();
		tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Skeleton_Debris1.png"));//21
		
		tile[22] = new Tile();
		tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Skeleton_Debris2.png"));//22
		
		tile[23] = new Tile();
		tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Skeleton_Debris3.png"));//23
		
		tile[24] = new Tile();
		tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Skeleton_Debris4.png"));//24
		
		tile[25] = new Tile();
		tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall_light.png"));//25
		tile[25].collision = true;
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public int tileNum;
public ArrayList<Integer> lightTileX = new ArrayList<>();
public ArrayList<Integer> lightTileY = new ArrayList<>();
	
	public void draw(Graphics2D g2) {
		
		lightTileX.clear();
		lightTileY.clear();
		
		int buffer = 2;
		
		int startTileX = (gp.player.worldX / gp.tileSize) - (gp.maxScreenCol / 2) - buffer;
		int endTileX = (gp.player.worldX / gp.tileSize) + (gp.maxScreenCol / 2) + buffer;
		
		int startTileY = (gp.player.worldY / gp.tileSize) - (gp.maxScreenRow / 2) - buffer;
		int endTileY = (gp.player.worldY / gp.tileSize) + (gp.maxScreenRow / 2) + buffer;
				
	    for (int worldTileX = startTileX;worldTileX <= endTileX;worldTileX++) {
	    	for (int worldTileY = startTileY;worldTileY <= endTileY;worldTileY++) {
	    		
	    		int worldX = worldTileX*gp.tileSize;
	    		int worldY = worldTileY*gp.tileSize;
	    		
	    		int screenX = worldX - gp.player.worldX + gp.player.screenX ;
	    		int screenY = worldY - gp.player.worldY + gp.player.screenY ;
	    		
	    		tileNum = gp.chunkManger.getTileID(worldTileX, worldTileY);
	    		
	    		if (tileNum == 25) {
	    			lightTileX.add(screenX);
	    			lightTileY.add(screenY);
	    		}
	   
	    		g2.drawImage(tile[tileNum].image , screenX, screenY, gp.tileSize, gp.tileSize, null);
	    		
	    	}
	    }
	}

	
}
