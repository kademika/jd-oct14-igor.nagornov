package lesson6.Video13Polymorf.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shape{
	
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
//		System.out.println("I'm circle");//���� � ������� ������ ��� ������ ������ draw, 
									//�� ��������� ��� �� ������ ���� �� ��������
		
		super.draw(g);		
		
		g.drawOval(50, 150, 50, 200);
		g.fillOval(50, 200, 50, 100);
	}

}
