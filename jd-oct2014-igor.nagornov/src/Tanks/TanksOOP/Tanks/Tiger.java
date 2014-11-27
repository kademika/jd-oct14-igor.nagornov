package Tanks.TanksOOP.Tanks;

import java.awt.Color;

import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.Service.ActionField;
import Tanks.TanksOOP.Service.Direction;
import Tanks.TanksOOP.Tanks.Action;

public class Tiger extends Tank {
	
	private int armor;
	private int lives;
	private boolean isRised=false;

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
	
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public boolean isRised() {
		return isRised;
	}
	
	public void setRised(boolean isRised) {
		this.isRised = isRised;
	}
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		if (this.getArmor() > 0) {
			setArmor(0);
		} else {			
			if(lives>0){								
				isRised = true;
				lives--;
			
			}else{
				super.destroy();
			}
		}	
	}	

	@Override
	public Action setUp() {
		// TODO Auto-generated method stub
		return Action.CLEAN;
	}
	

}
