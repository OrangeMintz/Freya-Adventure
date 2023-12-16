package object;

import entity.Entity;
import main.GamePanel;

public class Obj_potion extends Entity{
	
	public Obj_potion(GamePanel gp) {
		super(gp);	
		
		name = "Potion";
		down1 = setup("/objects/potion_red", gp.tileSize/2, gp.tileSize/2);

		
	}

}
