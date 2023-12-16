package environment;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Lighting {
	
	GamePanel gp;
	BufferedImage darknessFilter;
	
	public Lighting(GamePanel gp, int circleSize) {
		
		//Create a BufferedImage
		darknessFilter = new BufferedImage(gp.screenWidth, gp.screenHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)darknessFilter.getGraphics();
		
		//Create a screen size rectangle area
		Area screenArea = new Area(new Rectangle2D.Double(0,0,gp.screenWidth, gp.screenHeight));
		
		//Get the center x and y of the light circle
		int centerX = gp.player.screenX + (gp.tileSize)/2;
		int centerY = gp.player.screenY + (gp.tileSize)/2;
		
		//Get the top LeftX and y of the light circle
		double x = centerX - (circleSize/2);
		double y = centerY - (circleSize/2);
		
		//Create a light circle shape
		Shape circleShape = new Ellipse2D.Double(x,y,circleSize, circleSize);
		
		//Create a light circle area
		Area lightArea = new Area(circleShape);
		
		//Subtruct the light circle from the screen rectangle
		screenArea.subtract(lightArea);
		
		
		Color color[] = new Color[5];
		float fraction[] = new float[5];
		
		color[0] = new Color(0,0,0,0f);
		color[1] = new Color(0,0,0,0.25f);
		color[2] = new Color(0,0,0,0.5f);
		color[3] = new Color(0,0,0,0.75f);
		color[4] = new Color(0,0,0,0.98f);
		
		fraction[0] = 0f;
		fraction[1] = 0.25f;
		fraction[2] = 0.5f;
		fraction[3] = 0.75f;
		fraction[4] = 1f;
		
		//Create a gradation paint settings for the light circle
		RadialGradientPaint gPaint = new RadialGradientPaint(centerX, centerY, (circleSize/2), fraction , color);
		
		//Set the gradient data on g2
		g2.setPaint(gPaint);
		
		//Draw the light circle
		g2.fill(lightArea);
		
		//Draw the screen rectangle without the light circle area
		g2.fill(screenArea);
		g2.dispose();
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(darknessFilter, 0, 0, null);
	}

}
