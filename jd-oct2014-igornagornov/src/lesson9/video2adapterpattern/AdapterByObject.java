package lesson9.video2adapterpattern;

public class AdapterByObject implements Target{
	
	Adaptee a;
	
	public AdapterByObject() {
		// TODO Auto-generated constructor stub
		a = new Adaptee();
	}

	@Override
	public String newRequest() {
		// TODO Auto-generated method stub
		return a.oldRequest();
	}
	
	

}
