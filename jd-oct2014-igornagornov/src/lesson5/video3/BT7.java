package lesson5.video3;

public class BT7 extends Tank{
	
	public BT7(int crew){
		setColor("синий");
		setCrew(crew);
		setMaxSpeed(72);	
		
		System.out.println("Мы создали " + getColor() + " танк" + ", экипаж из " + getCrew() + " человек," +
				" максимальная скорость - " + getMaxSpeed());
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Двигаем танк " + this.toString());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BT7";
	}
}
