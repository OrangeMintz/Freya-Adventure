package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Obj_door_iron_fin extends Entity {

	
	public Obj_door_iron_fin(GamePanel gp) {
		super(gp);	
		
		name = "Door_Iron_Fin";
		down1 = setup("/objects/door_iron_fin", gp.tileSize, gp.tileSize);
		collision = true;

		
	}
}
