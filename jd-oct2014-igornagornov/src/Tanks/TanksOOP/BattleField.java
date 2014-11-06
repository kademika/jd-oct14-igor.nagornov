package Tanks.TanksOOP;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class BattleField extends JPanel implements Drawable{

	final boolean COLORDED_MODE = false;

	private final int BF_WIDTH = 576;
	private final int BF_HEIGHT = 576;

	private static String[][] battleField = {
			{ " ", " ", " ", "B", " ", "B", " ", " ", " " },
			{ "B", " ", " ", "B", " ", "B", " ", " ", "B" },
			{ "B", "B", " ", "B", "B", "B", " ", "B", "B" },
			{ "B", "B", "B", " ", " ", " ", "B", "B", "B" },
			{ "B", "B", "B", " ", " ", " ", "B", "B", "B" },
			{ "B", "B", " ", " ", "B", " ", " ", "B", "B" },
			{ "B", " ", " ", " ", "B", " ", " ", " ", "B" },
			{ "B", " ", " ", "B", "B", "B", " ", " ", "B" },
			{ " ", " ", " ", "B", "B", "B", " ", " ", " " } };

	public String scanQuadrant(int v, int h) {
		return battleField[v][h];

	}

	public void updateQuadrant(int v, int h, String str) {
		battleField[v][h] = str;
	}

	public int getDimensionX() {
		return battleField.length;
	}

	public int getDimensionY() {
		return battleField.length;
	}

	public int getBF_WIDTH() {
		return BF_WIDTH;
	}

	public int getBF_HEIGHT() {
		return BF_HEIGHT;
	}

	public String getAgressorLocation() {
		int random;
		String result = "0_0";

		Random r = new Random();

		random = r.nextInt(3);

		switch (random) {
		case 0: {
			result = "0_0";
			break;
		}
		case 1: {
			result = "512_0";
			break;
		}
		case 2: {
			result = "256_0";
			break;
		}

		}

		return result;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int i = 0;
		Color cc;
		for (int v = 0; v < 9; v++) {
			for (int h = 0; h < 9; h++) {
				if (COLORDED_MODE) {
					if (i % 2 == 0) {
						cc = new Color(252, 241, 177);
					} else {
						cc = new Color(233, 243, 255);
					}
				} else {
					cc = new Color(180, 180, 180);
				}
				i++;
				g.setColor(cc);
				g.fillRect(h * 64, v * 64, 64, 64);
			}
		}

		for (int j = 0; j < this.getDimensionY(); j++) {
			for (int k = 0; k < this.getDimensionX(); k++) {
				if (this.scanQuadrant(j, k).equals("B")) {
					String coordinates = ActionField.getQuadrantXY(j + 1, k + 1);
					int separator = coordinates.indexOf("_");
					int y = Integer.parseInt(coordinates
							.substring(0, separator));
					int x = Integer.parseInt(coordinates
							.substring(separator + 1));
					g.setColor(new Color(0, 0, 255));
					g.fillRect(x, y, 64, 64);
				}
			}
		}
	}

}
