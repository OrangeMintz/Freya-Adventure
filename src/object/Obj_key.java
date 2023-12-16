package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Obj_key extends Entity{
	
	public Obj_key(GamePanel gp) {
		super(gp);	
		
		name = "Key";
		down1 = setup("/objects/key", gp.tileSize, gp.tileSize);
	
	}

}
