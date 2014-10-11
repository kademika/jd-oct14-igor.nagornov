package Tanks;
/*
 * Copyright (c) 2013 midgardabc.com
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @version 3.0
 */
public class BattleFieldTemplate2 extends JPanel {

	final boolean COLORDED_MODE = false;
	
	final int BF_WIDTH = 576;
	final int BF_HEIGHT = 576;
	
	// 1 - top, 2 - bottom, 3 - left, 4 - right
	int tankDirection = 1;

	int tankX = 192;
	int tankY = 128;
	
	int bulletX = -100;
	int bulletY = -100;
	
	int speed = 10;
	int bulletSpeed = 5;

	String[][] battleField = {
			{" ", " ", " ", "B", "B", "B", " ", " ", " "},
			{"B", " ", " ", " ", "B", " ", " ", " ", "B"},
			{"B", "B", " ", " ", " ", " ", " ", "B", "B"},
			{"B", "B", "B", " ", " ", " ", "B", "B", "B"},
			{"B", "B", "B", " ", " ", " ", "B", "B", "B"},
			{"B", "B", " ", " ", "B", " ", " ", "B", "B"},
			{"B", " ", " ", " ", "B", " ", " ", " ", "B"},
			{"B", " ", " ", "B", "B", "B", " ", " ", "B"},
			{" ", " ", " ", "B", "B", "B", " ", " ", " "}
		};

	/**
	 * Write your code here.
	 */
	void runTheGame() throws Exception {
				
//		moveRandom();
		
//		moveToRandomQuadrant();
		
		while(true){
			clean();
		}		
		
		
		
	}
	
