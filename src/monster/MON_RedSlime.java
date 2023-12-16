package monster;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;




public class MON_RedSlime extends Entity{
	
	
	public MON_RedSlime(GamePanel gp) {
		super(gp);
		attack = 2;
		type = 2;
		name = "RedSlime";
		speed = 1;
		
		maxLife = 6;
		life = maxLife;
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		getImage();
		
	}
	
	public void getImage() {
		
		up1 = setup("/monster/redslime_down_1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/redslime_down_2", gp.tileSize, gp.tileSize);
		down1 = setup("/monster/redslime_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/redslime_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/redslime_down_1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/redslime_down_2", gp.tileSize, gp.tileSize);
		right1 = setup("/monster/redslime_down_1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/redslime_down_2", gp.tileSize, gp.tileSize);
	
	}
	
	//AI ACTION FOR EVERY ENTITY
		public void setAction() {
			
			actionCounter++;
			if(actionCounter == 60) {
				Random random = new Random();
				int i = random.nextInt(100)*1;
				
				if(i <= 25) {
					direction = "up";
				}
				
				if(i > 25 && i <= 50) {
					direction = "down";
				}
				
				if(i > 50 && i <= 75) {
					direction =  "left";
					
				}
				
				if(i > 75 && i <= 100) {
					direction = "right";
				}
				actionCounter = 0;
			}	

		}
		
		public void damageReaction() {
			actionCounter = 0;
		}
 
}
