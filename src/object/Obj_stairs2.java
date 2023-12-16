package object;

import entity.Entity;
import main.GamePanel;

public class Obj_stairs2  extends Entity{
	
	public Obj_stairs2(GamePanel gp) {
		super(gp);	
		
		name = "Stairs2";
		down1 = setup("/objects/stairs00", gp.tileSize, gp.tileSize);
		collision = true;

		
	}

}
