package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.Color;

import Tanks.TanksOOP.Service.LoadImages;

public class Earth extends BFObject{

	public Earth(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		color = new Color(180, 180, 180);
		
		image = LoadImages.getEarth();		
		imageDestroyed = LoadImages.getExploitedEarth();
	}
	
	
}
