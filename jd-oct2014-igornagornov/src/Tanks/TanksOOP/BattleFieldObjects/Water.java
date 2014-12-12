package Tanks.TanksOOP.BattleFieldObjects;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import Tanks.TanksOOP.Service.LoadImages;

public class Water extends BFObject{

	public Water(int x, int y) {		
		// TODO Auto-generated constructor stub
		super(x, y);
		color = new Color(0, 150, 255);
		
		image = LoadImages.getWater();
	}	
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub		
		
		Graphics2D g2D = (Graphics2D) g;
		Composite org = g2D.getComposite();
		Composite translucent = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
		g2D.setComposite(translucent);
		g.drawImage(image, getX(), getY(), getX()+64, getY()+64, getX(), getY(), getX()+64, getY()+64, imageObserver);
		g2D.setComposite(org);
		
	}

}
