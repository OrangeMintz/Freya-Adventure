package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
	
	public GamePanel gp;
	public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2,left3,  right1, right2, right3;
	public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
	public BufferedImage image, image2, image3;
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public Rectangle attackArea = new Rectangle(0,0,0,0);
	public boolean collision = false;
	public int solidAreaDefaultX, solidAreaDefaultY;
	
	
	//STATE
	public int worldX, worldY;
	public String direction = "down";
	public int spriteNumber = 1;
	public int spriteAttNumber = 1;
	public boolean collisionOn = false;
	public boolean invincible = false;
	public boolean attacking = false;
	public boolean alive = true;
	public boolean dying = false;
	public boolean hpBarOn = false;
	
	//Entity Damage
	public int attack;
	
	//Doors
	public boolean blueIn = false;
	public boolean redIn = false;
	
	public boolean blueKey = false;
	public boolean redKey = false;
	
	// CHARACTER STATUS
	public int type; // 0 = player, 1 = npc, 2 = monster;
	public int speed;
	public String name;
	public int maxLife;
	public int life;
	
	//NPC DIALOGUE
	public String[] dialogue = new String [20];
	
	
	// 
	public int spriteAttack = 0;
	public int spriteCounter = 0; // Movement
	public int actionCounter = 0; // Action
	public int invincibleCounter = 0; // Invincible
	public int dialogueIndex = 0; // NPC DIALOGUE
	public int dyingCounter = 0; // Monster Death Animation
	public int hpBarCounter = 0; // HP Bar UI 	
	public int tentCounter = 0; // Tent counter
	public int killcounter = 0; // Kills counter

	
	public Entity(GamePanel gp) {
		this.gp = gp;
	} 
	
	//AI ACTION FOR EVERY ENTITY
	public void setAction() {
		//SUBCLASS setAction method
	}
	
	// MONSTER REACTION AFTER DAMAGE
	public void damageReaction() {
		//SUBCLASS damageReaction method
	}
	//NPC DIALOGUES
	public void speak() {
		//DIALOGUE POINTER
				if(dialogue[dialogueIndex] == null) {
				dialogueIndex = 0;
				}
				
				gp.ui.currentDialogue = dialogue[dialogueIndex];
				dialogueIndex++;
				
				//Entities Direction when Interact
				switch(gp.player.direction){
					case "up":
					direction = "down";
					break;
					
					case "down":
						direction = "up";
						break;
						
					case "left":
						direction = "right";
						break;
						
					case "right":
						direction = "left";
						break;
				}
				
	}
	
	public void update() {
		//AI UPDATE IMPLEMENTATION METHODS
		setAction(); //AI MOVEMENT
	
		collisionOn = false;
		gp.collisionCheck.checkTile(this); //AI TILE COLLISION
		gp.collisionCheck.checkObject(this, false); // AI OBJECT COLLISION
		
		gp.collisionCheck.checkEntity(this, gp.npc);
		gp.collisionCheck.checkEntity(this, gp.monster);
		boolean contactPlayer = gp.collisionCheck.checkPlayer(this); //AI and PLAYER COLLISION
		if(this.type == 2 && contactPlayer == true) {
			if(gp.player.invincible == false) {
				if(this.attack == 1) {
					gp.player.life -= 1;
					gp.playerSfx(5);
					gp.player.invincible = true;
				}
				if(this.attack == 2) {
					gp.player.life -= 2;
					gp.playerSfx(5);
					gp.player.invincible = true;
				}
			}
		}
		
		//If COLLISION IS FALSE, ENTITY CAN MOVE 
		if (collisionOn == false) {
			
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
		
		spriteCounter++;
		if(spriteCounter > 15) {
			if(spriteNumber == 1) {
				spriteNumber = 2;
			}
			else if (spriteNumber == 2) {
				spriteNumber = 1;
			}
		
			spriteCounter = 0;
		}
		
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 40) {
				invincible = false;
				invincibleCounter = 0;
			}
		}	
		
	}
	
	
	
	//DRAW ENTITIES
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;

		int screenX = worldX - gp.player.worldX + gp.player.screenX;  
		int screenY = worldY - gp.player.worldY + gp.player.screenY;   
						
		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
		   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
		   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
		   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
		 
		   
		   switch(direction) {
			case "up":
				if(spriteNumber == 1 ) {
					image = up1;
				}
				if(spriteNumber == 2 ) {
					image = up2;
				}
				break;
			case "down":
				if(spriteNumber == 1 ) {
					image = down1;
				}
				if(spriteNumber == 2 ) {
					image = down2;
				}
				break;
			case "left":
				if(spriteNumber == 1 ) {
					image = left1;
				}
				if(spriteNumber == 2 ) {
					image = left2;
				}
				break;
			case "right":
				if(spriteNumber == 1 ) {
					image = right1;
				}
				if(spriteNumber == 2 ) {
					image = right2;
				}
				break;
			}
		   
		   
		   // MONSTER HP BAR
		   if(type == 2 && hpBarOn == true) {
			   
		   double oneScale = (double)gp.tileSize/maxLife;
		   double hpBarValue = oneScale*life;
			   
		   g2.setColor(new Color(35,35,35));
		   g2.fillRect(screenX-1, screenY-4, gp.tileSize+2, 12);
		   g2.setColor(new Color(255,0,30));
		   g2.fillRect(screenX, screenY-3, (int)hpBarValue, 10);
		   
		   hpBarCounter++;
		   if(hpBarCounter > 680) {
			   hpBarCounter = 0;
			   hpBarOn = false;
			   
		   		}
		   
		   }
		   
		   
		   if(invincible == true) {
			    hpBarOn = true;
			    hpBarCounter = 0;
				changeAlpha(g2, 0.4f);
			}
		   
		   if(dying == true) {
			   dyingAnimation(g2);
		   }
		   
		   
		   g2.drawImage(image, screenX, screenY, null);
		   changeAlpha(g2,1f);
		}	 
	}
	
	public void dyingAnimation(Graphics2D g2) {
		dyingCounter++;
		
		if(dyingCounter <= 5) {
			changeAlpha(g2,0f);
		}
		if(dyingCounter > 5 && dyingCounter >= 10) {
			changeAlpha(g2,1f);
		}
		if(dyingCounter > 10 && dyingCounter >= 15) {
			changeAlpha(g2,0f);
		}
		if(dyingCounter > 15 && dyingCounter >= 20) {
			changeAlpha(g2,1f);
		}
		if(dyingCounter > 25 && dyingCounter >= 25) {
			changeAlpha(g2,0f);
		}
		if(dyingCounter > 25 && dyingCounter >= 30) {
			changeAlpha(g2,1f);
		}
		if(dyingCounter > 30 && dyingCounter >= 35) {
			changeAlpha(g2,0f);
		}
		if(dyingCounter > 35 && dyingCounter >= 40) {
			changeAlpha(g2,1f);
		}
		if(dyingCounter > 40) {
			dying = false;
			alive = false;
		}
	}
	
	public void changeAlpha(Graphics2D g2, float alphaValue) {
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
	}
	
	
	//LOCATES ENTITY'S IMAGE
	public BufferedImage setup(String imagePath, int width, int height) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, width, height);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	
	
	
	
}
