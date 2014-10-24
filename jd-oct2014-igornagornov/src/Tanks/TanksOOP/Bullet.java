package Tanks.TanksOOP;

public class Bullet {

	private int x;
	private int y;
	private int speed = 5;
	private Direction direction;

	Bullet(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeed() {
		return speed;
	}

	public Direction getDirection() {
		return this.direction;
	}

	public void updateX(int x) {
		this.x += x;
	}

	public void updateY(int y) {
		this.y += y;
	}

	public void destroy() {
		x = -100;
		y = -100;
		direction = Direction.NONE;
	}

}
