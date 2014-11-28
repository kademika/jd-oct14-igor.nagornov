package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Earth extends BFObject{

	public Earth(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		color = new Color(180, 180, 180);
		
		try{
			image = ImageIO.read(new File("earth.png").getAbsoluteFile());
		}catch(IOException e){			
		}
	}
	
	
}
