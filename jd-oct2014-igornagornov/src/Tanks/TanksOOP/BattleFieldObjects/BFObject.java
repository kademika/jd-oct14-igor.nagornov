package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;
import java.awt.Graphics;

import Tanks.TanksOOP.Service.Destroyable;
import Tanks.TanksOOP.Service.Drawable;

public abstract class BFObject implements Drawable, Destroyable {

	// current position on BF
	private int x;
	private int y;

	protected Color color;

	private boolean isDestroyed = false;

	public BFObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

	@Override
	public void destroy() {
		isDestroyed = true;
	}

	@Override
	public void draw(Graphics g) {
		if (!isDestroyed) {
			g.setColor(this.color);
			g.fillRect(this.getX(), this.getY(), 64, 64);
		}
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return isDestroyed;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
