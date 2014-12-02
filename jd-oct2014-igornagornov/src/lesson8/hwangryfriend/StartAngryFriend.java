package lesson8.hwangryfriend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartAngryFriend extends JPanel {

	private int x = 50;
	private int y = 250;
	private boolean win = false;

	public StartAngryFriend() {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame("Angry friend");
		frame.setMinimumSize(new Dimension(400, 400));
		frame.setResizable(false);
		frame.setLocation(300, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub				
				
				if (x == e.getX() && y == e.getY()) {
					win = true;
				}
			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				Random r = new Random();
				int offsetX = r.nextInt(50);
				int offsetY = r.nextInt(50);
				
				if (offsetX < 26)
					offsetX = 26;
				if (offsetY < 26)
					offsetY = 26;
				
				int plusMinus = r.nextInt(4);

				if (plusMinus == 0) {
					x = e.getX() + offsetX;
					y = e.getY() + offsetY;
				} else if (plusMinus == 1) {
					x = e.getX() + offsetX;
					y = e.getY() - offsetY;
				} else if (plusMinus == 2) {
					x = e.getX() - offsetX;
					y = e.getY() + offsetY;
				} else {
					x = e.getX() - offsetX;
					y = e.getY() - offsetY;
				}

				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}

				repaint();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub

		super.paintComponent(g);
		
		g.setColor(Color.BLUE);
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		g.drawString("Click this ball", 100, 50);
		
		if(win){
			g.setColor(Color.red);			
			g.drawString("Congratulations! You win", 50, 50);
			return;
		}
		g.setColor(Color.RED);
		g.fillOval(x, y, 25, 25);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StartAngryFriend ms = new StartAngryFriend();

	}

}
