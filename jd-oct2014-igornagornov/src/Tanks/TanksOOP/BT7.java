package Tanks.TanksOOP;

public class BT7 extends Tank {

	public BT7(ActionField actionfield, BattleField battlefield, int x, int y,
			Direction direction) {
		super(actionfield, battlefield, x, y, direction);
		speed = 10;

	}

	public BT7(ActionField actionfield, BattleField battlefield) {
		this(actionfield, battlefield, 512, 0, Direction.DOWN);
		speed = 10;
	}

}
