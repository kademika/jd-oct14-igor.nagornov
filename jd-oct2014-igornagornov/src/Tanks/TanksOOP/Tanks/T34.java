package Tanks.TanksOOP.Tanks;

import java.awt.Color;
import java.awt.Graphics;

import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.Service.ActionField;
import Tanks.TanksOOP.Service.Direction;

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