	boolean processInterception() {		
		String coordinates = getQuadrant(bulletX, bulletY);
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));	
		
		if((y>=0&&y<battleField.length)&&(x>=0&&x<battleField.length)){
			if(!battleField[y][x].trim().isEmpty()){ //удаляет лишние пробелы и проверяет, что осталось
				battleField[y][x]="";		
				bulletX = -100; bulletY = -100;
				return true;
			}	
		}
		
		return false;
	}
	
	boolean processJam() {		
		String coordinates;
//		coordinates = getQuadrant(tankX, tankY);
		
		if ((tankDirection == 1 && tankY != 0) || (tankDirection == 2 && tankY < 512)
				|| (tankDirection == 3 && tankX != 0) || (tankDirection == 4 && tankX < 512)){
			if (tankDirection == 1||tankDirection == 3) {
				coordinates = getQuadrant(tankX, tankY);				
			} else if (tankDirection == 2) {
				coordinates = getQuadrant(tankX, tankY+64);								
			} else {
				coordinates = getQuadrant(tankX+64, tankY);				
			}	
		}else return false;
		
		
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));	
		
		if((y>=0&&y<battleField.length)&&(x>=0&&x<battleField.length)){
			if(!battleField[y][x].trim().isEmpty()){ //удаляет лишние пробелы и проверяет, что осталось				
				return true;
			}	
		}
		
		return false;
	}
	
	String getQuadrant(int x, int y) {
		x /= 64; 
		y /= 64; 
		return (y + "_" + x);		
	}
	
	String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}
	
	void fire() throws Exception {
		int step=1;
				
		turn(tankDirection);
		bulletX = tankX + 25;
		bulletY = tankY + 25;
		while ((bulletY > -14&&bulletY < 590)&&(bulletX > -14&&bulletX < 590)) {
			if (tankDirection == 1) {
				bulletY -= step;				
			} else if (tankDirection == 2) {
				bulletY += step;				
			} else if (tankDirection == 3) {
				bulletX -= step;				
			} else {
				bulletX += step;				
			}	
			processInterception();
			repaint();
			Thread.sleep(bulletSpeed);		
			
		}
		
		
	}	
	
	void move(int direction) throws Exception {
		int step = 1;
		int covered = 0;

		// check limits x: 0, 513; y: 0, 513
		if ((direction == 1 && tankY == 0) || (direction == 2 && tankY >= 512)
				|| (direction == 3 && tankX == 0) || (direction == 4 && tankX >= 512)) {
			System.out.println("[illegal move] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
			return;
		}
		
		turn(direction);

		while (covered < 64){
			if (direction == 1) {
				tankY -= step;
				System.out.println("[move up] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
			} else if (direction == 2) {
				tankY += step;
				System.out.println("[move down] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
			} else if (direction == 3) {
				tankX -= step;
				System.out.println("[move left] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
			} else {
				tankX += step;
				System.out.println("[move right] direction: " + direction + " tankX: " + tankX + ", tankY: " + tankY);
			}
			covered += step;

			if(processJam()) fire();
			repaint();
			Thread.sleep(speed);
		}
	}

	
	void turn(int direction) {
		if (tankDirection != direction) {
			tankDirection = direction;
			repaint();
		}
	}
	
	void moveRandom() throws Exception { 
		Random r = new Random();
		int i;
		while (true) {
			i = r.nextInt(5);
			if (i > 0) {
				move(i);
				turn(r.nextInt(5));								
			}
		}
	}
	
	void moveToRandomQuadrant() throws Exception{
		Random r = new Random();		
		
		 int i = r.nextInt(9);
		 int j = r.nextInt(9);
		 
		 if(i!=0&&j!=0){
			 moveToQuadrant(i, j);		
			 Thread.sleep(1000);	 
		 }	
		
		
	}
	
	void moveToQuadrant(int v, int h) throws Exception {
		String coordinates = getQuadrantXY(v, h);
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));

		
		if (tankX < x ) {
			while (tankX != x) {				
				move(4);				
				
			}
		} else {
			while (tankX != x) {
				move(3);
			}
		}

		if (tankY < y) {
			while (tankY != y) {
				move(2);
			}
		} else {
			while (tankY != y) {
				move(1);
			}
		}
	}
	
	void clean() throws Exception {
		int step = 64, x, y, dist1=512, dist2=512, dist3=512, dist4=512, min=512;	
				
		
				x=tankX; y=tankY;
				while(y > 0){
					y -= step;					
					if(!isEmpty(tankX, y)){
						dist1=tankY-y-64;							
						break;
					} 				
				}
			
				x=tankX; y=tankY;
				while(y < 512){					
					y += step;						
					if(!isEmpty(tankX, y)){
						dist2=y-tankY-64;							
						break;
					}
			}
			
				x=tankX; y=tankY;
				while(x > 0){					
					x -= step;					
					if(!isEmpty(x, tankY)){
						dist3=tankX - x - 64;						
						break;						
					}
				}
			
				x=tankX; y=tankY;
				while(x < 512){						
					x += step;					
					if(!isEmpty(x, tankY)){
						dist4=x- tankX - 64;							
						break;
					}
				}
				
				
// 				System.out.println(dist1);
// 				System.out.println(dist2);
//				System.out.println(dist3);
//				System.out.println(dist4);
				int[] temp = {dist1,dist2,dist3,dist4};
				 
				int direction=1;
				
				for(int i=0; i<temp.length; i++){					
					if(temp[i]<min) {
						min=temp[i];
						direction=i+1;
					}
				}
				
				if(min==512) {
					moveToRandomQuadrant();
					return;				
				}
				turn(direction);	
				fire();				
		
	}
	
	boolean isEmpty(int cX, int cY) {		
		String coordinates;
		coordinates = getQuadrant(cX, cY);	
		
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator)); 
		int x = Integer.parseInt(coordinates.substring(separator + 1));	
		
		if((y>=0&&y<battleField.length)&&(x>=0&&x<battleField.length)){
			if(!battleField[y][x].trim().isEmpty()){ //удаляет лишние пробелы и проверяет, что осталось				
				return false;
			}	
		}		
		return true;
	}

	// Magic bellow. Do not worry about this now, you will understand everything in this course.
	// Please concentrate on your tasks only.
	
	
	public static void main(String[] args) throws Exception {
		BattleFieldTemplate2 bf = new BattleFieldTemplate2();
		bf.runTheGame();
	}

	public BattleFieldTemplate2() throws Exception {
		JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
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
		
		for (int j = 0; j < battleField.length; j++) {
			for (int k = 0; k < battleField.length; k++) {
				if (battleField[j][k].equals("B")) {
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
		g.fillRect(tankX, tankY, 64, 64);
		
		g.setColor(new Color(0, 255, 0));
		if (tankDirection == 1) {
			g.fillRect(tankX + 20, tankY, 24, 34);
		} else if (tankDirection == 2) {
			g.fillRect(tankX + 20, tankY + 30, 24, 34);
		} else if (tankDirection == 3) {
			g.fillRect(tankX, tankY + 20, 34, 24);
		} else {
			g.fillRect(tankX + 30, tankY + 20, 34, 24);
		}
		
		g.setColor(new Color(255, 255, 0));
		g.fillRect(bulletX, bulletY, 14, 14);
	}

}
