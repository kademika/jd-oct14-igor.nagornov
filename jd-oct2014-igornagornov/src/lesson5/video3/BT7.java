package lesson5.video3;

public class BT7 extends Tank{
	
	public BT7(int crew){
		setColor("blue");
		setCrew(crew);
		setMaxSpeed(72);	
		
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
		return "BT7";
	}
}
