package Tanks.TanksOOP.Service;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Tanks.TanksOOP.BattleFieldObjects.BFObject;
import Tanks.TanksOOP.BattleFieldObjects.BattleField;
import Tanks.TanksOOP.BattleFieldObjects.Bullet;
import Tanks.TanksOOP.BattleFieldObjects.Earth;
import Tanks.TanksOOP.BattleFieldObjects.Rock;
import Tanks.TanksOOP.BattleFieldObjects.Water;
import Tanks.TanksOOP.Tanks.Action;
import Tanks.TanksOOP.Tanks.T34;
import Tanks.TanksOOP.Tanks.Tank;
import Tanks.TanksOOP.Tanks.Tiger;

public class ActionField extends JPanel {

	final boolean COLORDED_MODE = false;
	private BattleField battlefield;
	private Tank defender;
	private Tiger agressor;
	private Bullet bullet;

	public ActionField() throws Exception {

		battlefield = new BattleField();
		defender = new T34(battlefield, 128, 0, Direction.UP);

		String temp = BattleField.getAgressorLocation();

		int x = Integer.parseInt(temp.substring(0, temp.indexOf("_")));
		int y = Integer.parseInt(temp.substring(temp.indexOf("_") + 1));

		agressor = new Tiger(battlefield, x, y, Direction.DOWN);

		bullet = new Bullet(-100, -100, Direction.NONE);

		JFrame frame = new JFrame("BATTLE FIELD, OOP");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(battlefield.getBF_WIDTH(),
				battlefield.getBF_HEIGHT() + 22));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	void runTheGame() throws Exception {

		while (true) {
			if (!agressor.isDestroyed() && !defender.isDestroyed()) {
				processAction(agressor.setUp(), agressor);
				processAction(defender.setUp(), defender);
			}
		}

	}

	public String getQuadrant(int x, int y) {
		x /= 64;
		y /= 64;
		return (y + "_" + x);
	}

	public String getQuadrantXY(int v, int h) {
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
		else if (action == Action.MOVE_TO_QUADRANT) {
			processMoveToQuadrant(tank, 0, 8);
		}
		else if (action == Action.TURN) {
			tank.turn(Direction.LEFT);
		}

	}

	public void processMove(Tank tank) throws Exception {
		// TODO Auto-generated method stub

		Direction direction = tank.getDirection();
		int step = 1;
		int covered = 0;

		// check limits x: 0, 513; y: 0, 513
		if ((direction == Direction.UP && tank.getY() <= 0)
				|| (direction == Direction.DOWN && tank.getY() >= 512)
				|| (direction == Direction.LEFT && tank.getX() <= 0)
				|| (direction == Direction.RIGHT && tank.getX() >= 512 || direction == Direction.NONE)) {
			System.out.println("[illegal move] direction: "
					+ tank.getDirection() + " tankX: " + tank.getX()
					+ ", tankY: " + tank.getY());
			return;
		}

		if (!checkNextQuadrant(tank))
			return;

		while (covered < 64) {
			if (tank.getDirection() == Direction.UP) {
				tank.updateY(-step);
				System.out.println("[move up] direction: "
						+ tank.getDirection() + " tankX: " + tank.getX()
						+ ", tankY: " + tank.getY());
			} else if (tank.getDirection() == Direction.DOWN) {
				tank.updateY(step);
				System.out.println("[move down] direction: "
						+ tank.getDirection() + " tankX: " + tank.getX()
						+ ", tankY: " + tank.getY());
			} else if (tank.getDirection() == Direction.LEFT) {
				tank.updateX(-step);
				System.out.println("[move left] direction: "
						+ tank.getDirection() + " tankX: " + tank.getX()
						+ ", tankY: " + tank.getY());
			} else {
				tank.updateX(step);
				System.out.println("[move right] direction: "
						+ tank.getDirection() + " tankX: " + tank.getX()
						+ ", tankY: " + tank.getY());
			}
			covered += step;

			repaint();
			Thread.sleep(tank.getSpeed());
		}

	}

