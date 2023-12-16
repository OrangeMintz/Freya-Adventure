package entity;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class NPC_OldMan extends Entity{

	public NPC_OldMan(GamePanel gp) {
		super(gp);
			
		direction = "down";
		speed = 1;
		
		getImage();
		setDialogue();		
	}
	
	public void getImage() {
	
		up1 = setup("/npc/oldman_up_1", gp.tileSize, gp.tileSize);
		up2 = setup("/npc/oldman_up_2", gp.tileSize, gp.tileSize);
		down1 = setup("/npc/oldman_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/npc/oldman_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/npc/oldman_left_1", gp.tileSize, gp.tileSize);
		left2 = setup("/npc/oldman_left_2", gp.tileSize, gp.tileSize);
		right1 = setup("/npc/oldman_right_1", gp.tileSize, gp.tileSize);
		right2 = setup("/npc/oldman_right_2", gp.tileSize, gp.tileSize);
	}
	
	//AI ACTION FOR EVERY ENTITY
	public void setAction() {
		
		actionCounter++;
		if(actionCounter == 120) {
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
	
	public void speak() {
		
		super.speak();
		
	}
	
	public void setDialogue() { 
		dialogue[0] = "Hello, lad!";
		dialogue[1] = "What brings you here today?";
		dialogue[2] = "Are you up for an adventure?";
		dialogue[3] = "If so, goodluck on that!";
		dialogue[4] = "There are myths from the village, they say \nthat beneath the cave of Orsolon.";
		dialogue[5] = "Lies a great treasure.";
		dialogue[6] = "If you were planning on going there.";
		dialogue[7] = "I shall grant you my blessing.";
		dialogue[8] = "find the key on my old shelter, and bring \nthe sword with you.";
		
	}
}
