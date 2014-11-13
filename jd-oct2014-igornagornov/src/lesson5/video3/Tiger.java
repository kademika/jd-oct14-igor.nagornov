package lesson5.video3;

public class Tiger extends Tank{
	
	private int armor;
	
	Tiger(int crew){
		setColor("red");
		setCrew(crew);
		setMaxSpeed(31);
		setArmor(1);		

		System.out.println("We have created " + getColor() + " tank" + ", crew is " + getCrew() + " people," +
				" max speed - " + getMaxSpeed() + ", armor is - " + getArmor());
		}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}	
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Move tank " + this.toString());
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tiger";
	}
}
