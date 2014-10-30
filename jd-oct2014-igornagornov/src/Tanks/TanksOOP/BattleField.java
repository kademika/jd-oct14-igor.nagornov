package Tanks.TanksOOP;

import java.util.Random;

import javax.swing.JPanel;

public class BattleField extends JPanel {

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

}
