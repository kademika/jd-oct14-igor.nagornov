package lesson5.video3;

public class T34 extends Tank{

	public T34(int crew){
		setColor("желтый");
		setCrew(crew);
		setMaxSpeed(50);	
		
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
		return "T34";
	}
	
}
