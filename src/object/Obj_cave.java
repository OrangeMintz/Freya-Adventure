package object;

import entity.Entity;
import main.GamePanel;

public class Obj_cave  extends Entity{
	
	public Obj_cave(GamePanel gp) {
		super(gp);	
		
		name = "Cave";
		down1 = setup("/objects/cave_outside", gp.tileSize, gp.tileSize);
		collision = true;

		
	}

}
