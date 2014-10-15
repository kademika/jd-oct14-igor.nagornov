package Tanks.TanksOOP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ActionField extends JPanel {	
	
	final boolean COLORDED_MODE = false;
	private BattleField battlefield;
	private Tank tank;
	private Bullet bullet;


	void runTheGame() throws Exception {
		tank.turn(4);
		tank.move();
		tank.fire();
		tank.turn(3);
		tank.move();
		tank.fire();
		tank.turn(2);
		tank.move();
		tank.fire();
		tank.turn(1);
		tank.move();
		tank.fire();

	}	
	
	public String getQuadrant(int x, int y) {
		x /= 64; 
		y /= 64; 
		return (y + "_" + x);		
	}
	
	public String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}
	
	private boolean processInterception() {		
		String coordinates = getQuadrant(bullet.getX(), bullet.getY());
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));	
		
		if((y>=0&&y<battlefield.getBF_HEIGHT())&&(x>=0&&x<battlefield.getBF_WIDTH())){
			if(!battlefield.scanQuadrant(y, x).trim().isEmpty()){ //удаляет лишние пробелы и проверяет, что осталось
				battlefield.updateQuadrant(y, x, "");		
				bullet.destroy();
				return true;
			}	
		}
		
		return false;
	}
	
	
	public void processTurn(Tank tank) {
		// TODO Auto-generated method stub
			repaint();
	}	
	
	public void processMove(Tank tank) throws Exception {
		// TODO Auto-generated method stub
		this.tank = tank;
		int direction = tank.getDirection();
		int step = 1;
		int covered = 0;

		// check limits x: 0, 513; y: 0, 513
		if ((direction == 1 && tank.getY() == 0) || (direction == 2 && direction >= 512)
				|| (direction == 3 && tank.getX() == 0) || (direction == 4 && tank.getX() >= 512)) {
			System.out.println("[illegal move] direction: " + tank.getDirection() + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
			return;
		}
		
		tank.turn(direction);

		while (covered < 64){
			if (tank.getDirection() == 1) {
				tank.updateY(-step);
				System.out.println("[move up] direction: " + tank.getDirection() + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
			} else if (tank.getDirection() == 2) {
				tank.updateY(step);
				System.out.println("[move down] direction: "  + tank.getDirection() + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
			} else if (tank.getDirection() == 3) {
				tank.updateX(-step);
				System.out.println("[move left] direction: "  + tank.getDirection() + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
			} else {
				tank.updateX(step);
				System.out.println("[move right] direction: "  + tank.getDirection() + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
			}
			covered += step;

			repaint();
			Thread.sleep(tank.getSpeed());
		}
		
	}
	
	public void processFire(Bullet bullet) throws Exception {
		// TODO Auto-generated method stub	
			this.bullet = bullet;
			int step=1;
			int direction = bullet.getDirection();
					
			tank.turn(direction);		
			while ((bullet.getY() > -14&&bullet.getY() < 590)&&(bullet.getX() > -14&&bullet.getX() < 590)) {
				if (direction == 1) {
					bullet.updateY(-step);				
				} else if (direction == 2) {
					bullet.updateY(step);				
				} else if (direction == 3) {
					bullet.updateX(-step);			
				} else {
					bullet.updateX(step);				
				}	
				processInterception();
				repaint();
				Thread.sleep(bullet.getSpeed());		
				
			}
					
		
	}

	public ActionField() throws Exception {
		
	battlefield = new BattleField();	
	tank = new Tank(this, battlefield, 192, 128, 2);	
	bullet = new Bullet(-100, -100, tank.getDirection());
		
	JFrame frame = new JFrame("BATTLE FIELD, OOP");
	frame.setLocation(750, 150);
	frame.setMinimumSize(new Dimension(battlefield.getBF_WIDTH(), battlefield.getBF_HEIGHT() + 22));
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frame.getContentPane().add(this);
	frame.pack();
	frame.setVisible(true);
}	


	@Override
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	int i = 0;
	Color cc;
	for (int v = 0; v < 9; v++) {
		for (int h = 0; h < 9; h++) {
			if (COLORDED_MODE) {
				if (i % 2 == 0) {
					cc = new Color(252, 241, 177);
				} else {
					cc = new Color(233, 243, 255);
				}
			} else {
				cc = new Color(180, 180, 180);
			}
			i++;
			g.setColor(cc);
			g.fillRect(h * 64, v * 64, 64, 64);
		}
	}
	
	for (int j = 0; j < battlefield.getDimensionY(); j++) {
		for (int k = 0; k < battlefield.getDimensionX(); k++) {
			if (battlefield.scanQuadrant(j, k).equals("B")) {
				String coordinates = getQuadrantXY(j + 1, k + 1);
				int separator = coordinates.indexOf("_");
				int y = Integer.parseInt(coordinates.substring(0, separator));
				int x = Integer.parseInt(coordinates.substring(separator + 1));
				g.setColor(new Color(0, 0, 255));
				g.fillRect(x, y, 64, 64);
			}
		}
	}
	
	g.setColor(new Color(255, 0, 0));
	g.fillRect(tank.getX(), tank.getY(), 64, 64);
	
	g.setColor(new Color(0, 255, 0));
	if (tank.getDirection() == 1) {
		g.fillRect(tank.getX() + 20, tank.getY(), 24, 34);
	} else if (tank.getDirection() == 2) {
		g.fillRect(tank.getX() + 20, tank.getY() + 30, 24, 34);
	} else if (tank.getDirection() == 3) {
		g.fillRect(tank.getX(), tank.getY() + 20, 34, 24);
	} else {
		g.fillRect(tank.getX() + 30, tank.getY() + 20, 34, 24);
	}
	
	g.setColor(new Color(255, 255, 0));
	g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
	}

	

}
