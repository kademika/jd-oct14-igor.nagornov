package lesson6.Video13Polymorf.Shapes;

import java.awt.Graphics;

public class Square extends Rectangle{
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub		
		
		int width = 150;
		g.drawRect(300, 200, width, width);
	}

}
