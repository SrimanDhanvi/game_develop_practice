package object;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_OldMan extends SuperObject{

	public OBJ_OldMan() {
		
		name="Old man";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Old_man_NPC.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		solidArea = new Rectangle();
		solidArea.x = 0;
		solidArea.y = 28;
		solidArea.width = 48;
		solidArea.height = 20; 
		
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		collision = true;
		
	}
}
