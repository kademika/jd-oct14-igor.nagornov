package lesson6.Video13Polymorf.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Shape {

	public void draw(Graphics g){
		//System.out.println("My shape is undefined");
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(5)); //change line weight to 5
		
		g.setColor(new Color(0,0,255));
	}
	

}
