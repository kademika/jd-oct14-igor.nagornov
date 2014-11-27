package lesson4.Video14;

import java.io.ObjectInputStream.GetField;

public class printTankInfo {

	public static void main(String[] args) {
			printAllTankInfo();

		}
		
		static void printAllTankInfo(){
			
			Tank t = new Tank();			
			
			System.out.println("We have created " + t.getColor() + " tank" + ", crew is " + t.getCrew() + " people," +
						" max speed - " + t.getMaxSpeed());
			
			Tank t2 = new Tank("grey", 5, 250);
			System.out.println("We have created " + t2.getColor() + " tank" + ", crew is  " + t2.getCrew() + " people," +
					" max speed  - " + t2.getMaxSpeed());
		}

}
