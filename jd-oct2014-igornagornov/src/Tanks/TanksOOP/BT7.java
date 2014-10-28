package Tanks.TanksOOP;

public class BT7 extends Tank {

	public BT7(ActionField actionfield, BattleField battlefield, int x, int y,
			Direction direction) {
		super(actionfield, battlefield, x, y, direction);
		speed = 10;

	}

	public BT7(ActionField actionfield, BattleField battlefield) {
		this(actionfield, battlefield, 192, 128, Direction.UP);
		speed = 10;
	}

}
