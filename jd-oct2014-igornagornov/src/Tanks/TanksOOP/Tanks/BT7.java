package Tanks.TanksOOP.Tanks;

import java.awt.Color;
import java.awt.Graphics;

import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.Service.ActionField;
import Tanks.TanksOOP.Service.Direction;

public class BT7 extends Tank {

	public BT7(ActionField actionfield, BattleField battlefield, int x, int y,
			Direction direction) {
		super(actionfield, battlefield, x, y, direction);
		speed = 10;
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
	}

	public BT7(ActionField actionfield, BattleField battlefield) {
		this(actionfield, battlefield, 512, 0, Direction.DOWN);
		speed = 10;
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
	}
	

}
