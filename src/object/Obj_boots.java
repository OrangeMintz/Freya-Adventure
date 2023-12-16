package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Obj_boots extends Entity{
	
	public Obj_boots(GamePanel gp) {
		super(gp);
		name = "Boots";
		down1 = setup("/objects/boots", gp.tileSize, gp.tileSize);
	}

}
