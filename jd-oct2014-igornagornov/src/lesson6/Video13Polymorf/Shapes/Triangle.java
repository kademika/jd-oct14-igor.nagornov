package lesson6.Video13Polymorf.Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		// System.out.println("I'm triangle"); //���� � ������� ������ ���
		// ������ ������ draw,
		// �� ��������� ��� �� ������ ���� �� ��������

		super.draw(g);
		
		//g.setColor(new Color(0, 0, 0));
		int[] x = {100,100,150};
		int[] y = {100,150,150};		
		g.drawPolygon(x,y,3);

	}

}
