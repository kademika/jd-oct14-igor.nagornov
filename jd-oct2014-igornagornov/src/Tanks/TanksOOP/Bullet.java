package Tanks.TanksOOP;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet implements Destroyable, Drawable{

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

	@Override
	public void destroy() {
		// TODO Auto-generated method stub		
			x = -100;
			y = -100;
			direction = Direction.NONE;
		
	}
	

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(255, 255, 0));
		g.fillRect(this.getX(), this.getY(), 14, 14);
	}

	

}
