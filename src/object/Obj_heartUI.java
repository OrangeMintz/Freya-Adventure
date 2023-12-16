package object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Obj_heartUI extends Entity{
	
	
	public Obj_heartUI(GamePanel gp) {
		super(gp);
		
		name = "HeartUI";
		
		image = setup("/objects/heart_blank", 36, 36);
		image2 = setup("/objects/heart_half", 36, 36);
		image3 = setup("/objects/heart_full", 36, 36);
		
	}

	
}
