package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import Tanks.TanksOOP.Service.Drawable;

public class BattleField extends JPanel implements Drawable{

	final boolean COLORDED_MODE = false;

	private final int BF_WIDTH = 576;
	private final int BF_HEIGHT = 576;
	
	private Brick brick = new Brick();
	private Water water = new Water();
	private Rock rock = new Rock();
	private Eagle eagle = new Eagle();

	private static String[][] battleField = {
			{ " ", " ", "W", "B", " ", "B", "W", " ", " " },
			{ "B", " ", "W", "B", " ", "B", "W", " ", "B" },
			{ "B", "B", "W", "B", "B", "B", "W", "B", "B" },
			{ "B", "B", "W", "W", "W", "W", "W", "B", "B" },
			{ "B", "B", "R", "R", "R", "R", "R", "B", "B" },
			{ "B", "B", " ", " ", "B", " ", " ", "B", "B" },
			{ "B", " ", " ", " ", "B", " ", " ", " ", "B" },
			{ "B", " ", " ", "B", "B", "B", " ", " ", "B" },
			{ " ", " ", " ", "B", "E", "B", " ", " ", " " } };

	public static String[][] getBattleField() {
		return battleField;
	}
	
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

		brick.draw(g);
		water.draw(g);
		rock.draw(g);
		eagle.draw(g);
	}
	

}
