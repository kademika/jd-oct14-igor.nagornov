package lesson6.Video13Polymorf.Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
//		System.out.println("I'm rectangle");//���� � ������� ������ ��� ������ ������ draw, 
										//�� ��������� ��� �� ������ ���� �� ��������		
		
		
		g.setColor(color);
		g.drawRect(150, 200, 100, 50);
		g.fillRect(150, 200, 50, 50);
	}
}
