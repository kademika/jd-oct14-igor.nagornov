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
	}

	public Tank(ActionField actionfield, BattleField battlefield) {
		this(actionfield, battlefield, 128, 512, Direction.UP);
	}

	public Direction getDirection() {
		return this.direction;
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
		Bullet bullet = new Bullet(x + 25, y + 25, this.direction);
		actionfield.processFire(this, bullet);
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

	public void destroy() {
		x = -100;
		y = -100;
		direction = Direction.NONE;
		actionfield.repaint();
	}
}
