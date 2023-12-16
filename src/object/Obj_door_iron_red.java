package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Obj_door_iron_red extends Entity {

	
	public Obj_door_iron_red(GamePanel gp) {
		super(gp);	
		
		name = "Door_Iron_Red";
		down1 = setup("/objects/door_iron_red", gp.tileSize, gp.tileSize);
		collision = true;

		
	}
}
