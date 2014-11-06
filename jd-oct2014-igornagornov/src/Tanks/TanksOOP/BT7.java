package Tanks.TanksOOP;

import java.awt.Color;
import java.awt.Graphics;

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
