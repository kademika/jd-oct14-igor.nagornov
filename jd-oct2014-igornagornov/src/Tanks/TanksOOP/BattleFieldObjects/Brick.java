package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;
import java.awt.Graphics;

import Tanks.TanksOOP.Service.ActionField;
import Tanks.TanksOOP.Service.Drawable;

public class Brick implements Drawable{

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		for (int j = 0; j <BattleField.getBattleField().length; j++) {
			for (int k = 0; k < BattleField.getBattleField()[j].length; k++) {
				if (BattleField.getBattleField()[j][k].equals("B")) {
					String coordinates = ActionField.getQuadrantXY(j + 1, k + 1);
					int separator = coordinates.indexOf("_");
					int y = Integer.parseInt(coordinates
							.substring(0, separator));
					int x = Integer.parseInt(coordinates
							.substring(separator + 1));
					g.setColor(new Color(255, 100, 100));
					g.fillRect(x, y, 64, 64);
				}
			}
		}
	}	

}
