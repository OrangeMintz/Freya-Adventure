package object;

import entity.Entity;
import main.GamePanel;

public class Obj_tent  extends Entity{
	
	public Obj_tent(GamePanel gp) {
		super(gp);	
		
		name = "Tent";
		down1 = setup("/objects/tent", gp.tileSize, gp.tileSize);
		collision = true;

		
	}

}
