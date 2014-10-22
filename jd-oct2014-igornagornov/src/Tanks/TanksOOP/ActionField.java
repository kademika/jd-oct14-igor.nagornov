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


	void runTheGame() throws Exception {
		while(true){
			tank.clean();		
		}	

	}	
	
	public String getQuadrant(int x, int y) {
		x /= 64; 
		y /= 64; 
		return (y + "_" + x);		
	}
	
	public String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
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

			if(tank.isCollision()) tank.fire();
			repaint();
			Thread.sleep(tank.getSpeed());
		}
		
	}
	
	public void processMoveToQuadrant(Tank tank, int v, int h) throws Exception 
	{
		String coordinates = getQuadrantXY(v, h);
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));

		
		if (tank.getX() < x ) {
			while (tank.getX() != x) {
				tank.turn(4);
				tank.move();				
				
			}
		} else {
			while (tank.getX() != x) {
				tank.turn(3);
				tank.move();
			}
		}

		if (tank.getY() < y) {
			while (tank.getY() != y) {
				tank.turn(2);
				tank.move();
			}
		} else {
			while (tank.getY() != y) {
				tank.turn(1);
				tank.move();
			}
		}
	}
	
	public void processMoveRandom(Tank tank) throws Exception{ //������� ���� �� ���� �������� � ��������� �����������
		// TODO Auto-generated method stub		
		
			Random r = new Random();
			int i;
			while (true) {
				i = r.nextInt(5);
				if (i > 0) {
					tank.turn(r.nextInt(5));
					tank.move();
					tank.fire();					
				}
			}
		}
	
	
	public void processMoveToRandomQuadrant(Tank tank) throws Exception{ //������� ���� � ��������� ��������
		Random r = new Random();		
		
		 int i = r.nextInt(9);
		 int j = r.nextInt(9);
		 
		 if(i!=0&&j!=0){
			 processMoveToQuadrant(tank, i, j);		
			 Thread.sleep(1000);	 
		 }		
		
	}
	
	void processClean(Tank tank) throws Exception { // ���� ���� ������� � �������� ���������, ���������� �� �� ���� ������������
		int step = 64, x, y, dist1=512, dist2=512, dist3=512, dist4=512, min=512;	
															//���� �������� � ��������� ������
																	//����� ����������� ���� �������� � �������� ���������
																		//���� ���� � ��������� ��������
				x=tank.getX(); y=tank.getY();
				while(y > 0){
					y -= step;					
					if(!quadrantIsEmpty(tank.getX(), y)){
						dist1=tank.getY() - y - 64;							
						break;
					} 				
				}
			
				x=tank.getX(); y=tank.getY();
				while(y < 512){					
					y += step;						
					if(!quadrantIsEmpty(tank.getX(), y)){
						dist2=y-tank.getY() - 64;							
						break;
					}
			}
			
				x=tank.getX(); y=tank.getY();
				while(x > 0){					
					x -= step;					
					if(!quadrantIsEmpty(x, tank.getY())){
						dist3=tank.getX() - x - 64;						
						break;						
					}
				}
			
				x=tank.getX(); y=tank.getY();
				while(x < 512){						
					x += step;					
					if(!quadrantIsEmpty(x, tank.getY())){
						dist4=x - tank.getX() - 64;							
						break;
					}
				}				

				int[] temp = {dist1,dist2,dist3,dist4};
				 
				int direction=1;
				
				for(int i=0; i<temp.length; i++){					
					if(temp[i]<min) {
						min=temp[i];
						direction=i+1;
					}
				}
				
				if(min==512) {
					tank.moveToRandomQuadrant();;
					return;				
				}
				tank.turn(direction);	
				tank.fire();				
		
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
	
	
	public boolean processInterception() {		// ������� ��������� ������������ ���� � ������������, ���� ��, �� ������ ����������
		String coordinates = getQuadrant(bullet.getX(), bullet.getY());
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));	
		
		if((y>=0&&y<battlefield.getDimensionY())&&(x>=0&&x<battlefield.getDimensionX())){
			if(!battlefield.scanQuadrant(y, x).trim().isEmpty()){ 		//������� ������ ������� � ���������, ��� ��������
				battlefield.updateQuadrant(y, x, "");		
				bullet.destroy();
				return true;
			}	
		}
		
		return false;
	}
	
	public boolean processCollision(Tank tank) {	//���������, ���������� �� ���� � ������������ �� ����������� ��������	
		String coordinates;
		
		if ((tank.getDirection() == 1 && tank.getY()  != 0) || (tank.getDirection() == 2 && tank.getY()  < 512)
				|| (tank.getDirection() == 3 && tank.getX()  != 0) || (tank.getDirection() == 4 && tank.getX()  < 512)){
			if (tank.getDirection() == 1||tank.getDirection() == 3) {
				coordinates = getQuadrant(tank.getX() , tank.getY() );				
			} else if (tank.getDirection() == 2) {
				coordinates = getQuadrant(tank.getX() , tank.getY() + 64);								
			} else {
				coordinates = getQuadrant(tank.getX() + 64, tank.getY() );				
			}	
		}else return false;
		
		
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));	
		
		if((y>=0&&y<battlefield.getDimensionY())&&(x>=0&&x<battlefield.getDimensionX())){
			if(!battlefield.scanQuadrant(y, x).trim().isEmpty()){ 		//������� ������ ������� � ���������, ��� ��������				
				return true;
			}	
		}
		
		return false;
	}
	
	
	private boolean quadrantIsEmpty(int cX, int cY) { // ��������� ���� �� ��������� ��������
		String coordinates;
		coordinates = getQuadrant(cX, cY);	
		
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator)); 
		int x = Integer.parseInt(coordinates.substring(separator + 1));	
		
		if((y>=0&&y<battlefield.getDimensionY())&&(x>=0&&x<battlefield.getDimensionX())){
			if(!battlefield.scanQuadrant(y, x).trim().isEmpty()){ //������� ������ ������� � ���������, ��� ��������				
				return false;
			}	
		}		
		return true;
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

	


