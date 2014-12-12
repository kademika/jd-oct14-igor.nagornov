package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;

import Tanks.TanksOOP.Service.LoadImages;

public class Rock extends BFObject{

	
	public Rock(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		color = new Color(100, 100, 100);
		
		image = LoadImages.getRocks();		
		imageDestroyed = LoadImages.getExploitedEarth();
	}	
	
}
