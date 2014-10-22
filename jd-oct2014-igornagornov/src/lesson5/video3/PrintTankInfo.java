package lesson5.video3;

public class PrintTankInfo {

	public static void main(String[] args) {
			printAllTankInfo();

		}
		
		private static void printAllTankInfo(){
			
			Tank t = new Tank();
			System.out.println("Мы создали " + t.getColor() + " танк" + ", экипаж из " + t.getCrew() + " человек," +
					" максимальная скорость - " + t.getMaxSpeed());
			t.move();
			
			BT7 t2 = new BT7(3);			
			t2.move();
			
			T34 t3 = new T34(6);			
			t3.move();
			
			Tiger t4 = new Tiger(4);			
			t4.move();			
			
			
		}

}
