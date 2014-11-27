package lesson4.Video25;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reference r1 = new Reference("r1");
		Reference r2 = new Reference("r2");
		Reference r3 = new Reference("r3");
		
		r1.setRef(r2);
		r2.setRef(r3);
		r3.setRef(r1);
		
		r1.printRef();
		r2.printRef();
		r3.printRef();		
		
	}	

}
