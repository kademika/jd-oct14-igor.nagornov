package lesson8.video7JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class HowToDraw extends JPanel {

	static int x = 100;

	public HowToDraw() {

		JFrame frame = new JFrame("How to draw, DAY 8");
		frame.setLocation(500, 150);
		frame.setMinimumSize(new Dimension(300, 400));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this); // dobavlyaet sosdanniy frame v contentPane i zapuskaet repaint
											// ContentPane
		frame.pack(); 
		frame.setVisible(true);		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g); // esli ne zapustit' super, to narisuetsya poverh narisovannogo 
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 300, 400);
		g.setColor(Color.YELLOW);
		g.fillOval(50, 100, x, x);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		HowToDraw htd = new HowToDraw();		
		Thread.sleep(3000);
		
		x=200;
		htd.repaint(); //pererisovivaem i poluchaem druguyu kartinu, poskolku x izmenilsya

	}

}
