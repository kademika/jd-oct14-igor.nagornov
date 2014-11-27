package lesson5.video3;

import java.io.ObjectInputStream.GetField;

public class Tank {

	private String color;
	private int crew;
	private int maxSpeed;	
	
	public Tank(){
		this("black", 2, 100);			
	}
	
	public Tank(String color, int crew, int maxSpeed){
		setColor(color);
		setCrew(crew);
		setMaxSpeed(maxSpeed);			
	}

	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCrew() {
		return crew;
	}

	public void setCrew(int crew) {
		this.crew = crew;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		if(maxSpeed>200){
			this.maxSpeed=200;
		}
		else{
			this.maxSpeed = maxSpeed;
		}
	}
	
	public void move(){
		System.out.println("Move tank " + this.toString());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "default";
	}
	
}

