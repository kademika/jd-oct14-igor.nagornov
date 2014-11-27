package Tanks.TanksOOP.Tanks;

import java.awt.Color;
import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.Service.Direction;

public class T34 extends Tank {

	 private Action[] actions = new Action[] {Action.MOVE_TO_QUADRANT, Action.TURN, Action.FIRE, Action.MOVE_TO_RANDOM_QUADRANT};
//	 private Action[] actions = new Action[] {Action.MOVE_TO_QUADRANT, Action.TURN, Action.FIRE, Action.FIRE};
	 private int step = 0;

	public T34(BattleField battlefield, int x, int y, Direction direction) {
		// TODO Auto-generated constructor stub
		super(battlefield, x, y, direction);
		tankColor = new Color(0, 255, 0);
		towerColor = new Color(255, 0, 0);
	}

	public T34(BattleField battlefield) {
		// TODO Auto-generated constructor stub
		super(battlefield);
	}

	@Override
	public Action setUp() throws Exception {
		// TODO Auto-generated method stub

		 if (step >= actions.length) {
		 step = 0;
		 }		
		 return (Action) actions[step++];

//		return Action.NONE;
	}

}
