package Tanks.TanksOOP;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ActionField extends JPanel {

	final boolean COLORDED_MODE = false;
	private BattleField battlefield;
	private Tank defender;
	private Tiger agressor;
	private Bullet bullet;

	public ActionField() throws Exception {

		battlefield = new BattleField();
		defender = new T34(this, battlefield, 128, 512, Direction.UP);

		String temp = battlefield.getAgressorLocation();

		int x = Integer.parseInt(temp.substring(0, temp.indexOf("_")));
		int y = Integer.parseInt(temp.substring(temp.indexOf("_") + 1));

		agressor = new Tiger(this, battlefield, x, y, Direction.DOWN);

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
		// while (true) {
		// defender.clean();
		// agressor.clean();
		// }

		agressor.moveToQuadrant(1, 3);
		agressor.fire();
		agressor.turn(Direction.RIGHT);
		agressor.fire();
		agressor.turn(Direction.DOWN);
		// agressor.fire();
		defender.fire();
		agressor.fire();
		defender.fire();
		defender.fire();
		agressor.moveToQuadrant(1, 3);
		defender.fire();
		defender.fire();

	}

	public static String getQuadrant(int x, int y) {
		x /= 64;
		y /= 64;
		return (y + "_" + x);
	}

	public static String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}

	public void processTurn(Tank tank) {
		// TODO Auto-generated method stub
		repaint();
	}

	public void processMove(Tank tank) throws Exception {
		// TODO Auto-generated method stub

		Direction direction = tank.getDirection();
		int step = 1;
		int covered = 0;

		// check limits x: 0, 513; y: 0, 513
		if ((direction == Direction.UP && tank.getY() == 0)
				|| (direction == Direction.DOWN && tank.getY() >= 512)
				|| (direction == Direction.LEFT && tank.getX() == 0)
				|| (direction == Direction.RIGHT && tank.getX() >= 512 || direction == Direction.NONE)) {
			System.out.println("[illegal move] direction: "
					+ tank.getDirection() + " tankX: " + tank.getX()
					+ ", tankY: " + tank.getY());
			return;
		}

		tank.turn(direction);

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

			if (tank.isCollision())
				tank.fire();
			repaint();
			Thread.sleep(tank.getSpeed());
		}

	}

	public void processMoveToQuadrant(Tank tank, int v, int h) throws Exception {
		String coordinates = getQuadrantXY(v, h);
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));

		// String coordinatesTank = getQuadrant(tank.getX(), tank.getY());
		//
		// int tY = Integer.parseInt(coordinatesTank.substring(0,
		// coordinatesTank.indexOf("_")));
		// int tX =
		// Integer.parseInt(coordinatesTank.substring(coordinatesTank.indexOf("_")
		// + 1));
		//
		// battlefield.updateQuadrant(tY, tX, " ");

		if (tank.getX() < x) {
			while (tank.getX() != x) {
				tank.turn(Direction.RIGHT);
				tank.move();
			}
		} else {
			while (tank.getX() != x) {
				tank.turn(Direction.LEFT);
				tank.move();
			}
		}

		if (tank.getY() < y) {
			while (tank.getY() != y) {
				tank.turn(Direction.DOWN);
				tank.move();
			}
		} else {
			while (tank.getY() != y) {
				tank.turn(Direction.UP);
				tank.move();
			}
		}
		// tank.setTankOnBattlefield();
	}

	public void processMoveRandom(Tank tank) throws Exception { // двигает танк
																// на один
																// квадрант в
																// случайном
																// направлении
		// TODO Auto-generated method stub

		Random r = new Random();
		int i;
		while (true) {
			i = r.nextInt(5);
			if (i > 0) {
				tank.turn(Direction.getDirection(i));
				tank.move();
				tank.fire();
			}
		}
	}

	public void processMoveToRandomQuadrant(Tank tank) throws Exception { // двигает
																			// танк
																			// в
																			// случайный
																			// квадрант
		Random r = new Random();

		int i = r.nextInt(9);
		int j = r.nextInt(9);

		if (i != 0 && j != 0) {
			processMoveToQuadrant(tank, i, j);
			Thread.sleep(1000);
		}

	}

	void processClean(Tank tank) throws Exception { // если есть кирпичи в
													// пределах видимости,
													// уничтожает их по всем
													// направлениям
		int distanceUp, distanceDown, distanceLeft, distanceRight, minDistance = 512;
		// танк стреляет в ближайший кирпич
		// после уничтожения всех кирпичей в пределах видимости
		// танк едет в случайный квадрант

		distanceUp = tank.findBrickAtTop();
		distanceDown = tank.findBrickAtBottom();
		distanceLeft = tank.findBrickAtLeft();
		distanceRight = tank.findBrickAtRight();

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
			tank.moveToRandomQuadrant();
			return;
		}
		tank.turn(Direction.getDirection(direction));
		tank.fire();

	}

	public int processFindBrickAtTop(Tank tank) {
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

	public int processFindBrickAtBottom(Tank tank) {

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

	public int processFindBrickAtLeft(Tank tank) {
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

	public int processFindBrickAtRight(Tank tank) {
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

	public void processFire(Bullet bullet) throws Exception {
		// TODO Auto-generated method stub
		this.bullet = bullet;
		int step = 1;
		Direction direction = bullet.getDirection();

		// tank.turn(direction);
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

			if (processInterception()) {
				bullet.destroy();
			}
			repaint();

			if (agressor.getX() == -100 && agressor.getY() == -100) {
				Thread.sleep(3000);
				String temp = battlefield.getAgressorLocation();
				int agrX = Integer
						.parseInt(temp.substring(0, temp.indexOf("_")));
				int agrY = Integer
						.parseInt(temp.substring(temp.indexOf("_") + 1));
				agressor.setX(agrX);
				agressor.setY(agrY);
				agressor.setArmor(1);
				agressor.setDirection(Direction.DOWN);
			} else {
				Thread.sleep(bullet.getSpeed());
			}

		}

	}

	private boolean processInterception() throws InterruptedException {

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
			if (!battlefield.scanQuadrant(y, x).trim().isEmpty()) {
				battlefield.updateQuadrant(y, x, "");
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

	public boolean processCollision(Tank tank) { // проверяет, столкнулся ли
													// танк с препятствием по
													// направлению движения
		String coordinates;

		if ((tank.getDirection() == Direction.UP && tank.getY() != 0)
				|| (tank.getDirection() == Direction.DOWN && tank.getY() < 512)
				|| (tank.getDirection() == Direction.LEFT && tank.getX() != 0)
				|| (tank.getDirection() == Direction.RIGHT && tank.getX() < 512)) {
			if (tank.getDirection() == Direction.UP
					|| tank.getDirection() == Direction.LEFT) {
				coordinates = getQuadrant(tank.getX(), tank.getY());
			} else if (tank.getDirection() == Direction.DOWN) {
				coordinates = getQuadrant(tank.getX(), tank.getY() + 64);
			} else {
				coordinates = getQuadrant(tank.getX() + 64, tank.getY());
			}
		} else {
			return false;
		}

		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));

		if ((y >= 0 && y < battlefield.getDimensionY())
				&& (x >= 0 && x < battlefield.getDimensionX())) {
			if (!battlefield.scanQuadrant(y, x).trim().isEmpty()) { // удаляет
																	// лишние
																	// пробелы и
																	// проверяет,
																	// что
																	// осталось
				return true;
			}
		}

		return false;
	}

	private boolean quadrantIsEmpty(int cX, int cY) { // проверяет пуст ли
														// указанный квадрант
		String coordinates;
		coordinates = getQuadrant(cX, cY);

		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));

		if ((y >= 0 && y < battlefield.getDimensionY())
				&& (x >= 0 && x < battlefield.getDimensionX())) {
			if (!battlefield.scanQuadrant(y, x).trim().isEmpty()) { // удаляет
																	// лишние
																	// пробелы и
																	// проверяет,
																	// что
																	// осталось
				return false;
			}
		}
		return true;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		battlefield.draw(g);

		defender.draw(g);

		agressor.draw(g);

		bullet.draw(g);

	}

}
