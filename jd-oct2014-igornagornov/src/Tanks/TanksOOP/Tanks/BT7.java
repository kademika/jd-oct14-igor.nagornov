
package Tanks.TanksOOP.Tanks;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.Service.Direction;
import Tanks.TanksOOP.Service.LoadImages;

public class BT7 extends Tank {

	public BT7(BattleField battlefield, int x, int y,
			Direction direction) {
		super(battlefield, x, y, direction);
		speed = 15;
		tankColor = new Color(255, 255, 0);
		towerColor = new Color(255, 0, 0);
		setImages();
		imageDestroyed = LoadImages.getExploitedEarth();
		
	}

	public BT7(BattleField battlefield) {
		this(battlefield, 64, 0, Direction.DOWN);		
	}

	@Override
	public Action setUp() {
		// TODO Auto-generated method stub
		return Action.CLEAN;
	}

	@Override
	public void setImages() {
		// TODO Auto-generated method stub
		images = new Image[4];
		try {
			images[0] = ImageIO.read(new File("bt7up.png"));
			images[1] = ImageIO.read(new File("bt7down.png"));
			images[2] = ImageIO.read(new File("bt7left.png"));
			images[3] = ImageIO.read(new File("bt7right.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	
	

}