	public void processMoveToQuadrant(Tank tank, int v, int h) throws Exception {

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

	public void processMoveRandom(Tank tank) throws Exception {

		// TODO Auto-generated method stub

		Random r = new Random();
		int i;

		i = r.nextInt(5);
		if (i > 0) {
			tank.turn(Direction.getDirection(i));
			processMove(tank);
		}

	}

	public void processMoveToRandomQuadrant(Tank tank) throws Exception {

		Random r = new Random();

		int i = r.nextInt(9);
		int j = r.nextInt(9);

		if (i != 0 && j != 0) {
			processMoveToQuadrant(tank, i, j);
			Thread.sleep(1000);
		}

	}

	public void processFire(Tank tank) throws Exception {
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
			}

			repaint();
			Thread.sleep(bullet.getSpeed());

		}

	}

	public void processClean(Tank tank) throws Exception {

		int distanceUp, distanceDown, distanceLeft, distanceRight, minDistance = 512;

		distanceUp = findBrickAtTop(tank);
		distanceDown = findBrickAtBottom(tank);
		distanceLeft = findBrickAtLeft(tank);
		distanceRight = findBrickAtRight(tank);

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
			processMoveToRandomQuadrant(tank);
			return;
		}
		tank.turn(Direction.getDirection(direction));
		processFire(tank);

	}

	private int findBrickAtTop(Tank tank) {
		int distance = 512;

		int y = tank.getY();
		while (y > 0) {
			y -= 64;
			if (!quadrantIsEmpty(tank.getX(), y)) {
				distance = tank.getY() - y - 64;
				break;
			}
		}

		return distance;

	}

	private int findBrickAtBottom(Tank tank) {

		int distanceDown = 512;

		int y = tank.getY();
		while (y < 512) {
			y += 64;
			if (!quadrantIsEmpty(tank.getX(), y)) {
				distanceDown = y - tank.getY() - 64;
				break;
			}
		}

		return distanceDown;
	}

	private int findBrickAtLeft(Tank tank) {
		int distanceLeft = 512;

		int x = tank.getX();
		while (x > 0) {
			x -= 64;
			if (!quadrantIsEmpty(x, tank.getY())) {
				distanceLeft = tank.getX() - x - 64;
				break;
			}
		}

		return distanceLeft;
	}

	private int findBrickAtRight(Tank tank) {
		int distanceRight = 512;

		int x = tank.getX();
		while (x < 512) {
			x += 64;
			if (!quadrantIsEmpty(x, tank.getY())) {
				distanceRight = x - tank.getX() - 64;
				break;
			}

		}
		return distanceRight;

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
			processFire(tank);			
		}		
		if (tank instanceof Tiger && coordinatesDefender.equals(quadrantNext)) {
			processFire(tank);			
		}		
		
		BFObject bfobject = battlefield.scanQuadrant(v, h);
		if (!bfobject.isDestroyed() && !(bfobject instanceof Earth)
				&& !(bfobject instanceof Water)) {
			processFire(tank);
		}

//		if (battlefield.scanQuadrant(v, h).isDestroyed()
//				&& !(battlefield.scanQuadrant(v, h) instanceof Earth)
//				&& !(battlefield.scanQuadrant(v, h) instanceof Water)) {
//			return true;
//		} else if ((battlefield.scanQuadrant(v, h) instanceof Earth)
//				|| (battlefield.scanQuadrant(v, h) instanceof Water)) {
//			return true;
//		}
		
		if(quadrantIsEmpty(xNext, yNext)){
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

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int i = 0;
		Color cc = new Color(180, 180, 180);
		for (int v = 0; v < 9; v++) {
			for (int h = 0; h < 9; h++) {
				// if (COLORDED_MODE) {
				// if (i % 2 == 0) {
				// cc = new Color(252, 241, 177);
				// } else {
				// cc = new Color(233, 243, 255);
				// }
				// } else {
				// cc = new Color(180, 180, 180);
				// }
				// i++;
				g.setColor(cc);
				g.fillRect(h * 64, v * 64, 64, 64);
			}
		}

		battlefield.draw(g);

		defender.draw(g);

		agressor.draw(g);

		bullet.draw(g);

	}

}
