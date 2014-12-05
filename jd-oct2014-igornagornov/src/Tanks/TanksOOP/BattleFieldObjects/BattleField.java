package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Graphics;
import java.util.Random;



import Tanks.TanksOOP.Service.Drawable;
import Tanks.TanksOOP.Service.LoadImages;

public class BattleField implements Drawable{

	final boolean COLORDED_MODE = false;

	private final int BF_WIDTH = 576;
	private final int BF_HEIGHT = 576;

	private String[][] battleFieldTemplate = {
			{ " ", " ", "W", "B", " ", "B", "W", " ", " " },
			{ "B", " ", "W", "B", " ", "B", "W", " ", "B" },
			{ "B", "B", "W", "B", "B", "B", "W", "B", "B" },
			{ "B", "B", "W", "W", "W", "W", "W", "B", "B" },
			{ "B", "B", "R", "R", "R", "R", "R", "B", "B" },
			{ "B", "B", " ", " ", "B", " ", " ", "B", "B" },
			{ "B", " ", " ", " ", "B", " ", " ", " ", "B" },
			{ "B", " ", " ", "W", "W", "W", " ", " ", "B" },
			{ " ", " ", " ", "B", "E", "B", " ", " ", " " } };
	
	
	private BFObject[][] battleField = new BFObject[9][9];

	public BattleField() {
		drawBattleField();
	}

	public BattleField(String[][] battleField) {
		this.battleFieldTemplate = battleField;
		drawBattleField();
	}
	
	private String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}
	
	private void drawBattleField() {
		
		new LoadImages();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				String coordinates = getQuadrantXY(i + 1, j + 1);
				int separator = coordinates.indexOf("_");
				int y = Integer.parseInt(coordinates
						.substring(0, separator));
				int x = Integer.parseInt(coordinates
						.substring(separator + 1));

				String obj = battleFieldTemplate[i][j];
				BFObject bfObject;				
				
				if (obj.equals("B")) {
					bfObject = new Brick(x, y);
				} else if (obj.equals("R")) {
					bfObject = new Rock(x, y);
				} else if (obj.equals("E")) {
					bfObject = new Eagle(x, y);
				} else if (obj.equals("W")) {
					bfObject = new Water(x, y);
				} else {
					bfObject = new Earth(x, y);
				}
				battleField[i][j] = bfObject;
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		for (int j = 0; j < battleField.length; j++) {
			for (int k = 0; k < battleField.length; k++) {
				battleField[j][k].draw(g); 
			}
		}
	}

	public BFObject[][] getBattleField() {
		return battleField;
	}
	
	public BFObject scanQuadrant(int v, int h) {
		return battleField[v][h];

	}

	public void updateQuadrant(int v, int h, String str) {
		battleFieldTemplate[v][h] = str;
	}
	
	public void destroyObject(int v, int h) {
		battleField[v][h].destroy();
	}

	public int getDimensionX() {
		return battleFieldTemplate.length;
	}

	public int getDimensionY() {
		return battleFieldTemplate.length;
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
