package my_first2D_game;

import mobs.Mob_Torroid;
import object.OBJ_OldMan;
import object.OBJ_health;

public class AssetSetter {

	GamePanel gp;
	
	int timer;
	int spawnRange = 1000;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObj() {
		
		gp.obj[0] = null;
		
		gp.obj[1] = new OBJ_OldMan();
		gp.obj[1].worldX = 0;
		gp.obj[1].worldY = 110;
		
	}
	
	public void objRespawn(int objectNum, boolean condition) {
	       if (gp.obj[objectNum] == null&&condition) {
	    	   
	   		gp.obj[objectNum] = new OBJ_health();
	   		gp.obj[objectNum].worldX = gp.player.worldX + (int)(Math.random() * 2 * spawnRange - spawnRange);
	   		gp.obj[objectNum].worldY = gp.player.worldY + (int)(Math.random() * 2 * spawnRange - spawnRange);
	   		}
	          
	          timer++;
	          
	          if(timer>1800) {
	          gp.obj[objectNum].worldX = gp.player.worldX + (int)(Math.random() * 2 * spawnRange - spawnRange);
	   		gp.obj[objectNum].worldY = gp.player.worldY + (int)(Math.random() * 2 * spawnRange - spawnRange);
	   		timer = 0;
	   	}
	}
	
	public void setNPC() {
	}
	
	public void setMob() {
		gp.monster[0] = new Mob_Torroid(gp);
   		gp.monster[0].worldX = 25;
   		gp.monster[0].worldY = 25;
	}

}
