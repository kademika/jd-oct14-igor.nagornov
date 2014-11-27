package lesson8.video4Window;

import java.awt.Dimension;

import javax.swing.JFrame;

public class DemonstrateWindow extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame();
		
		frame.setMinimumSize(new Dimension(800,600));
		frame.setLocation(300, 100);
		frame.pack(); //pereshitivaet minimalniy razmer okna, proveryaet vse li komponenti umestilis' v okne
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
