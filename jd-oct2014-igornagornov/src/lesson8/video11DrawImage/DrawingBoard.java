package lesson8.video11DrawImage;

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
import javax.swing.WindowConstants;


public class DrawingBoard extends JPanel{
	
	private final String IMAGE_NAME = "image.png";
	private Image Image;
	DrawingBoard(){
		try{
			Image = ImageIO.read(new File(IMAGE_NAME));
		}catch(IOException e){
			System.err.println("Can't find image " + IMAGE_NAME);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		
		g.setColor(Color.RED);
		g.fillRect(0, 0, 350, 400);	
		
		g.setColor(Color.BLUE);
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		g.drawString("I'm just painted image!", 0, 50);
		
		g.drawImage(Image, 0, 200, new ImageObserver() {
			
			@Override
			public boolean imageUpdate(Image img, int infoflags, int x, int y,
					int width, int height) {
				// TODO Auto-generated method stub
				return false;
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Drawing text");
		frame.setLocation(500, 150);
		frame.setMinimumSize(new Dimension(350, 400));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(new DrawingBoard()); 

		frame.pack();
		frame.setVisible(true);
	}

}
