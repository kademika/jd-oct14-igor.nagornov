package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Brick extends BFObject{
	
	public Brick(int x, int y) {
		super(x, y);
		color = new Color(255, 100, 100);
		
		try{
			image = ImageIO.read(new File("bricks.jpg").getAbsoluteFile());
		}catch(IOException e){			
		}
	}	

}
