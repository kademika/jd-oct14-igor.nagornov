package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rock extends BFObject{

	
	public Rock(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		color = new Color(100, 100, 100);
		
		try{
			image = ImageIO.read(new File("rocks.png").getAbsoluteFile());
		}catch(IOException e){			
		}
	}	
	
}
