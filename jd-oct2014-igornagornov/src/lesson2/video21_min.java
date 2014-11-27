package lesson2;

public class video21_min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(min(-2, 1, 13));
		System.out.println(min(3, 90, -1));
		System.out.println(min(55, 20, 13));
		System.out.println(min(100, 2, 3));
		System.out.println(min(90, 100, 101));
	}

	static int min(int n1, int n2, int n3) {

		if (n1 < n2) {
			if (n1 < n3) return n1;			
		} else if (n2 < n3) {
			return n2;
		}
		return n3;
    
	}
	
}
