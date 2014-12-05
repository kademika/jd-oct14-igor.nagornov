package Tanks.TanksOOP.Service;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadImages {
	
	private Image bricks;	
	private Image earth;
	private Image exploitedEarth;
	private Image rocks;
	private Image water;
	private Image eagle;
	private Image bullet;
	
	public LoadImages() {
		// TODO Auto-generated constructor stub
		try {
			exploitedEarth = ImageIO.read(new File("exploitedearth.png")
					.getAbsoluteFile());
		} catch (IOException e) {
		}
		
		try{
			bricks = ImageIO.read(new File("bricks.jpg").getAbsoluteFile());
		}catch(IOException e){			
		}
		
		try{
			earth = ImageIO.read(new File("earth.png").getAbsoluteFile());
		}catch(IOException e){			
		}
		
		try{
			rocks = ImageIO.read(new File("rocks.png").getAbsoluteFile());
		}catch(IOException e){			
		}
		
		try{
			water = ImageIO.read(new File("water.png").getAbsoluteFile());
		}catch(IOException e){			
		}
		
		try {
			eagle = ImageIO.read(new File("eagle.png"));
		} catch (IOException e) {
		}
		
		try {
			bullet = ImageIO.read(new File("bullet.png"));
		} catch (IOException e) {
		}
		
	}	
	

	public Image getExploitedEarth() {		
		return exploitedEarth;			
	}
	
	public Image getBricks() {
		return bricks;
	}
	
	public Image getEarth() {
		return earth;
	}
	
	public Image getRocks() {
		return rocks;
	}
	
	public Image getWater() {
		return water;
	}
	
	public Image getEagle() {
		return eagle;
	}
	
	public Image getBullet() {
		return bullet;
	}

}
