package Tanks.TanksOOP.Service;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowWinnerForm extends JPanel{
	
	private Image image;
	private String result;
	
	public ShowWinnerForm(String result) {
		// TODO Auto-generated constructor stub
		this.result = result;
		
		JFrame mainFrame = new JFrame("Game over");
		mainFrame.setMinimumSize(new Dimension(450,275));
		mainFrame.setResizable(false);
		mainFrame.setLocation(550, 300);		
		mainFrame.getContentPane().add(this);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);		
		
		try {
			image = ImageIO.read(new File("winner.jpeg"));
		} catch (IOException e) {
		}
		
		if(image!=null){
			g.drawImage(image, 0, 0, new ImageObserver() {				
				@Override
				public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
						int arg4, int arg5) {
					// TODO Auto-generated method stub
					return false;
				}
			});	
		}	
		
		g.setColor(Color.RED);
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		g.drawString(result, 50, 50);
	}

}
