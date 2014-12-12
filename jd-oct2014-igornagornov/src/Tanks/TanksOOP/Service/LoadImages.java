package Tanks.TanksOOP.Service;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadImages {

	private static Image bricks;
	private static Image earth;
	private static Image exploitedEarth;
	private static Image rocks;
	private static Image water;
	private static Image eagle;
	private static Image bullet;

	public LoadImages() {
		// TODO Auto-generated constructor stub
		try {
			exploitedEarth = ImageIO.read(new File("exploitedearth.png")
					.getAbsoluteFile());
		} catch (IOException e) {
		}

		try {
			bricks = ImageIO.read(new File("bricks.jpg").getAbsoluteFile());
		} catch (IOException e) {
		}

		try {
			earth = ImageIO.read(new File("earth.png").getAbsoluteFile());
		} catch (IOException e) {
		}

		try {
			rocks = ImageIO.read(new File("rocks.png").getAbsoluteFile());
		} catch (IOException e) {
		}

		try {
			water = ImageIO.read(new File("water.png").getAbsoluteFile());
		} catch (IOException e) {
		}

		try {
			eagle = ImageIO.read(new File("eagle.png"));
		} catch (IOException e) {
		}

		try {
			bullet = ImageIO.read(new File("bullet.png"));
		} catch (IOException e) {
		}

	}

	public static Image getExploitedEarth() {
		return exploitedEarth;
	}

	public static Image getBricks() {
		return bricks;
	}

	public static Image getEarth() {
		return earth;
	}

	public static Image getRocks() {
		return rocks;
	}

	public static Image getWater() {
		return water;
	}

	public static Image getEagle() {
		return eagle;
	}

	public static Image getBullet() {
		return bullet;
	}

}
