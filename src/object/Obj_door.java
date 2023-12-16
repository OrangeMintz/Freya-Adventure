package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Obj_door extends Entity {

	
	public Obj_door(GamePanel gp) {
		super(gp);	
		
		name = "Door";
		down1 = setup("/objects/door", gp.tileSize, gp.tileSize);
		collision = true;

		
	}
}
