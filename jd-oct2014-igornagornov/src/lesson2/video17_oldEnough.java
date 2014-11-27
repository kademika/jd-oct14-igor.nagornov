package lesson2;

public class video17_oldEnough {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(oldEnough(21));
		System.out.println(oldEnough(30));
		System.out.println(oldEnough(2));
		System.out.println(oldEnough(-3));		
	}
	
	static boolean oldEnough(int age){
		if(age>=21) {			
			return true;
		}
		return false;
		
	}

}
