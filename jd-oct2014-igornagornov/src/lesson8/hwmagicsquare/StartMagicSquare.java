package lesson8.hwmagicsquare;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartMagicSquare extends JPanel {

	private int x = 50;
	private int y = 250;

	public StartMagicSquare() {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame("Magic square");
		frame.setMinimumSize(new Dimension(400, 400));
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setLocation(300, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		
		addMouseListener(new MouseAdapter() {				
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if ((e.getX() > x && e.getX() < y + x)
						&& (e.getY() > x && e.getY() < y + x)) {
					repaint();
				}

			}
		});

		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int cR = r.nextInt(255);
		int cG = r.nextInt(255);
		int cB = r.nextInt(255);

		g.setColor(new Color(cR, cG, cB));
		g.fillRect(x, x, y, y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new StartMagicSquare();

	}

}
