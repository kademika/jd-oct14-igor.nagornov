package lesson2;

public class video8_overrriding {

	static double square(double number){
		System.out.print("OVERLOADING! A number double - " + number + " in squre equals ");
		return number*number;
		
	}
	
	static double square(int number){
		System.out.print("OVERLOADING! A number int - " + number + " in squre equals ");
		return number*number;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
	    System.out.print(square(7));
	    System.out.println();
	    System.out.print(square(16.0));
	    System.out.println();
	    
	}
	
}
