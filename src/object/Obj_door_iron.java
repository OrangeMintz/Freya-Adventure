package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Obj_door_iron extends Entity {

	
	public Obj_door_iron(GamePanel gp) {
		super(gp);	
		
		name = "Door_Iron";
		down1 = setup("/objects/door_iron", gp.tileSize, gp.tileSize);
		collision = true;

		
	}
}
