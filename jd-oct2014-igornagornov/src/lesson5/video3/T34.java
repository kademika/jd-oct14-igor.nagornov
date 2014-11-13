package lesson5.video3;

public class T34 extends Tank{

	public T34(int crew){
		setColor("yellow");
		setCrew(crew);
		setMaxSpeed(50);	
		
		System.out.println("We have created " + getColor() + " tank" + ", crew is " + getCrew() + " people," +
				" max speed - " + getMaxSpeed());
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Move tank " + this.toString());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "T34";
	}
	
}
