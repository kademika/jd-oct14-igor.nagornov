package Tanks.TanksOOP.Tanks;

import java.awt.Color;
import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.Service.Direction;

public class BT7 extends Tank {

	public BT7(BattleField battlefield, int x, int y,
			Direction direction) {
		super(battlefield, x, y, direction);
		speed = 10;
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
	}

	public BT7(BattleField battlefield) {
		this(battlefield, 512, 0, Direction.DOWN);
		speed = 10;
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
	}

	@Override
	public Action setUp() {
		// TODO Auto-generated method stub
		return Action.CLEAN;
	}
	

}
