package Tanks.TanksOOP;

import java.awt.Color;
import java.awt.Graphics;

public class T34 extends Tank{

	public T34(ActionField actionfield, BattleField battlefield, int x, int y,
			Direction direction) {		
		// TODO Auto-generated constructor stub
		super(actionfield, battlefield, x, y, direction);
		tankColor = new Color(0, 255, 0);
		towerColor = new Color(255, 0, 0);
	}

	public T34(ActionField actionfield, BattleField battlefield) {		
		// TODO Auto-generated constructor stub
		super(actionfield, battlefield);
	}
	
	
}
