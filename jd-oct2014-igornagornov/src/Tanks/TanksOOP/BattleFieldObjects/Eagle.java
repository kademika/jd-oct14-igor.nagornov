package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import Tanks.TanksOOP.Service.LoadImages;

public class Eagle extends BFObject {

	public Eagle(int x, int y) {
		// TODO Auto-generated constructor stub

		super(x, y);
		color = new Color(0, 255, 255);

		image = LoadImages.getEagle();
		imageDestroyed = LoadImages.getExploitedEarth();

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (!isDestroyed()) {

			if (image != null) {

				g.drawImage(image, this.getX(), this.getY(), imageObserver);
			} else {
				g.setColor(this.color);
				g.fillRect(this.getX(), this.getY(), 64, 64);
			}

		} else {
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
