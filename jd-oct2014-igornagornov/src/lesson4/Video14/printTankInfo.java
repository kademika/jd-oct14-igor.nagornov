package lesson4.Video14;

import java.io.ObjectInputStream.GetField;

public class printTankInfo {

	public static void main(String[] args) {
			printAllTankInfo();

		}
		
		static void printAllTankInfo(){
			
			Tank t = new Tank();			
			
			System.out.println("Мы создали " + t.getColor() + " танк" + ", экипаж из " + t.getCrew() + " человек," +
						" максимальная скорость - " + t.getMaxSpeed());
			
			Tank t2 = new Tank("cерый", 5, 250);
			System.out.println("Мы создали " + t2.getColor() + " танк" + ", экипаж из " + t2.getCrew() + " человек," +
					" максимальная скорость - " + t2.getMaxSpeed());
		}

}
