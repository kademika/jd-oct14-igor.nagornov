package lesson8.video9TextOnPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class DemoTextOnPanel extends JPanel{	

	public DemoTextOnPanel() {				
	}	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		g.fillRect(0, 0, 300, 400);
		
		g.setColor(new Color(34,174,93));
		g.draw3DRect(100, 100, 50,50, true); //riseem vipukliy kvadrat
		
		g.setColor(Color.BLUE);
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		g.drawString("Hello world!", 50, 50);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
				
		JFrame frame = new JFrame("Drawing text");
		frame.setLocation(500, 150);
		frame.setMinimumSize(new Dimension(300, 400));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(new DemoTextOnPanel()); 

		frame.pack();
		frame.setVisible(true);
	}


}
