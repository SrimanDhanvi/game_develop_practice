package object;

import entity.Entity;
import my_first2D_game.GamePanel;

public class OBJ_health extends Entity{

	
	public OBJ_health(GamePanel gp) {
		super(gp);
		
		name="Health";
		
		getSpritImages = setUpSpriteSheet("/objects/Health_object.png",1 ,1);
		
		s1 = getSpritImages[0][0];
		
		solidArea.x = -11;
		solidArea.y = -11;
		solidArea.width = 70;
		solidArea.height = 70;
		
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		collision = true;
	}
}
