package main;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
	
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("The Battle of Freya");
		
		GamePanel gamePanel = new GamePanel(); // object for GamePanel Class
		window.add(gamePanel);
		window.pack();
		
		window.setLocationRelativeTo(null); //Location at Middle
		window.setVisible(true); // Window Visible
		gamePanel.setupGame();
		gamePanel.startGameThread();

	}

}
