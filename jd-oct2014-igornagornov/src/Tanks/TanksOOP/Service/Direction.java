package Tanks.TanksOOP.Service;

public enum Direction {
	NONE, UP, DOWN, LEFT, RIGHT;

	public static Direction getDirection(int id) {
		Direction direction = Direction.NONE;

		switch (id) {
		case 0: {
			direction = Direction.NONE;
			break;
		}

		case 1: {
			direction = Direction.UP;
			break;
		}
		case 2: {

			direction = Direction.DOWN;
			break;
		}
		case 3: {

			direction = Direction.LEFT;
			break;
		}
		case 4: {

			direction = Direction.RIGHT;
			break;
		}
		}
		return direction;
	}
}
