package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Obj_key_blue extends Entity{
	
	public Obj_key_blue(GamePanel gp) {
		super(gp);	
		
		name = "Key_Blue";
		down1 = setup("/objects/key_blue", gp.tileSize, gp.tileSize);
	
	}

}
