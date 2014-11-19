package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;
import java.awt.Graphics;

import Tanks.TanksOOP.Service.ActionField;
import Tanks.TanksOOP.Service.Drawable;

public class Brick extends BFObject{
	
	public Brick(int x, int y) {
		super(x, y);
		color = new Color(255, 100, 100);
	}	

}
