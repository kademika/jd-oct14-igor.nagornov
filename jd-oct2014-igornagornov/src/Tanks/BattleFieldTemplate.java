package Tanks;
/*
 * Copyright (c) 2014 kademika.com
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class BattleFieldTemplate extends JPanel {

	boolean COLORDED_MODE = true;
	
	
	// 1 - вверх, 2 - вниз, 3 - влево, 4 - вправо 
	static int tankDirection;
	
	int tankX = 0;
	int tankY = 0;
	Random r = new Random();
		
	int bulletX = -100;
	int bulletY = -100;
	
	int speed = 10;
	int bulletSpeed = 5;

	String[][] battleField = {
			{" ", " ", " ", "B", "B", "B", " ", " ", " "},
			{"B", " ", " ", " ", "B", " ", " ", " ", "B"},
			{"B", "B", " ", " ", "B", " ", " ", "B", "B"},
			{"B", "B", "B", " ", " ", " ", "B", "B", "B"},
			{"B", "B", "B", " ", " ", " ", "B", "B", "B"},
			{"B", "B", " ", " ", "B", " ", " ", "B", "B"},
			{"B", " ", " ", " ", "B", " ", " ", " ", "B"},
			{"B", " ", " ", "B", "B", "B", " ", " ", "B"},
			{" ", " ", " ", "B", "B", "B", " ", " ", " "}
		};
	
	
	void runTheGame() throws Exception {
	  System.out.println("Координаты танка : TankX - " + tankX + 
				   ", TankY - " + tankY);  
	  repaint();	
	  Thread.sleep(speed);	
	  moveToQuadrant(1, 3);	 
	  Thread.sleep(2000);
	  moveToQuadrant(2, 2);
	  Thread.sleep(2000);
	  moveToQuadrant(3, 5);
	  Thread.sleep(2000);
	  moveToQuadrant(9, 9);
	  Thread.sleep(2000);
	  
//	  while(true){
//		 move(r.nextInt(5));  
//		 
//	  }  	  
	 
	  
	}
	
	void move(int direction) throws InterruptedException {
		
		int step=1;
		int covered=0;
		
		turn(direction);
		
		for(; covered<64; covered++)			
		{
		 if(direction>0&&direction<5){	
		  switch (direction){
		   case 1:{
			   
			   if(tankY==0){
				   System.out.println("Движение вверх невозможно");
				   break;
			   }
			    tankY-=step;
			    System.out.println("Направление " + direction + ", " + "координаты танка : TankX - " + tankX + 
						   ", TankY - " + tankY);
			    repaint();	
				Thread.sleep(speed);				
			    break;
		   }
		  
		   case 2:{
			   
			   if(tankY>=512){
				   System.out.println("Движение вниз невозможно");
				   break;
			   }
			   tankY+=step;	
			   System.out.println("Направление " + direction + ", " + "координаты танка : TankX - " + tankX + 
					   ", TankY - " + tankY);
			   repaint();
			   Thread.sleep(speed);			   
			   break;  
		   }
		  
		   case 3:{
			   
			   if(tankX==0){
				   System.out.println("Движение влево невозможно");
				   break;
			   }
			    tankX-=step;
				System.out.println("Направление " + direction + ", " + "координаты танка : TankX - " + tankX + 
						   ", TankY - " + tankY);
			    repaint();	
				Thread.sleep(speed);
			   break;   
		   }			   
		  
		   case 4:{
			   
			   if(tankX>=512){
				   System.out.println("Движение вправо невозможно");
				   break;
			   }
			   tankX+=step;	
			   System.out.println("Направление " + direction + ", " + "координаты танка : TankX - " + tankX + 
					   ", TankY - " + tankY);
			   repaint();	
			   Thread.sleep(speed);
			   break;   
		  }		   
		 }
		}  			
	   }		
	}

	
	static void turn(int direction){
		if(tankDirection!= direction) tankDirection = direction;
	}
	
	static int[] getQuadrant(int v, int h){
		int[] coordinates = new int [2];
		coordinates[0] = (v-1)*64;
		coordinates[1] = (h-1)*64;
		
		return coordinates;		
	}
	
	void moveToQuadrant(int v, int h)
	{
		int x,y;
				
		x = getQuadrant(v, h)[0];
		y = getQuadrant(v, h)[1];
		
		System.out.println("Передвигаем танк в квадрант " + v + ":" + h + " c координатами " + x + " "+ y);
		
		
		while(x>tankX){
			try {
				move(4);
			} catch (InterruptedException e) {}
		}
		while(y>tankY){
			try {
				move(2);
			} catch (InterruptedException e) {}
		}
		while(x<tankX){
			try {
				move(3);
			} catch (InterruptedException e) {}
		}	
		while(y<tankY){
			try {
				move(1);
			} catch (InterruptedException e) {}
		}	
		
	}

//void moveToQuadrant(String v, String h) 
//{
//	int x,y;
//	String temp = getQuadrant(v, h);
//	
//	x = Integer.parseInt(temp.substring(0, temp.indexOf("_")));
//	y = Integer.parseInt(temp.substring(temp.indexOf("_")+1));
//	
//	System.out.println("Передвигаем танк в квадрант " + v + h + " c координатами " + x + " "+ y);
//	
//	
//	while(x>tankX){
//		try {
//			move(4);
//		} catch (InterruptedException e) {}
//	}
//	while(y>tankY){
//		try {
//			move(2);
//		} catch (InterruptedException e) {}
//	}
//	while(x<tankX){
//		try {
//			move(3);
//		} catch (InterruptedException e) {}
//	}	
//	while(y<tankY){
//		try {
//			move(1);
//		} catch (InterruptedException e) {}
//	}	
//	
//}

//	 static String getQuadrant(String v, String h)	{
//	
//	 String s1="abcdefghi";
//	 String s2="123456789";
//	 String result=null;
//	 int x,y;
//	
//	 if(s1.contains(v)&&s2.contains(h))
//	 {
//		x=s1.indexOf(v)*64;
//		y=s2.indexOf(h)*64;
//		result = x + "_" + y; 					
//	 }	
//	 return result;
//	
//}
	
	/*	
	void moveRandom() throws InterruptedException {
		long random;
		int direction;
		
		random = System.currentTimeMillis()%5;		
		
		if(random==0) return;	
		
		direction = Integer.parseInt(String.valueOf(random));	
		System.out.println(direction);
		
			int step=64;
			  switch (direction){
			   case 1:{
				   
				   if(tankY==0){
					   System.out.println("Движение вверх невозможно");
					   break;
				   }
				    tankY-=step;
				    repaint();	
					Thread.sleep(speed);
					
				   break;
			   }
			  
			   case 2:{
				   
				   if(tankY>=512){
					   System.out.println("Движение вниз невозможно");
					   break;
				   }
				   tankY+=step;					
				   repaint();	
					Thread.sleep(speed);
				   break;  
			   }
			  
			   case 3:{
				   
				   if(tankX==0){
					   System.out.println("Движение влево невозможно");
					   break;
				   }
				    tankX-=step;					
				    repaint();	
					Thread.sleep(speed);	
				   break;   
			   }			   
			  
			   case 4:{
				   
				   if(tankX>=512){
					   System.out.println("Движение вправо невозможно");
					   break;
				   }
				   tankX+=step;			   
				   repaint();	
					Thread.sleep(speed);
				   break;   
			   }
			  }				
				
		} */
	
	
	// Magic bellow. Do not worry about this now, you will understand everything in this course.
	// Please concentrate on your tasks only.

	final int BF_WIDTH = 576;
	final int BF_HEIGHT = 576;
	
	public static void main(String[] args) throws Exception {
		BattleFieldTemplate bf = new BattleFieldTemplate();
		bf.runTheGame();
	}

	public BattleFieldTemplate() throws Exception {
		JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
		frame.setLocation(500, 150);
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
		
		g.setColor(new Color(255, 0, 0));
		g.fillRect(tankX, tankY, 64, 64);
	}

}
