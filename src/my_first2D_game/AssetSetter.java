package my_first2D_game;

import object.OBJ_OldMan;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObj() {
		
		gp.obj[0] = null;
		
		
		gp.obj[1] = new OBJ_OldMan();
		gp.obj[1].worldX = 0;
		gp.obj[1].worldY = 100;
	}
}
