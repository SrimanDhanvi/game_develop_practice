package object;

import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_health extends SuperObject{

	
	public OBJ_health() {
		
		
		name="Health";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Health_object.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		solidArea = new Rectangle(-11,-11,70,70);
		
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		collision = true;
	}
}
