package lesson6.Video13Polymorf.Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
//		System.out.println("I'm rectangle");//если у данного класса нет своего метода draw, 
										//он запускает его из класса выше по иерархии
		
		super.draw(g);
		
		//g.setColor(new Color(0,255,255));
		g.drawRect(150, 200, 100, 50);
		g.fillRect(150, 200, 50, 50);
	}
}
