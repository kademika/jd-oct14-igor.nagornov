package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Eagle extends BFObject {

	public Eagle(int x, int y) {
		// TODO Auto-generated constructor stub

		super(x, y);
		color = new Color(255, 255, 255);

		try {
			image = ImageIO.read(new File("eagle.png"));
		} catch (IOException e) {
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (!isDestroyed()) {

			if (image != null) {

				g.drawImage(image, this.getX(), this.getY(),
						new ImageObserver() {
							@Override
							public boolean imageUpdate(Image arg0, int arg1,
									int arg2, int arg3, int arg4, int arg5) {
								// TODO Auto-generated method stub
								return false;
							}
						});
			} else {
				g.setColor(this.color);
				g.fillRect(this.getX(), this.getY(), 64, 64);
			}

		} else {
			try {
				image = ImageIO.read(new File("exploitedearth.png").getAbsoluteFile());
			} catch (IOException e) {
			}

			g.drawImage(image, getX(), getY(), getX() + 64, getY() + 64,
					getX(), getY(), getX() + 64, getY() + 64,
					new ImageObserver() {
						@Override
						public boolean imageUpdate(Image arg0, int arg1,
								int arg2, int arg3, int arg4, int arg5) {
							// TODO Auto-generated method stub
							return false;
						}
					});
		}

	}

}
