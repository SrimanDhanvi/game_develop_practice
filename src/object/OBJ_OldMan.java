package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_OldMan extends SuperObject {

	public OBJ_OldMan() {
		
		name = "Old Man";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Old_man_NPC.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		collision = true;
	}
	
}
