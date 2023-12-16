package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Obj_chest extends Entity{
	
	public Obj_chest(GamePanel gp) {
	super(gp);	
	
		name = "Chest";
		down1 = setup("/objects/chest", gp.tileSize, gp.tileSize);
		collision = true;
		
	}

}
