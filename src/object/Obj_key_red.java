package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Obj_key_red extends Entity{
	
	public Obj_key_red(GamePanel gp) {
		super(gp);	
		
		name = "Key_Red";
		down1 = setup("/objects/key_red", gp.tileSize, gp.tileSize);
	
	}

}
