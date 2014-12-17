package Tanks.TanksOOP.Tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.Service.Direction;
import Tanks.TanksOOP.Service.LoadImages;
import Tanks.TanksOOP.Tanks.Action;

public class Tiger extends Tank {

	private int armor;
	private int lives;
	private boolean isRised = false;

	public Tiger(BattleField battlefield, int x, int y, Direction direction) {
		super(battlefield, x, y, direction);
		setArmor(1);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		lives = 1;
		setImages();
		imageDestroyed = LoadImages.getExploitedEarth();

	}

	public Tiger(BattleField battlefield) {
		this(battlefield, 64, 0, Direction.DOWN);
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public boolean isRised() {
		return isRised;
	}

	public void setRised(boolean isRised) {
		this.isRised = isRised;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		if (this.getArmor() > 0) {
			setArmor(0);
		} else {
			if (lives > 0) {
				isRised = true;
				lives--;

			} else {
				super.destroy();
			}
		}
	}

	@Override
	public Action setUp() {
		// TODO Auto-generated method stub
		return Action.CLEAN;
	}

	@Override
	public void setImages() {
		// TODO Auto-generated method stub
		images = new Image[4];
		try {
			images[0] = ImageIO.read(new File("tigerup.png"));
			images[1] = ImageIO.read(new File("tigerdown.png"));
			images[2] = ImageIO.read(new File("tigerleft.png"));
			images[3] = ImageIO.read(new File("tigerright.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (!this.isDestroyed() && !isRised) {
			super.draw(g);
		}
	}	


}
