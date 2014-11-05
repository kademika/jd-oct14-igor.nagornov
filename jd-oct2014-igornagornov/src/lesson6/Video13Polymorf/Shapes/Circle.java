package lesson6.Video13Polymorf.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shape{
	
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
//		System.out.println("I'm circle");//если у данного класса нет своего метода draw, 
									//он запускает его из класса выше по иерархии
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(5)); //change line weight to 5		
		
		g.setColor(color);		
		
		g.drawOval(50, 150, 50, 200);
		g.fillOval(50, 200, 50, 100);
	}

}
