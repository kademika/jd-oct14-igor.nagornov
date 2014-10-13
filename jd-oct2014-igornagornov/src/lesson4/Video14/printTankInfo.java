package lesson4.Video14;

public class printTankInfo {

	public static void main(String[] args) {
			printAllTankInfo();

		}
		
		static void printAllTankInfo(){
			
			Tank t = new Tank();
			t.color = "черный";
			t.crew = 3 ;
			t.maxSpeed = 100;
			
			System.out.println("Мы создали " + t.color + " танк" + ", экипаж из " + t.crew + " человек," +
						" максимальная скорость - " + t.maxSpeed);
			
			Tank t2 = new Tank("cерый", 5, 150);
			System.out.println("Мы создали " + t2.color + " танк" + ", экипаж из " + t2.crew + " человек," +
					" максимальная скорость - " + t2.maxSpeed);
		}

}
