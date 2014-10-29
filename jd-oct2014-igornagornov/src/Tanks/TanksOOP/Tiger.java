package Tanks.TanksOOP;

public class Tiger extends Tank {

	public Tiger(ActionField actionfield, BattleField battlefield, int x,
			int y, Direction direction) {
		super(actionfield, battlefield, x, y, direction);
		setArmor(1);
	}

	public Tiger(ActionField actionfield, BattleField battlefield) {
		this(actionfield, battlefield, 0, 0, Direction.RIGHT);
		setArmor(1);
	}

	private int armor;

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

}
