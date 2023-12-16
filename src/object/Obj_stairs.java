package object;

import entity.Entity;
import main.GamePanel;

public class Obj_stairs  extends Entity{
	
	public Obj_stairs(GamePanel gp) {
		super(gp);	
		
		name = "Stairs";
		down1 = setup("/objects/stairs01", gp.tileSize, gp.tileSize);
		collision = true;

		
	}

}
