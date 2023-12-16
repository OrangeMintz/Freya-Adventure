package object;

import entity.Entity;
import main.GamePanel;

public class Obj_stairs1  extends Entity{
	
	public Obj_stairs1(GamePanel gp) {
		super(gp);	
		
		name = "Stairs1";
		down1 = setup("/objects/stairs00", gp.tileSize, gp.tileSize);
		collision = true;

		
	}

}
