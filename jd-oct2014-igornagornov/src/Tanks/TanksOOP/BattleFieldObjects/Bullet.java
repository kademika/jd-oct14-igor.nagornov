package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tanks.TanksOOP.Service.Destroyable;
import Tanks.TanksOOP.Service.Direction;
import Tanks.TanksOOP.Service.Drawable;

public class Bullet implements Destroyable, Drawable{

	private int x;
	private int y;
	private int speed = 5;
	private Direction direction;
	private boolean isDestroyed=false;
	private Image image;

	public Bullet(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;

		try {
			image = ImageIO.read(new File("bullet.png"));
		} catch (IOException e) {
		}
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
			isDestroyed = true;
		
	}	

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if(!isDestroyed){
			if(image!=null){
				g.drawImage(image, this.getX(), this.getY(),
						new ImageObserver() {
							@Override
							public boolean imageUpdate(Image arg0, int arg1,
									int arg2, int arg3, int arg4, int arg5) {
								// TODO Auto-generated method stub
								return false;
							}
						});
			}else{
				g.setColor(new Color(255, 255, 0));
				g.fillRect(this.getX(), this.getY(), 14, 14);
			}
			
		}		
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return isDestroyed;
	}

	

}
