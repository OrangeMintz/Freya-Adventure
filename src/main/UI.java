package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import entity.Entity;
import object.Obj_boots;
import object.Obj_heartUI;
import object.Obj_key;
import object.Obj_potion;

public class UI {
	GamePanel gp;
	Graphics2D g2;

	Font maruMonica, purisaB, badMofo, arcadeClassic;
	int commandNum = 0;
	public boolean messageON = false;
	public String message = "";
	int messageCounter = 0;
	
	// Dialogue
	public String currentDialogue = "";
//	BufferedImage keyImage;
	BufferedImage potionImage;
	
	
	//Image for OBJECT HEART
	BufferedImage heart_Blank, heart_Haft, heart_Full;
	public UI(GamePanel gp) {
		this.gp = gp;
		
		
		//imports FONT
		try {
			InputStream is = getClass().getResourceAsStream("/font/ARCADECLASSIC.TTF");
			arcadeClassic = Font.createFont(Font.TRUETYPE_FONT, is);
			is = getClass().getResourceAsStream("/font/BadMofo.ttf");
			badMofo = Font.createFont(Font.TRUETYPE_FONT, is);		
			is = getClass().getResourceAsStream("/font/Purisa Bold.ttf");
			purisaB = Font.createFont(Font.TRUETYPE_FONT, is);	
			is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
			maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);			
			
		} catch (FontFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		Obj_potion potion = new Obj_potion(gp);
		potionImage = potion.down1;
		
//		Obj_key key = new Obj_key();
//		keyImage = key.image;
		
		//CREATE HUD OBJECT
		Entity heart = new Obj_heartUI(gp);
		
		heart_Blank = heart.image; // variable for object heart blank
		heart_Haft = heart.image2; // variable for object heart haft
		heart_Full = heart.image3; // variable for object heart full
	}
	
	public void showMessage(String text) {
		message = text;
		messageON = true;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
			
		}
		
		if(gp.gameState == gp.playState) {
			drawPlayerLife();
			drawPotion();
			
		}
		
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
		
		if(gp.gameState == gp.dialogueState) {
			drawDialogueScreen();
		}
		
		if(gp.gameState == gp.gameOver) {
			drawGameOver();
		}
		
		if(gp.gameState == gp.gameEnd) {
			drawEndScreen();
		}
		
//		=====================================================================================
		g2.setFont(purisaB);
		g2.setColor(Color.white);
//		g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawString("= "+ gp.player.hasKey, gp.tileSize+24, gp.tileSize+17);
//		
		if(messageON == true) {
			
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20F));
			g2.drawString(message, gp.tileSize/2, 100);
			
			messageCounter++;
			
			if(messageCounter > 120) {
				messageCounter = 0;
				messageON = false;
//				
//		=====================================================================================
			}
		}
	}
	
	public void drawTitleScreen() {
		//Title Name and BGC Setup

		g2.setFont(maruMonica);
		g2.setColor(Color.black);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,90F));
		//TEXT
		String titleName = "Freya's Venture";
		int x = getXForCentereredText(titleName);
		int y = gp.screenHeight/5;
		//SHADOW 
		g2.setColor(Color.gray);
		g2.drawString(titleName, x+5, y+5);	
	    //SET and DRAW 
		g2.setColor(Color.white);
		g2.drawString(titleName, x, y);
		
		
		//Freya's Image
		x = gp.screenWidth / 2 - (gp.tileSize*2) /2;
		y += gp.screenHeight / 10 ;
		g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);
		
		// MENU 
		g2.setFont(maruMonica);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 45F));
		String menuText = "NEW GAME";
		x = getXForCentereredText(menuText);
		y += gp.tileSize*4;
		g2.drawString(menuText, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x-gp.tileSize, y);
		}
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 45F));
		menuText = "QUIT GAME";
		x = getXForCentereredText(menuText);
		y += gp.tileSize*2;
		g2.drawString(menuText, x, y);
		if(commandNum == 1) {
			g2.drawString(">", x-gp.tileSize, y);
		}
		
		
		
	}
	public void drawPotion() {
		float x = (float) (gp.tileSize * 14.8) ;
		int y = gp.tileSize / 2;
		
		g2.setFont(maruMonica);
		g2.setColor(Color.white);
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 38F));
		g2.drawString(gp.player.hasPotion + " = ", (int) (gp.tileSize * 13.8), (int)(y*2.3));
		g2.drawImage(potionImage, (int) x, y, 36,36, null);

