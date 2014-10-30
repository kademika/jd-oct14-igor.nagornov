package Tanks.TanksOOP;

import java.util.Random;

public class Tank {

	// 1 - top, 2 - bottom, 3 - left, 4 - right

	private int x;
	private int y;
	protected int speed = 20;
	private Direction direction;
	private ActionField actionfield;
	private BattleField battlefield;

	public Tank(ActionField actionfield, BattleField battlefield, int x, int y,
			Direction direction) {
		this.actionfield = actionfield;
		this.battlefield = battlefield;
		this.x = x;
		this.y = y;
		this.direction = direction;
		// this.setTankOnBattlefield();
	}

	public Tank(ActionField actionfield, BattleField battlefield) {
		this(actionfield, battlefield, 128, 512, Direction.UP);
	}

	public Direction getDirection() {
		return this.direction;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setDirection(Direction direction) {
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

	public ActionField getActionfield() {
		return actionfield;
	}

	public BattleField getBattlefield() {
		return battlefield;
	}

	public void updateX(int x) {
		this.x += x;
	}

	public void updateY(int y) {
		this.y += y;
	}

	public void turn(Direction direction) throws Exception {

		if (this.direction != direction) {
			this.direction = direction;
			actionfield.processTurn(this);
		}
	}

	public void move() throws Exception {
		actionfield.processMove(this);
	}

	public void moveRandom() throws Exception {
		actionfield.processMoveRandom(this);
	}

	public void moveToQuadrant(int v, int h) throws Exception {
		actionfield.processMoveToQuadrant(this, v, h);
	}

	public void moveToRandomQuadrant() throws Exception {
		actionfield.processMoveToRandomQuadrant(this);
	}

	public void fire() throws Exception {
		Bullet bullet = new Bullet(x + 25, y + 25, direction);

		if ((this.getDirection() == Direction.UP && this.getY() != 0)
				|| (this.getDirection() == Direction.DOWN && this.getY() < 512)
				|| (this.getDirection() == Direction.LEFT && this.getX() != 0)
				|| (this.getDirection() == Direction.RIGHT && this.getX() < 512)) {
			if (this.getDirection() == Direction.UP) {
				bullet = new Bullet(this.getX() + 25, this.getY(),
						direction);
			} else if (this.getDirection() == Direction.DOWN) {
				bullet = new Bullet(this.getX() + 25, this.getY() + 64,
						direction);
			} else if (this.getDirection() == Direction.LEFT) {
				bullet = new Bullet(this.getX(), this.getY() + 25,
						direction);
			} else {
				bullet = new Bullet(this.getX() +64, this.getY() +25,
						direction);
			}
		}

		actionfield.processFire(bullet);
	}

	public void clean() throws Exception {
		actionfield.processClean(this);
	}

	public int findBrickAtTop() {
		return actionfield.processFindBrickAtTop(this);
	}

	public int findBrickAtBottom() {
		return actionfield.processFindBrickAtBottom(this);
	}

	public int findBrickAtLeft() {
		return actionfield.processFindBrickAtLeft(this);
	}

	public int findBrickAtRight() {
		return actionfield.processFindBrickAtRight(this);
	}

	public boolean isCollision() throws Exception {
		return actionfield.processCollision(this);
	}

	public void destroy() throws InterruptedException {
		x = -100;
		y = -100;		
	}

	// public void setTankOnBattlefield(){
	//
	// String coordinates = ActionField.getQuadrant(this.getX(), this.getY());
	// int separator = coordinates.indexOf("_");
	// int y = Integer.parseInt(coordinates.substring(0, separator));
	// int x = Integer.parseInt(coordinates.substring(separator + 1));
	//
	// battlefield.updateQuadrant(y, x, "T");
	//
	// }
}
