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
		gp.obj[0].worldX = 1000;
		gp.obj[0].worldY = 1000;
		
		gp.obj[1] = new OBJ_OldMan();
		gp.obj[1].worldX = 96;
		gp.obj[1].worldY = 72;
	}
}