//		g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
//		
//		g2.drawString("= "+ gp.player.hasKey, gp.tileSize+24, gp.tileSize+17);
//		
	}
	
	public void drawPlayerLife() {
		
		int x = gp.tileSize/2;
		int y = gp.tileSize/2;
		int i = 0;
		
		//DRAW MAX LIFE
		while(i < gp.player.maxLife/2) {
			g2.drawImage(heart_Blank, x, y, null);
			i++;
			x += gp.tileSize;
		}
		
		
		// RESET VALUES
		x = gp.tileSize/2;
		y = gp.tileSize/2;
		i = 0;
		
		// DRAW CURRENT LIFE
		while(i < gp.player.life) {
			g2.drawImage(heart_Haft, x, y, null);
			i++;
			
			if(i < gp.player.life) {
				g2.drawImage(heart_Full, x, y, null);
			}
				i++;
				x += gp.tileSize;
			}
			
	}
	
	public void drawPauseScreen() {
		g2.setColor(Color.white);
		g2.setFont(maruMonica);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,90f));
		String text = "PAUSED";
		int x = getXForCentereredText(text);
		int y = 300;
		g2.drawString(text, x, y);
		
		 
	}
	
	public void drawDialogueScreen() {
		
		// WINDOW
		int x = gp.tileSize * 2;
		int y = gp.tileSize / 2;
		int width = gp.screenWidth - (gp.tileSize *4);
		int height = gp.tileSize * 5;
		
		drawSubWindow(x, y, width, height);
		
		x += gp.tileSize;
		y += gp.tileSize;
		
		g2.setFont(purisaB);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 17F));

		
		//SPLITS THE DIALOGUE 
		for(String line : currentDialogue.split("\n")){
			g2.drawString(line, x, y);
			y += 40;
		}
	}
	
	public void drawSubWindow(int x, int y, int width, int height) {
		Color color = new Color(0,0,0,210); //RGB and ALPHA LEVEL
		g2.setColor(color);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		color = new Color(255,255,255);
		g2.setColor(color);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
		
	}
	
	public void drawGameOver() {
		g2.setColor(new Color(0,0,0,150));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		int x;
		int y;
		String text;
		g2.setFont(maruMonica); // FONT
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));
		text = "Game Over";
		g2.setColor(Color.black); // SHADOW
		x = getXForCentereredText(text);
		y = gp.tileSize*4;
		g2.drawString(text, x, y);
		
		g2.setColor(Color.white); 
		g2.drawString(text,x-4,y-4); 
		
		// Retry
		g2.setFont(g2.getFont().deriveFont(50f));
		text = "Retry";
		x = getXForCentereredText(text);
		y += gp.tileSize*4;
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x-40, y);
		}
		
		// Back to the Title Screen
		text = "Quit";
		x = getXForCentereredText(text);
		y += 65;
		g2.drawString(text, x, y);
		if(commandNum ==1) {
			g2.drawString(">", x-40, y);
		}
	}
	
	public void drawEndScreen() {
		g2.setColor(new Color(0,0,0,150));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		int x;
		int y;
		String text;
		g2.setFont(maruMonica); // FONT
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));
		text = "Game Finished";
		g2.setColor(Color.black); // SHADOW
		x = getXForCentereredText(text);
		y = gp.tileSize*4;
		g2.drawString(text, x, y);
		
		g2.setColor(new Color(232,213,0)); 
		g2.drawString(text,x-4,y-4); 
		
		// Retry
		g2.setFont(g2.getFont().deriveFont(50f));
		text = "Menu";
		x = getXForCentereredText(text);
		y += gp.tileSize*4;
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x-40, y);
		}
		
		// Back to the Title Screen
		text = "Quit";
		x = getXForCentereredText(text);
		y += 65;
		g2.drawString(text, x, y);
		if(commandNum ==1) {
			g2.drawString(">", x-40, y);
		}
	}
	
	public int getXForCentereredText(String text) { 
		 /*CENTERING X AXIS TEXT USING METRICS AND BOUNDS*/
		int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		
		return x;
	}
	
	
	
}
