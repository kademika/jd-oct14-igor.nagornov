package Tanks.TanksOOP.Tanks;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tanks.TanksOOP.BattleFieldObjects.BFObject;
import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.BattleFieldObjects.Eagle;
import Tanks.TanksOOP.BattleFieldObjects.Rock;
import Tanks.TanksOOP.Service.ActionField;
import Tanks.TanksOOP.Service.Direction;
import Tanks.TanksOOP.Service.LoadImages;

public class BT7 extends Tank {

	public BT7(BattleField battlefield, int x, int y, Direction direction) {
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

	public boolean findEagle(int cX, int cY) {

		String coordinates;
		coordinates = ActionField.getQuadrant(cX, cY);

		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));

		if ((y >= 0 && y < battlefield.getDimensionY())
				&& (x >= 0 && x < battlefield.getDimensionX())) {

			BFObject bfObject = battlefield.scanQuadrant(y, x);
			
			if (!bfObject.isDestroyed() && bfObject instanceof Eagle) {
				return true;
			}
		}

		return false;
	}
	
	@Override
	public int findObjectAtTop(Tank tank) {
		int distanceUp = 512;

		int y = this.getY();
		while (y > 0) {
			y -= 64;

			if (this.findEagle(this.getX(), y)) {
				distanceUp = this.getY() - y - 64;
				break;
			}
		}
		return distanceUp;
	}

	@Override
	public int findObjectAtBottom(Tank tank) {
		// TODO Auto-generated method stub

		int distanceDown = 512;

		int y = this.getY();
		while (y < 512) {
			y += 64;

			if (findEagle(this.getX(), y)) {
				distanceDown = y - this.getY() - 64;
				break;
			}
		}
		return distanceDown;
	}

	@Override
	public int findObjectAtLeft(Tank tank) {
		// TODO Auto-generated method stub
		int distanceLeft = 512;

		int x = this.getX();
		while (x > 0) {
			x -= 64;
			if (findEagle(x, this.getY())) {
				distanceLeft = this.getX() - x - 64;
				break;
			}
		}
		return distanceLeft;
	}

	@Override
	public int findObjectAtRight(Tank tank) {
		// TODO Auto-generated method stub
		int distanceRight = 512;

		int x = this.getX();
		while (x < 512) {
			x += 64;
			if (findEagle(x, this.getY())) {
				distanceRight = x - this.getX() - 64;
				break;
			}

			// else {if (!quadrantIsEmpty(x, tank.getY())) {
			// distanceRight = x - tank.getX() - 64;
			// break;
			// }

		}
		return distanceRight;
	}
}
