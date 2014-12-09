package lesson9.video2adapterpattern;

public class DemoAdapterPatterd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Target target1 = new AdapterByObject();
		System.out.println(target1.newRequest());
		
		Target target2 = new AdapterByClass();
		System.out.println(target2.newRequest());
		
	}

}
