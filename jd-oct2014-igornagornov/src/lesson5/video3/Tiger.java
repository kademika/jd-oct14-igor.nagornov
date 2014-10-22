package lesson5.video3;

public class Tiger extends Tank{
	
	private int armor;
	
	Tiger(int crew){
		setColor("красный");
		setCrew(crew);
		setMaxSpeed(31);
		setArmor(1);		

		System.out.println("Мы создали " + getColor() + " танк" + ", экипаж из " + getCrew() + " человек," +
				" максимальная скорость - " + getMaxSpeed());
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
		System.out.println("Двигаем танк " + this.toString());
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tiger";
	}
}
