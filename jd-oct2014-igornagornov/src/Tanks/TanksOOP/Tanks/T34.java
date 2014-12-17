package Tanks.TanksOOP.Tanks;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.Service.Direction;
import Tanks.TanksOOP.Service.LoadImages;

public class T34 extends Tank {

	public T34(BattleField battlefield, int x, int y, Direction direction) {
		// TODO Auto-generated constructor stub
		super(battlefield, x, y, direction);
		tankColor = new Color(0, 255, 0);
		towerColor = new Color(255, 0, 0);
		setImages();
		imageDestroyed = LoadImages.getExploitedEarth();
	}

	public T34(BattleField battlefield) {
		// TODO Auto-generated constructor stub
		super(battlefield);
	}

	@Override
	public Action setUp() throws Exception {
		// TODO Auto-generated method stub

		return Action.CLEAN;
	}

	@Override
	public void setImages() {
		// TODO Auto-generated method stub
		images = new Image[4];
		try {
			images[0] = ImageIO.read(new File("t34up.png"));
			images[1] = ImageIO.read(new File("t34down.png"));
			images[2] = ImageIO.read(new File("t34left.png"));
			images[3] = ImageIO.read(new File("t34right.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String generateNextPosition() throws Exception {

		Random r = new Random();
		String nextPosition = "8_3";

		int v = r.nextInt(9);
		int h = r.nextInt(9);

		while (v < 6) {
			v = r.nextInt(9);
		}

		while (h < 2 || h > 6) {
			h = r.nextInt(9);
		}

		if (v == 8 && h == 4) {
			nextPosition = "8_3";
		} else {
			nextPosition = v + "_" + h;
		}

		return nextPosition;

	}
	
	public String generatePositionNearEagle(int h) throws Exception {

		String nextPosition = "8_3";		
		
		if(h > 4){
			nextPosition = "8_5";
		}else if (h == 4){
			nextPosition = "7_4";
		}		

		return nextPosition;

	}

}
