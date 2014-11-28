package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Water extends BFObject{

	public Water(int x, int y) {		
		// TODO Auto-generated constructor stub
		super(x, y);
		color = new Color(0, 150, 255);
		
		try{
			image = ImageIO.read(new File("water.png").getAbsoluteFile());
		}catch(IOException e){			
		}
	}	

}
