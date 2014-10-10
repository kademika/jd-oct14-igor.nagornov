package lesson2;

public class video6_square {

	static double square(double number){
		System.out.print(" вадрат числа double - " + number + " равен ");
		return number*number;
		
	}
	
//	static double square(int number){
//		System.out.print(" вадрат числа int - " + number + " равен ");
//		return number*number;
//		
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
	    System.out.print(square(7));
	    System.out.println();
	    System.out.print(square(16.0));
	    System.out.println();
	    
	}

}
