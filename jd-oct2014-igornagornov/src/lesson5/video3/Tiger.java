package lesson5.video3;

public class Tiger extends Tank{
	
	int armor;
	
	Tiger(int crew){
		setColor("красный");
		setCrew(crew);
		setMaxSpeed(31);
		setArmor(1);
		}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}	

}
