package lesson9.video2adapterpattern;

public class AdapterByClass extends Adaptee implements Target{

	@Override
	public String newRequest() {
		// TODO Auto-generated method stub
		return oldRequest();
	}

}
