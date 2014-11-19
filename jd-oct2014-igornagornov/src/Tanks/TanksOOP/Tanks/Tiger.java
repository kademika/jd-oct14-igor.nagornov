package Tanks.TanksOOP.Tanks;

import java.awt.Color;

import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.Service.ActionField;
import Tanks.TanksOOP.Service.Direction;
import Tanks.TanksOOP.Tanks.Action;

public class Tiger extends Tank {
	
	private int armor;
	private int lives;

	public Tiger(BattleField battlefield, int x, int y, Direction direction) {
		super(battlefield, x, y, direction);
		setArmor(1);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		lives=1;

	}

	public Tiger(BattleField battlefield) {
		this(battlefield, 0, 0, Direction.RIGHT);
	}
	

	public int getArmor() {
		return armor;
	}	


	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getLives() {
		return lives;
	}
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		if (this.getArmor() > 0) {
			setArmor(0);
		} else {
			if(lives>0){
				rise();
			}
			else{
				super.destroy();
			}
		}
	}
	
	public void rise() throws Exception{			
		
		String temp = BattleField.getAgressorLocation();
		int agrX = Integer
				.parseInt(temp.substring(0, temp.indexOf("_")));
		int agrY = Integer
				.parseInt(temp.substring(temp.indexOf("_") + 1));
		this.setX(agrX);
		this.setY(agrY);
		this.setArmor(1);
		this.turn(Direction.DOWN);
		lives --;	
		
	}

	@Override
	public Action setUp() {
		// TODO Auto-generated method stub
		return Action.NONE;
	}

}
