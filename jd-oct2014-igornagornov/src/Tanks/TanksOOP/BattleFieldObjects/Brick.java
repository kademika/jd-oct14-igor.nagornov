package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;

import Tanks.TanksOOP.Service.LoadImages;

public class Brick extends BFObject {

	public Brick(int x, int y) {
		super(x, y);
		color = new Color(255, 100, 100);

		image = LoadImages.getBricks();

		imageDestroyed = LoadImages.getExploitedEarth();

	}

}
