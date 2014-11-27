package lesson5.Video29DarkZone;

public class DarkZone {


	public static void darkZone(double monthlyPayment, int interest, int dreamSum) {
		int numberOfMonth = 0;
		double procent = interest / 12;
		double currentMonthlyPayment = monthlyPayment;

		while (currentMonthlyPayment < dreamSum) {

			
//			System.out.format("%.3f%n", currentMonthlyPayment);	
//			System.out.println(numberOfMonth);

			currentMonthlyPayment = currentMonthlyPayment
					+ (currentMonthlyPayment * procent) / 100;
			currentMonthlyPayment += monthlyPayment;
			numberOfMonth++;

		}		
		
		
		System.out.println("It takes " + numberOfMonth/12 + " years and " + numberOfMonth%12 + " month");
		

	}


}
