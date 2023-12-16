package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import environment.EnvironmentManager;
import object.AssetSetter;
import tileterrain.TileManager;

public class GamePanel extends JPanel implements Runnable{

	// SCREEN SETTINGS
	final int orignialTileSize = 16; //16x16 Tile
	final int scale = 3; //scaling
	
	public final int tileSize = orignialTileSize * scale; // 48x48 Tile Size
	public final int maxScreenCol = 16; // Width
	public final int maxScreenRow = 12; // Height
	public final int screenWidth = tileSize * maxScreenCol; // 768px Width //ScreenRes
	public final int screenHeight = tileSize * maxScreenRow; // 576px Height //ScreenRes
	
	//WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	
	//FPS
	int FPS = 60;
	
	//SYSTEM
	TileManager tileManage = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this); // sets object for KeyHandler Class
	Sound sfx = new Sound();
	Sound music = new Sound();
	public CollisionChecker collisionCheck = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	EnvironmentManager eManager = new EnvironmentManager(this);
	Thread gameThread; //GameClock
	
	//MAPS
	public int currentMap = 0;
	public final int maxMap = 5;
	
	// ENTITY and OBJECT
	public Player player = new Player(this,keyH);
	public Entity obj[][] = new Entity[maxMap][41]; //LIMITS FOR OBJECT
	public Entity npc[][] = new Entity[maxMap][5]; //LIMITS FOR NPC
	public Entity monster[][] = new Entity[maxMap][57]; //LIMITS FOR MONSTERS
	public ArrayList<Entity> entityList = new ArrayList<>();
	
	// GAME STATE
	public int gameState; 
	public int titleState = 0;
	public final int playState = 1;   //unpause state
	public final int pauseState = 2 ; 	//paused state
	public final int dialogueState = 3; //dialogue State
	public final int gameOver = 4;
	public final int gameEnd = 5;
	
	
	
	
//	//Player's Default Position
//	int playerX = 100;
//	int playerY = 100;
//	int playerSpeed = 4;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //ScreenDimension
		this.setBackground(Color.black); // BGColor
		this.setDoubleBuffered(true); //Framing
		this.addKeyListener(keyH); //KeyHandler
		this.setFocusable(true);
		
	}
	
	
	public void setupGame() {	
		gameState = titleState;
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonster();
		eManager.setup();
		playMusic(7);
	}
	
	public void retry() {
		player.retryWorld(currentMap);
		player.setDefaultValues();
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMonster();
		player.invincible = false;
	}

	
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		System.out.println("Game is Running");
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1 ) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			
			//FPS COUNTER
//			if(timer >= 1000000000) { 
//				System.out.println("FPS: " + drawCount);
//				drawCount = 0;	
//				timer = 0;
//			}	
		}
	}

	
	public void update() {
		
		
		if (gameState == playState) {
			
			//PLAYER UPDATE
			player.update();
			
			for(int i = 0; i < npc[1].length; i++) {
				if(npc[currentMap][i] != null) {
					npc[currentMap][i].update();
				}
			}
			
			for(int i = 0; i < monster[1].length; i++) {
				if(monster[currentMap][i] != null) {
					if(monster[currentMap][i].alive == true && monster[currentMap][i].dying == false) {
						monster[currentMap][i].update();
					}
					if(monster[currentMap][i].alive == false) {
						monster[currentMap][i] = null;
					}
					
				}
			}
			
		}
		if (gameState == pauseState) {
			ui.drawPauseScreen();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		Graphics2D g2 = (Graphics2D)g;
		
		
		//TITLE SCREEN / TITLESTATE 
		if(gameState == titleState) {
		ui.draw(g2);
		}
		
		
		else {
		//TILE DRAW
		tileManage.draw(g2);
		
		
		//ADD ENTITIES TO THE LIST
		for(int i = 0; i < npc[1].length; i++) {
			if(npc[currentMap][i] != null){
				entityList.add(npc[currentMap][i]);
			}
		}
		
		for (int i = 0; i <obj[1].length; i++ ) {
			if(obj[currentMap][i] != null) {
				entityList.add(obj[currentMap][i]);
			}
		}
		
		for (int i = 0; i <monster[1].length; i++ ) {
			if(monster[currentMap][i] != null) {
				entityList.add(monster[currentMap][i]);
			}
		}
		
		entityList.add(player);
		
		
		// SORT
		
		Collections.sort(entityList, new Comparator<Entity>() {

			@Override
			public int compare(Entity e1, Entity e2) {
				
				int result = Integer.compare(e1.worldY, e2.worldY);
				
				return result;
			}
			
		});
		
		// DRAW ENTITIES
		for(int i = 0; i < entityList.size(); i++) {
			entityList.get(i).draw(g2);
		}
		
		// EMPTY ENTITIES
		entityList.clear();
		
		//ENVIRONMENT
		if(player.lightingOn == true) {
			eManager.draw(g2);
		}
		
		//UI DRAW
		ui.draw(g2);
		
		
		g2.dispose();
	}
		
		
	}
	

	
	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	
	public void stopMusic() {
		music.stop();
	}
	
	public void playerSfx(int i) {
		
		sfx.setFile(i);
		sfx.play();	
		
	}


	public String entityList(String name) {
		// TODO Auto-generated method stub
		return null;
	}



	
	
	
	
}
