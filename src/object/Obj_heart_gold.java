package object;

import entity.Entity;
import main.GamePanel;

public class Obj_heart_gold extends Entity{
	
	public Obj_heart_gold(GamePanel gp) {
		super(gp);	
		
		name = "HeartGold";
		down1 = setup("/objects/heart_gold", gp.tileSize, gp.tileSize);

		
	}

}
