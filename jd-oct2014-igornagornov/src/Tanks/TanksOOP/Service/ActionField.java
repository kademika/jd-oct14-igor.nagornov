package Tanks.TanksOOP.Service;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import Tanks.TanksOOP.BattleFieldObjects.BFObject;
import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.BattleFieldObjects.Brick;
import Tanks.TanksOOP.BattleFieldObjects.Bullet;
import Tanks.TanksOOP.BattleFieldObjects.Earth;
import Tanks.TanksOOP.BattleFieldObjects.Rock;
import Tanks.TanksOOP.BattleFieldObjects.Water;
import Tanks.TanksOOP.Tanks.Action;
import Tanks.TanksOOP.Tanks.BT7;
import Tanks.TanksOOP.Tanks.T34;
import Tanks.TanksOOP.Tanks.Tank;
import Tanks.TanksOOP.Tanks.Tiger;

public class ActionField extends JPanel {

	final boolean COLORDED_MODE = false;
	private BattleField battlefield = new BattleField();
	private Tank defender = new T34(battlefield, 128, 512, Direction.UP);
	private Tank agressor = new Tiger(battlefield);
	private Bullet bullet = new Bullet(-100, -100, Direction.NONE);
	

	public ActionField() {
		// TODO Auto-generated constructor stub

		new ChooseTankModelForm(this);

		JFrame mainFrame = new JFrame("BATTLE FIELD, OOP");
		mainFrame.setLocation(750, 150);
		mainFrame.setMinimumSize(new Dimension(battlefield.getBF_WIDTH(),
				battlefield.getBF_HEIGHT() + 22));
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.getContentPane().add(this);
		mainFrame.pack();
		mainFrame.setVisible(true);

	}

	public void setAgressor(boolean isTigerSelected) {
		if (!isTigerSelected) {
			agressor = new BT7(battlefield);
		} else {
			agressor = new Tiger(battlefield);
		}

	}

	void runTheGame() throws Exception {

		while (!agressor.isDestroyed() && !defender.isDestroyed() && !(battlefield.getBattleField()[8][4].isDestroyed())) {
			if(!agressor.isDestroyed() && !defender.isDestroyed() && !(battlefield.getBattleField()[8][4].isDestroyed())){
				processAction(agressor.setUp(), agressor);
				processAction(defender.setUp(), defender);
			}
		}
		
		String result="";
		
		if(agressor.isDestroyed()){
			result = "Defender win!";
		}
		
		if(defender.isDestroyed() || battlefield.getBattleField()[8][4].isDestroyed()){
			result = "Agressor win!";
		}
		
		new ShowWinnerForm(result);

	}

	public static String getQuadrant(int x, int y) {
		x /= 64;
		y /= 64;
		return (y + "_" + x);
	}

	public static String getQuadrantXY(int v, int h) {
		return v * 64 + "_" + h * 64;
	}

	private void processAction(Action action, Tank tank) throws Exception {

		if (action == Action.MOVE) {
			processMove(tank);
		} else if (action == Action.FIRE) {
			processFire(tank);
		} else if (action == Action.CLEAN) {
			processClean(tank);
		} else if (action == Action.MOVE_RANDOM) {
			processMoveRandom(tank);
		} else if (action == Action.MOVE_TO_RANDOM_QUADRANT) {
			processMoveToRandomQuadrant(tank);
		}

	}

	private void processMove(Tank tank) throws Exception {
		// TODO Auto-generated method stub

		Direction direction = tank.getDirection();
		int step = 1;
		int covered = 0;

		// check limits x: 0, 513; y: 0, 513
		if ((direction == Direction.UP && tank.getY() == 0)
				|| (direction == Direction.DOWN && tank.getY() == 512)
				|| (direction == Direction.LEFT && tank.getX() == 0)
				|| (direction == Direction.RIGHT && tank.getX() == 512 || direction == Direction.NONE)) {
			// System.out.println("[illegal move] direction: "
			// + tank.getDirection() + " tankX: " + tank.getX()
			// + ", tankY: " + tank.getY());
			return;
		}

		if (!checkNextQuadrant(tank)) {
			return;
		}

		while (covered < 64) {
			if (tank.getDirection() == Direction.UP) {
				tank.updateY(-step);
				// System.out.println("[move up] direction: "
				// + tank.getDirection() + " tankX: " + tank.getX()
				// + ", tankY: " + tank.getY());
			} else if (tank.getDirection() == Direction.DOWN) {
				tank.updateY(step);
				// System.out.println("[move down] direction: "
				// + tank.getDirection() + " tankX: " + tank.getX()
				// + ", tankY: " + tank.getY());
			} else if (tank.getDirection() == Direction.LEFT) {
				tank.updateX(-step);
				// System.out.println("[move left] direction: "
				// + tank.getDirection() + " tankX: " + tank.getX()
				// + ", tankY: " + tank.getY());
			} else {
				tank.updateX(step);
				// System.out.println("[move right] direction: "
				// + tank.getDirection() + " tankX: " + tank.getX()
				// + ", tankY: " + tank.getY());
			}
			covered += step;

			repaint();
			Thread.sleep(tank.getSpeed());
		}

	}

