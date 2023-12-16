package object;

import entity.Entity;
import main.GamePanel;

	public class Obj_sword extends Entity{
		
		public Obj_sword(GamePanel gp) {
			super(gp);	
			
			name = "Sword";
			down1 = setup("/objects/sword_normal", gp.tileSize, gp.tileSize);
		
		}
}
