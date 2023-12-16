package object;

import entity.Entity;
import main.GamePanel;

public class Obj_heart extends Entity{
	
	public Obj_heart(GamePanel gp) {
		super(gp);	
		
		name = "Heart";
		down1 = setup("/objects/heart_full", gp.tileSize/2, gp.tileSize/2);

		
	}

}
