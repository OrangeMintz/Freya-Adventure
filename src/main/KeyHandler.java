package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, ePressed, fPressed, enterPressed;
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode(); //Returns the integer KeyCode associated with the key in this event
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
		
			if (code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				gp.playerSfx(9);
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum++;
				}
			}
			if (code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				gp.playerSfx(9);
				if(gp.ui.commandNum > 1) {
					gp.ui.commandNum--;
				}
			}
			
			if (code == KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum == 0) {
					gp.stopMusic();
					gp.gameState = gp.playState;
					gp.playMusic(8);
				}
				
				if(gp.ui.commandNum == 1) {
					System.exit(0);
				}
			}
			
		}
		// PLAYSTATE
		else if (gp.gameState == gp.playState) {
			if (code == KeyEvent.VK_W) {
				upPressed = true;
			}
			if (code == KeyEvent.VK_A) {
				leftPressed = true;	
			}
			if (code == KeyEvent.VK_S) {
				downPressed = true;
			}
			
			if (code == KeyEvent.VK_D) {
				rightPressed = true;
			}
			
			if (code == KeyEvent.VK_E) {
				ePressed = true;
			}
			if (code == KeyEvent.VK_F) {
				fPressed = true;
				if(gp.player.hasPotion <= 0) {
					gp.ui.showMessage("No Potion");
				}
				else {
					if(gp.player.life < gp.player.maxLife) {
						gp.player.hasPotion--;
						gp.player.life++;
						gp.playerSfx(3); //sfx
						System.out.println("HP RECOVERED" );
						gp.ui.showMessage("+1HP");
					}
					
					
					if(gp.player.life == gp.player.maxLife) {
						gp.ui.showMessage("Health is Full");
					}
				}
			}
		}
			
		if (code == KeyEvent.VK_P) {
			gp.playerSfx(9);
			if(gp.gameState == gp.playState) {
				gp.gameState = gp.pauseState;
				gp.stopMusic();
							
			}
			
			else if (gp.gameState == gp.pauseState) {
				gp.gameState = gp.playState;
				gp.music.loop();
			}
		}
		
		if(gp.gameState == gp.dialogueState) {
			if (code == KeyEvent.VK_ENTER) {
				gp.gameState = gp.playState;
			}
			
		}
		
		//GAME OVER STATE
		if(gp.gameState == gp.gameOver) {
				
			if (code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				gp.playerSfx(9);
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum++;
					
				}
			}
			if (code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				gp.playerSfx(9);
				if(gp.ui.commandNum > 1) {
					gp.ui.commandNum--;
					
				}
			}
			
			if (code == KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum == 0) {
					gp.stopMusic();
					gp.playMusic(8);
					
					gp.retry();
					gp.gameState = gp.playState;
					
				}
				
				if(gp.ui.commandNum == 1) {
					System.exit(0);
				}
			}
			
		}
		
		
		//GAME FINISHED STATE
				if(gp.gameState == gp.gameEnd) {
						
					if (code == KeyEvent.VK_W) {
						gp.ui.commandNum--;
						gp.playerSfx(9);
						if(gp.ui.commandNum < 0) {
							gp.ui.commandNum++;
							
						}
					}
					if (code == KeyEvent.VK_S) {
						gp.ui.commandNum++;
						gp.playerSfx(9);
						if(gp.ui.commandNum > 1) {
							gp.ui.commandNum--;
							
						}
					}
					
					if (code == KeyEvent.VK_ENTER) {
						if(gp.ui.commandNum == 0) {
							gp.stopMusic();
							gp.playMusic(7);
							gp.retry();
							gp.gameState = gp.titleState;
							
						}
						
						if(gp.ui.commandNum == 1) {
							System.exit(0);
						}
					}
					
				}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;	
				}
		if (code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		
	
		

		
	}

}
