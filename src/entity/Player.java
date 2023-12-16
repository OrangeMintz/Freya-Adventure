package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	public int hasKey;
	public int hasPotion;
	public boolean hasSword;
	public boolean lightingOn;
	
	
	
	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2); 
		screenY = gp.screenHeight/2- (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.height = 32;
		solidArea.width = 32;
		
		
		attackArea.width = 36;
		attackArea.height = 36;
		
		setDefaultValues();
		getPlayerImage();
		getPlayerAttackImage();
		
	}
	
	public void setDefaultValues() {
		worldX = 29 * gp.tileSize;
		worldY = 9 * gp.tileSize;
		speed =  4;
		direction = "down";
		//PLAYER STATUS
		maxLife = 6;
		life = maxLife;
		attack = 1;
		//PLAYER STATE
		hasKey = 0;
		hasPotion = 0;
		hasSword = false ;
		lightingOn = false;
	}
	
	public void retryWorld(int map) {
		gp.currentMap = 0;
	}


	
	public void getPlayerImage() {		
			up1 = setup("/player/Up00", gp.tileSize, gp.tileSize);
			up2 = setup("/player/Up01", gp.tileSize, gp.tileSize);
			up3 = setup("/player/Up02", gp.tileSize, gp.tileSize);
			down1 = setup("/player/down00", gp.tileSize, gp.tileSize);
			down2 = setup("/player/down01", gp.tileSize, gp.tileSize);
			down3 = setup("/player/down02", gp.tileSize, gp.tileSize);
			left1 = setup("/player/left00", gp.tileSize, gp.tileSize);
			left2 = setup("/player/left01", gp.tileSize, gp.tileSize);
			left3 = setup("/player/left02", gp.tileSize, gp.tileSize);
			right1 = setup("/player/right00", gp.tileSize, gp.tileSize);
			right2 = setup("/player/right01", gp.tileSize, gp.tileSize);
			right3 = setup("/player/right02", gp.tileSize, gp.tileSize);

	}
	
	public void getPlayerAttackImage() {		
		attackUp1 = setup("/player/Attack_up_1", gp.tileSize, gp.tileSize*2); // 48 x 96
		attackUp2 = setup("/player/Attack_up_2", gp.tileSize, gp.tileSize*2); // 48 x 96
		
		attackDown1 = setup("/player/Attack_down_1", gp.tileSize, gp.tileSize*2); // 48 x 96
		attackDown2 = setup("/player/Attack_down_2", gp.tileSize, gp.tileSize*2); // 48 x 96
		 
		attackLeft1 = setup("/player/Attack_left_1", gp.tileSize*2, gp.tileSize); // 96 x 48
		attackLeft2 = setup("/player/Attack_left_2", gp.tileSize*2, gp.tileSize); // 96 x 48
		
		attackRight1 = setup("/player/Attack_right_1", gp.tileSize*2, gp.tileSize); // 96 x 48
		attackRight2 = setup("/player/Attack_right_2", gp.tileSize*2, gp.tileSize); // 96 x 48
		

}
	
	public void update() {
	
		if(attacking == true && hasSword == true) {
			attackingSprite();
		}
		
		else if (keyH.upPressed == true || keyH.downPressed == true
		    || keyH.leftPressed == true || keyH.rightPressed  ==true || keyH.ePressed == true) {
			

			if(keyH.upPressed == true) {
				direction = "up";			
			}
			
			else if (keyH.downPressed == true) {
				direction = "down";		
			}
			
			else if (keyH.leftPressed == true) {
				direction = "left";			
			}
			
			else if (keyH.rightPressed == true) {
				direction = "right";
				
			}
			
		
			//Check TILE COLLISION
			collisionOn = false;
			gp.collisionCheck.checkTile(this);
			
			
			int npcIndex = gp.collisionCheck.checkEntity(this, gp.npc);
			interactNPC(npcIndex);
			
			
			//Check OBJECT COLLISION
			int objectIndex = gp.collisionCheck.checkObject(this, true);
			pickUpObject(objectIndex);
			
			int monsterIndex = gp.collisionCheck.checkEntity(this, gp.monster);
			contactMonster(monsterIndex);
			
			
			//If COLLISION IS FALSE, PLAYER CAN MOVE 
			if (collisionOn == false && keyH.ePressed == false) {
				
				switch(direction) {
				case "up" : 
					worldY -= speed;	
					break;
				case "down" : 
					worldY += speed;
					break;
				case "left" : 
					worldX -= speed;
					break;
				case "right" : 
					worldX += speed;
					break;
				}
			}
			
			gp.keyH.ePressed = false;
			
			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNumber == 1) {
					spriteNumber = 2;
				}
				else if (spriteNumber == 2) {
					spriteNumber = 3;
				}
				else if (spriteNumber == 3) {
					spriteNumber = 1;
				}
			
				spriteCounter = 0;
			}
			
		}
		
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 60) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		
		if(life <= 0) {
			gp.gameState = gp.gameOver;
			gp.stopMusic();
			gp.playMusic(10);
		}
				
	}
	
	public void attackingSprite() {
		spriteCounter++;
		if(spriteCounter <= 5) { // 5 frames
			spriteNumber = 1;
		}
		if(spriteCounter > 5 && spriteCounter <=25) { // 6 to 25 frames
			spriteNumber = 2;
			
			//Save the current WorldX, WorldY and solidArea
			int currentWorldX = worldX;
			int currentWorldY = worldY;
			int solidAreaWidth = solidArea.width;
			int solidAreaHeight = solidArea.height;
			
			// Adjust player's worldX/Y for the AttackArea
			switch(direction) {
			case "up": worldY -= attackArea.height; break;
			case "down": worldY += attackArea.height; break;
			case "right": worldX += attackArea.width; break;
			case "left": worldX -= attackArea.width; break;
			}
			
			// attackSolidArea becomes defaultSolidArea
			solidArea.width = attackArea.width;
			solidArea.height = attackArea.height;
			
			// Check monster collision with the updated worldX, worldY and solidArea
			int monsterIndex = gp.collisionCheck.checkEntity(this, gp.monster);
			damageMonster(monsterIndex);		
			
			worldX = currentWorldX;
			worldY = currentWorldY;
			solidArea.width = solidAreaWidth;
			solidArea.height = solidAreaHeight;
			
		}
		
		
		
		if (spriteCounter > 25) {  // finished attack animation
			spriteNumber = 1;
			spriteCounter = 0;
			attacking = false;
		}
		
		
		
	}
	
	public void interactNPC(int i) {
		
		if(gp.keyH.ePressed == true) {
		if(i != 999) {
			
			gp.gameState = gp.dialogueState;
			gp.npc[gp.currentMap][i].speak();
			gp.playerSfx(9);

		}
		else if(hasSword == false) {
				attacking = false;
			}
		
		else if(hasSword == true) {
				attacking = true;
			}
		}
	}
	
	//Pickup Object's 
	public void pickUpObject(int i) {
		
		if(i != 999) {
			String objectName = gp.obj[gp.currentMap][i].name;
			switch (objectName) {
			case "Key":
				gp.playerSfx(4); //sfx
				hasKey++;
				gp.obj[gp.currentMap][i] = null;
				gp.ui.showMessage("You got a Key! ");
				break;
			case "Door":
				if(hasKey != 0) {
					gp.playerSfx(2);
					gp.obj[gp.currentMap][i] = null;
					gp.ui.showMessage("You've Opened a Door! ");
					hasKey--;
				}
				else {
					gp.playerSfx(1); //sfx
					gp.ui.showMessage("You don't have a Key!");
				}
				break;
				
			case "Boots":
				speed += 1;
				gp.playerSfx(3); //sfx
				System.out.println("+2 Player Speed" );
				gp.obj[gp.currentMap][i] = null;
				gp.ui.showMessage("You got a boost!");
				
				break;
				
			case "Chest":
				gp.playerSfx(14);
				gp.playMusic(16);
				gp.gameState = gp.gameEnd;
				gp.ui.showMessage("CONGRATULATIONS!");
				
				break;
				
			case "Sword":
				hasSword = true;
				gp.playerSfx(3); //sfx
				System.out.println("You can now use sword by Pressing [E]" );
				gp.obj[gp.currentMap][i] = null;
				gp.ui.showMessage("You got a Sword!");
				break;
				
			case "Heart":
				if(life == maxLife) {
					life = maxLife;
				
				}
				if(life < maxLife) {
				life++ ;
				gp.playerSfx(3); //sfx
				System.out.println("HP RECOVERED" );
				gp.obj[gp.currentMap][i] = null;
				gp.ui.showMessage("1+ HP");
				}
				break;
				
				
			case "Potion":
				hasPotion++;
				gp.playerSfx(3); //sfx
				gp.obj[gp.currentMap][i] = null;
				gp.ui.showMessage("You got a Potion");
				break;
				
			case "HeartGold":
				maxLife += 2;
				life +=2;
				gp.playerSfx(3); //sfx
				gp.obj[gp.currentMap][i] = null;
				gp.ui.showMessage("Maximum Life Increased");
				break;
				
			case "Cave":
				if(hasSword == false) {
				gp.ui.showMessage("Can't Continue without a Sword");
				}
				else {
				gp.stopMusic();
				gp.playerSfx(11);
				gp.playMusic(12);
				teleport(1, 16, 9);
				lightingOn = true;
				gp.ui.showMessage("You've descended");
				}	
				break;
				
			case "Tent":
				if(life < maxLife) {
				tentCounter++;
				if(tentCounter > 30) {
					life++;
					gp.playerSfx(3); //sfx
					gp.ui.showMessage("1+ HP");	
					tentCounter = 0;
					}	
				}		   		
				if(life == maxLife) {	
					gp.ui.showMessage("HP is Full");			
				}
				break;
				
			case "Stairs1":
				gp.playerSfx(11);
				teleport(2, 12, 32);
				lightingOn = true;
				gp.ui.showMessage("You've descended");	
				break;
				
			case "Stairs2":
				gp.stopMusic();
				gp.playerSfx(11);
				gp.playMusic(13);
				teleport(3, 26, 12);
				lightingOn = true;
				gp.ui.showMessage("You've descended");	
				break;
				
			case "Door_Iron":
				if(hasKey != 0) {
					gp.playerSfx(2);
					gp.obj[gp.currentMap][i] = null;
					gp.ui.showMessage("You've Opened a Door! ");
					hasKey--;
				}
				else {
					gp.playerSfx(1); //sfx
					gp.ui.showMessage("You don't have a Key!");								
				}
				break;
				
			case "Door_Iron_Blue":
				if(blueIn == true) {
					gp.playerSfx(2);
					gp.obj[gp.currentMap][i] = null;
					gp.ui.showMessage("You've Opened a Door! ");
					hasKey--;
				}
				else {
					gp.playerSfx(1); //sfx
					gp.ui.showMessage("You need to slay 8 bats");								
				}
				break;
				
			case "Door_Iron_Red":
				if(redIn == true) {
					gp.playerSfx(2);
					gp.obj[gp.currentMap][i] = null;
					gp.ui.showMessage("You've Opened a Door! ");
					hasKey--;
				}
				else {
					gp.playerSfx(1); //sfx
					gp.ui.showMessage("You need to slay 10 red slimes");								
				}
				break;
				
			case "Key_Blue":
				gp.playerSfx(4); //sfx
				blueKey = true;
				gp.obj[gp.currentMap][i] = null;
				gp.ui.showMessage("You got Blue Key! ");
				gp.aSetter.setMonster1();
				gp.aSetter.setObject1();
				break;
				
			case "Key_Red":
				gp.stopMusic();
				gp.playerSfx(15); //sfx
				redKey = true;
				gp.obj[gp.currentMap][i] = null;
				gp.ui.showMessage("You got the Red Key! ");
				break;
				
			case "Door_Iron_Fin":
				if(redKey == true && blueKey == true) {
					gp.playerSfx(2);
					gp.obj[gp.currentMap][i] = null;
					gp.ui.showMessage("You've Opened the Final Door!");
					hasKey--;
				}
				else {
					gp.playerSfx(1); //sfx
					gp.ui.showMessage("You need to get the Blue and Red Key");								
				}
				break;
				
			case "Sword_Gold":
				attack++;
				gp.playerSfx(3); //sfx
				System.out.println("Attack Damage Increased" );
				gp.obj[gp.currentMap][i] = null;
				gp.ui.showMessage("Attack Damage Increased");
				break;
				
				
			}	
		}			
	}
	
	public void teleport(int map, int col, int row) {
		gp.currentMap = map;
		gp.player.worldX = gp.tileSize * col;
		gp.player.worldY = gp.tileSize * row;
	}
	
	public void contactMonster(int i){
		if(i != 999) {
			if (invincible == false) {	
				life -= 1;
				gp.playerSfx(5);
				invincible = true;
			}	
		}
	}
	
	public void damageMonster(int i) {
		if(i != 999) {
			if(gp.monster[gp.currentMap][i].invincible == false) {
				
				gp.monster[gp.currentMap][i].life -= attack;
				gp.playerSfx(6);
				gp.monster[gp.currentMap][i].invincible = true;
				gp.monster[gp.currentMap][i].damageReaction();
				
				if(gp.monster[gp.currentMap][i].life <= 0) {
					gp.monster[gp.currentMap][i].dying = true;
					if(gp.currentMap == 3 && blueIn == false) {
						if(gp.monster[gp.currentMap][i].dying) {
							killcounter++;
							gp.ui.showMessage("Bat Killed: " +killcounter);
							if(killcounter >= 8 ) {
								blueIn = true;
								killcounter =0;
							}
						}
					}
					
					if(gp.currentMap == 3 && blueKey == true) {
						if(gp.monster[gp.currentMap][i].dying) {
							killcounter++;
							gp.ui.showMessage("Red Slime Killed: " +killcounter);
							if(killcounter >= 10 ) {
								redIn = true;
							}
						}
					}
				}
				
			}
		}
		
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		int tempScreenX = screenX;
		int tempScreenY = screenY;
		switch(direction) {
		
		case "up":
			if(attacking == false) {
				if(spriteNumber == 1 ) {
					image = up1;
				}
				if(spriteNumber == 2 ) {
					image = up2;
				}
				if(spriteNumber == 3 ) {
					image = up3;
				}
			}
			
			if(attacking == true && hasSword == true) {
				tempScreenY = screenY - gp.tileSize;
				if(spriteNumber == 1 ) {
					image = attackUp1;
				}
				if(spriteNumber == 2 ) {
					image = attackUp2;
				}
			}
			
			break;
		case "down":
			if(attacking == false) {
				if(spriteNumber == 1 ) {
					image = down1;
				}
				if(spriteNumber == 2 ) {
					image = down2;
				}
				if(spriteNumber == 3 ) {
					image = down3;
				}
			}
			
			if(attacking == true && hasSword == true) {
				if(spriteNumber == 1 ) {
					image = attackDown1;
				}
				if(spriteNumber == 2 ) {
					image = attackDown2;
				}
			}
			break;
		case "left":
			if(attacking == false) {
				if(spriteNumber == 1 ) {
					image = left1;
				}
				if(spriteNumber == 2 ) {
					image = left2;
				}
				if(spriteNumber == 3 ) {
					image = left3;
				}
			}
			
			if(attacking == true && hasSword == true) {
				tempScreenX = screenX - gp.tileSize;
				if(spriteNumber == 1 ) {
					image = attackLeft1;
				}
				if(spriteNumber == 2 ) {
					image = attackLeft2;
				}
			}
			
			break;
		case "right":
			if(attacking == false) {
				if(spriteNumber == 1 ) {
					image = right1;
				}
				if(spriteNumber == 2 ) {
					image = right2;
				}
				if(spriteNumber == 3 ) {
					image = right3;
				}
			}
			
			if(attacking == true && hasSword == true) {
				if(spriteNumber == 1 ) {
					image = attackRight1;
				}
				if(spriteNumber == 2 ) {
					image = attackRight2;
				}
			}
			break;
		}
		
		// INVINCIBLE ANIMATION WHEN DAMAGED
		if(invincible == true) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		}
		
		g2.drawImage(image, tempScreenX, tempScreenY, null);
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		
	}
	
}
