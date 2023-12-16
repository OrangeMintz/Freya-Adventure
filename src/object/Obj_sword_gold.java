package object;

import entity.Entity;
import main.GamePanel;

	public class Obj_sword_gold extends Entity{
		
		public Obj_sword_gold(GamePanel gp) {
			super(gp);	
			
			name = "Sword_Gold";
			down1 = setup("/objects/sword_gold", gp.tileSize, gp.tileSize);
		
		}
}
