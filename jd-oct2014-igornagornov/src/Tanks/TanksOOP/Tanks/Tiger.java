package Tanks.TanksOOP.Tanks;

import java.awt.Color;
import java.awt.Graphics;

import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.Service.ActionField;
import Tanks.TanksOOP.Service.Direction;

public class Tiger extends Tank {

	public Tiger(ActionField actionfield, BattleField battlefield, int x,
			int y, Direction direction) {
		super(actionfield, battlefield, x, y, direction);
		setArmor(1);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		
	}

	public Tiger(ActionField actionfield, BattleField battlefield) {
		this(actionfield, battlefield, 0, 0, Direction.RIGHT);		
	}

	private int armor;

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	@Override
	public void destroy() throws InterruptedException {
		// TODO Auto-generated method stub
		if(this.getArmor()>0){
			setArmor(0);
		}
		else {
			super.destroy();		
		}
	}	
	

}