	private void moveToQuadrant(Tank tank, int v, int h)
			throws Exception {

		String coordinates = getQuadrantXY(v, h);
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));

		if (tank.getX() < x) {
			while (tank.getX() != x) {
				tank.turn(Direction.RIGHT);
				processMove(tank);
			}
		} else {
			while (tank.getX() != x) {
				tank.turn(Direction.LEFT);
				processMove(tank);
			}
		}

		if (tank.getY() < y) {
			while (tank.getY() != y) {
				tank.turn(Direction.DOWN);
				processMove(tank);
			}
		} else {
			while (tank.getY() != y) {
				tank.turn(Direction.UP);
				processMove(tank);
			}
		}
	}

	private void processMoveRandom(Tank tank) throws Exception {

		// TODO Auto-generated method stub

		Random r = new Random();
		int i;

		i = r.nextInt(5);
		if (i > 0) {
			tank.turn(Direction.getDirection(i));
			processMove(tank);
		}

	}

	private void processMoveToRandomQuadrant(Tank tank) throws Exception {

		Random r = new Random();

		int i = r.nextInt(9);
		int j = r.nextInt(9);

		if (i != 0 && j != 0) {
			moveToQuadrant(tank, i, j);
			Thread.sleep(1000);
		}

	}

	private void processFire(Tank tank) throws Exception {
		// TODO Auto-generated method stub
		this.bullet = tank.fire();
		int step = 1;
		Direction direction = bullet.getDirection();

		while ((bullet.getY() > -14 && bullet.getY() < 590)
				&& (bullet.getX() > -14 && bullet.getX() < 590)) {
			if (direction == Direction.UP) {
				bullet.updateY(-step);
			} else if (direction == Direction.DOWN) {
				bullet.updateY(step);
			} else if (direction == Direction.LEFT) {
				bullet.updateX(-step);
			} else {
				bullet.updateX(step);
			}

			boolean isTiger = (tank instanceof Tiger);

			if (checkInterception(isTiger)) {
				bullet.destroy();

				if (agressor instanceof Tiger) {
					if (((Tiger) agressor).isRised()) {
						bullet.destroy();
						repaint();
						Thread.sleep(3000);
						agressorRise();
						repaint();
						return;
					}
				}

			}

			repaint();
			Thread.sleep(bullet.getSpeed());

		}

	}

	private void processClean(Tank tank) throws Exception {

		int distanceUp, distanceDown, distanceLeft, distanceRight, minDistance = 512;

		if(tank instanceof T34){
			distanceUp = tank.findObjectAtTop(agressor);
			distanceDown = tank.findObjectAtBottom(agressor);
			distanceLeft = tank.findObjectAtLeft(agressor);
			distanceRight = tank.findObjectAtRight(agressor);
		}else{
			distanceUp = tank.findObjectAtTop(defender);
			distanceDown = tank.findObjectAtBottom(defender);
			distanceLeft = tank.findObjectAtLeft(defender);
			distanceRight = tank.findObjectAtRight(defender);
		}		

		int[] distances = { distanceUp, distanceDown, distanceLeft,
				distanceRight };

		int direction = 1;

		for (int i = 0; i < distances.length; i++) {
			if (distances[i] < minDistance) {
				minDistance = distances[i];
				direction = i + 1;
			}
		}

		if (minDistance == 512) {
			if(tank instanceof T34){				
				String coordinatesNext = ((T34) tank).generateNextPosition();
				int v = Integer.parseInt(coordinatesNext.split("_")[0]);
				int h = Integer.parseInt(coordinatesNext.split("_")[1]);
				moveToQuadrant(tank, v, h);				
			}else{
				processMoveToRandomQuadrant(tank);
			}
									
			return;
		}
		
		tank.turn(Direction.getDirection(direction));
		
		if(!(tank.isDestroyed())){
			processFire(tank);
			if(tank instanceof BT7 || tank instanceof T34){
				processMoveRandom(tank);
			}
		}	


	}

	

	private boolean checkInterception(boolean isTiger) throws Exception {

		String coordinates = getQuadrant(bullet.getX(), bullet.getY());
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));

		String coordinatesAgressor = getQuadrant(agressor.getX(),
				agressor.getY());
		String coordinatesDefender = getQuadrant(defender.getX(),
				defender.getY());

		if ((y >= 0 && y < battlefield.getDimensionY())
				&& (x >= 0 && x < battlefield.getDimensionX())) {

			BFObject bfObject = battlefield.scanQuadrant(y, x);
			if (!bfObject.isDestroyed() && !(bfObject instanceof Earth)
					&& !(bfObject instanceof Water)) {

				if (bfObject instanceof Rock) {
					if (isTiger) {
						battlefield.destroyObject(y, x);
					}
				} else {
					battlefield.destroyObject(y, x);
				}

				return true;
			}

			if (coordinatesAgressor.equals(coordinates)) {
				agressor.destroy();
				return true;
			}

			if (coordinatesDefender.equals(coordinates)) {
				defender.destroy();
				return true;
			}

		}

		return false;
	}

	private boolean checkNextQuadrant(Tank tank) throws Exception {

		Direction direction = tank.getDirection();

		String tankQuadrant = getQuadrant(tank.getX(), tank.getY());
		int v = Integer.parseInt(tankQuadrant.split("_")[0]);
		int h = Integer.parseInt(tankQuadrant.split("_")[1]);

		String coordinatesAgressor = getQuadrant(agressor.getX(),
				agressor.getY());
		String coordinatesDefender = getQuadrant(defender.getX(),
				defender.getY());

		// check next quadrant before move
		if (direction == Direction.UP && v > 0) {
			v--;
		} else if (direction == Direction.DOWN && v < 9) {
			v++;
		} else if (direction == Direction.RIGHT && h < 9) {
			h++;

		} else if (direction == Direction.LEFT && h > 0) {
			h--;
		}

		if (v < 0 || v > 8 || h < 0 || h > 8) {
			return false;
		}

		String coordinatesNext = getQuadrantXY(v, h);
		int yNext = Integer.parseInt(coordinatesNext.split("_")[0]);
		int xNext = Integer.parseInt(coordinatesNext.split("_")[1]);
		String quadrantNext = getQuadrant(xNext, yNext);

		if (tank instanceof T34 && coordinatesAgressor.equals(quadrantNext)) {
			processFire(tank);
		}
		if ((tank instanceof Tiger || tank instanceof BT7)
				&& coordinatesDefender.equals(quadrantNext)) {
			processFire(tank);
		}

		BFObject bfobject = battlefield.scanQuadrant(v, h);
		if (!bfobject.isDestroyed() && !(bfobject instanceof Earth)
				&& !(bfobject instanceof Water)) {
			if (bfobject instanceof Brick) {
				processFire(tank);
			} else {
				if (tank instanceof Tiger) {
					processFire(tank);
				} else {					
					processMoveRandom(tank);
				}

			}

		}

		if (quadrantIsEmpty(xNext, yNext)) {
			return true;
		}

		return false;
	}

	private boolean quadrantIsEmpty(int cX, int cY) {

		String coordinates;
		coordinates = getQuadrant(cX, cY);

		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));

		String coordinatesAgressor = getQuadrant(agressor.getX(),
				agressor.getY());
		String coordinatesDefender = getQuadrant(defender.getX(),
				defender.getY());

		if ((y >= 0 && y < battlefield.getDimensionY())
				&& (x >= 0 && x < battlefield.getDimensionX())) {

			BFObject bfObject = battlefield.scanQuadrant(y, x);

			if (!bfObject.isDestroyed() && !(bfObject instanceof Earth)
					&& !(bfObject instanceof Water)) {
				return false;
			}

			if (coordinatesAgressor.equals(coordinates)
					|| coordinatesDefender.equals(coordinates)) {
				return false;
			}

		}

		return true;
	}

	private void agressorRise() throws Exception {

		String temp = battlefield.getAgressorLocation();
		int agrX = Integer.parseInt(temp.substring(0, temp.indexOf("_")));
		int agrY = Integer.parseInt(temp.substring(temp.indexOf("_") + 1));

		agressor.setX(agrX);
		agressor.setY(agrY);
		((Tiger) agressor).setArmor(1);
		agressor.turn(Direction.DOWN);
		((Tiger) agressor).setRised(false);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		battlefield.draw(g);
		agressor.draw(g);
		defender.draw(g);		
		battlefield.drawWater(g);
		bullet.draw(g);	

	}

}
