package Tanks.TanksOOP.Tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.BattleFieldObjects.Bullet;
import Tanks.TanksOOP.Service.ActionField;
import Tanks.TanksOOP.Service.Destroyable;
import Tanks.TanksOOP.Service.Direction;
import Tanks.TanksOOP.Service.Drawable;

public abstract class Tank implements Destroyable, Drawable, InterfaceTank {

	// 1 - top, 2 - bottom, 3 - left, 4 - right

	private int x;
	private int y;
	protected int speed = 16;
	private Direction direction;
	protected BattleField battlefield;
	private Bullet bullet;
	private boolean destroyed = false;
	protected Color tankColor;
	protected Color towerColor;
	protected Image[] images;
	protected Image imageDestroyed;
	protected ImageObserver imageObserver = new ImageObserver() {
		@Override
		public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
				int arg4, int arg5) {
			// TODO Auto-generated method stub
			return false;
		}
	};

	public Tank(BattleField battlefield, int x, int y, Direction direction) {
		this.battlefield = battlefield;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Tank(BattleField battlefield) {
		this(battlefield, 128, 512, Direction.UP);
	}

	public Direction getDirection() {
		return direction;
	}
	
	public Bullet getBullet() {
		return bullet;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
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

	public void updateX(int x) {
		this.x += x;
	}

	public void updateY(int y) {
		this.y += y;
	}

	public void turn(Direction direction) throws Exception {

		if (this.direction != direction) {
			this.direction = direction;
		}
	}	
	
	public boolean findEnemy(int cX, int cY, Tank tank) {

		String coordinates = ActionField.getQuadrant(cX, cY);
		String coordinatesDefender = ActionField.getQuadrant(tank.getX(),
				tank.getY());

		if (coordinates.equals(coordinatesDefender)) {
			return true;
		}

		return false;

	}	

	public int findObjectAtTop(Tank tank) {
		int distanceUp = 512;

		int y = this.getY();
		while (y > 0) {
			y -= 64;

			if (this.findEnemy(this.getX(), y, tank)) {
				distanceUp = this.getY() - y - 64;
				break;
			}
		}
		return distanceUp;
	}

	public int findObjectAtBottom(Tank tank) {
		// TODO Auto-generated method stub

		int distanceDown = 512;

		int y = this.getY();
		while (y < 512) {
			y += 64;

			if (this.findEnemy(this.getX(), y, tank)) {
				distanceDown = y - this.getY() - 64;
				break;
			}
		}
		return distanceDown;
	}
	
	public int findObjectAtLeft(Tank tank) {
		// TODO Auto-generated method stub
		int distanceLeft = 512;

		int x = this.getX();
		while (x > 0) {
			x -= 64;

			if (this.findEnemy(x, this.getY(), tank)) {
				distanceLeft = this.getX() - x - 64;
				break;
			}
		}
		return distanceLeft;
	}

	public int findObjectAtRight(Tank tank) {
		// TODO Auto-generated method stub
		int distanceRight = 512;

		int x = this.getX();
		while (x < 512) {
			x += 64;

			if (this.findEnemy(x, this.getY(), tank)) {
				distanceRight = x - this.getX() - 64;
				break;
			}
		}
		return distanceRight;
	}

	public Bullet fire() throws Exception {

		bullet = new Bullet(x + 25, y + 25, direction);

//		if ((this.getDirection() == Direction.UP && this.getY() != 0)
//				|| (this.getDirection() == Direction.DOWN && this.getY() < 512)
//				|| (this.getDirection() == Direction.LEFT && this.getX() != 0)
//				|| (this.getDirection() == Direction.RIGHT && this.getX() < 512)) {
//			if (this.getDirection() == Direction.UP) {
//				bullet = new Bullet(this.getX() + 25, this.getY(), direction);
//			} else if (this.getDirection() == Direction.DOWN) {
//				bullet = new Bullet(this.getX() + 25, this.getY() + 64,
//						direction);
//			} else if (this.getDirection() == Direction.LEFT) {
//				bullet = new Bullet(this.getX(), this.getY() + 25, direction);
//			} else {
//				bullet = new Bullet(this.getX() + 64, this.getY() + 25,
//						direction);
//			}
//		}

		return bullet;

	}

	@Override
	public void destroy() throws InterruptedException, Exception {
		// TODO Auto-generated method stub
		direction = Direction.NONE;
		destroyed = true;

	}

	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (!destroyed) {
			
			if (images!=null && images[0] != null && images[1] != null && images[2] !=null && images[3] !=null ) {
				
				if(this.getDirection().ordinal()!=0){				
					
					g.drawImage(images[this.getDirection().ordinal()-1], this.getX(), this.getY(), imageObserver);								
				}
				
			} else {
				g.setColor(tankColor);
				g.fillRect(this.getX(), this.getY(), 64, 64);

				g.setColor(towerColor);
				if (this.getDirection() == Direction.UP) {
					g.fillRect(this.getX() + 20, this.getY(), 24, 34);
				} else if (this.getDirection() == Direction.DOWN) {
					g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
				} else if (this.getDirection() == Direction.LEFT) {
					g.fillRect(this.getX(), this.getY() + 20, 34, 24);
				} else {
					g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
				}
			}

		}else{
			if (imageDestroyed != null) {
				g.drawImage(imageDestroyed, getX(), getY(), getX() + 64,
						getY() + 64, getX(), getY(), getX() + 64, getY() + 64,
						imageObserver);
			} else {
				 g.setColor(Color.BLACK);
				 g.fillRect(this.getX(), this.getY(), 64, 64);
			}
		}

	}

}
