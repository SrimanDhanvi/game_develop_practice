package my_first2D_game;

import object.OBJ_OldMan;
import object.OBJ_health;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObj() {
		
		gp.obj[0] = new OBJ_health();
		gp.obj[0].worldX = (int)(Math.random()*100000+500);
		gp.obj[0].worldY = (int)(Math.random()*1000+500);
		
		gp.obj[1] = new OBJ_health();
		gp.obj[1].worldX = (int)((Math.random()*100000+500)*(-1));
		gp.obj[1].worldY = (int)(Math.random()*10000+500);
		
		gp.obj[2] = new OBJ_health();
		gp.obj[2].worldX = (int)(Math.random()*10000+500);
		gp.obj[2].worldY = (int)(Math.random()*10000+500);
		
		gp.obj[3] = new OBJ_health();
		gp.obj[3].worldX = (int)((Math.random()*1000+500)*(-1));
		gp.obj[3].worldY = (int)(Math.random()*10000+500);
		
		gp.obj[4] = new OBJ_health();
		gp.obj[4].worldX = (int)(Math.random()*100000+500);
		gp.obj[4].worldY = (int)(Math.random()*10000+500);
		
		gp.obj[5] = new OBJ_health();
		gp.obj[5].worldX = (int)((Math.random()*100000000+500)*(-1));
		gp.obj[5].worldY = (int)(Math.random()*1000000+500);
		
		gp.obj[6] = new OBJ_health();
		gp.obj[6].worldX = (int)(Math.random()*1000000+500);
		gp.obj[6].worldY = (int)(Math.random()*100000+500);
		
		gp.obj[7] = new OBJ_health();
		gp.obj[7].worldX = (int)((Math.random()*1000+500)*(-1));
		gp.obj[7].worldY = (int)(Math.random()*10000+500);
		
		gp.obj[8] = new OBJ_health();
		gp.obj[8].worldX = (int)(Math.random()*100000000+500);
		gp.obj[8].worldY = (int)(Math.random()*100000000+500);
		
		gp.obj[9] = new OBJ_OldMan();
		gp.obj[9].worldX = 96;
		gp.obj[9].worldY = 72;
	}
}
