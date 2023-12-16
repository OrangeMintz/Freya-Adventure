package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Obj_door_iron_blue extends Entity {

	
	public Obj_door_iron_blue(GamePanel gp) {
		super(gp);	
		
		name = "Door_Iron_Blue";
		down1 = setup("/objects/door_iron_blue", gp.tileSize, gp.tileSize);
		collision = true;

		
	}
}
