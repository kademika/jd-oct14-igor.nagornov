package lesson5.video3;

public class PrintTankInfo {

	public static void main(String[] args) {
			printAllTankInfo();

		}
		
		private static void printAllTankInfo(){
			
			Tank t = new Tank();			
			
			System.out.println("Мы создали " + t.getColor() + " танк" + ", экипаж из " + t.getCrew() + " человек," +
						" максимальная скорость - " + t.getMaxSpeed());
			
			BT7 t2 = new BT7(3);
			System.out.println("Мы создали " + t2.getColor() + " танк" + ", экипаж из " + t2.getCrew() + " человек," +
					" максимальная скорость - " + t2.getMaxSpeed());
			
			T34 t3 = new T34(6);
			System.out.println("Мы создали " + t3.getColor() + " танк" + ", экипаж из " + t3.getCrew() + " человек," +
					" максимальная скорость - " + t3.getMaxSpeed());
			
			Tiger t4 = new Tiger(4);
			System.out.println("Мы создали " + t4.getColor() + " танк" + ", экипаж из " + t4.getCrew() + " человек," +
					" максимальная скорость - " + t4.getMaxSpeed() +  ", степень тяжести брони - " + t4.getArmor());
			
			
		}

}
