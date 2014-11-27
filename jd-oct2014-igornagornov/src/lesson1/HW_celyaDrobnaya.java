package lesson1;

public class HW_celyaDrobnaya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double value=156.32;
		String s;
				
		s = String.valueOf(value);
		System.out.println(s);
		System.out.println(s.substring(0,s.indexOf('.'))+ " " + s.substring(s.indexOf('.')+1));
		
	}
	
}
