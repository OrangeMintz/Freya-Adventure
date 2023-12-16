package monster;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;


public class MON_Bat extends Entity{
	

	
	public MON_Bat(GamePanel gp) {
		super(gp);
		attack = 1;
		type = 2;
		name = "Bat";
		speed = 3;
		
		maxLife = 4;
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
		
		up1 = setup("/monster/bat_down_1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/bat_down_2", gp.tileSize, gp.tileSize);
		down1 = setup("/monster/bat_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/bat_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/bat_down_1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/bat_down_2", gp.tileSize, gp.tileSize);
		right1 = setup("/monster/bat_down_1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/bat_down_2", gp.tileSize, gp.tileSize);
	
	}
	
	//AI ACTION FOR EVERY ENTITY
		public void setAction() {
			
			actionCounter++;
			if(actionCounter == 80) {
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
		
 
}
