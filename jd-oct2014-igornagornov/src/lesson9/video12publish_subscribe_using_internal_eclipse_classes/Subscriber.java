package lesson9.video12publish_subscribe_using_internal_eclipse_classes;

import java.util.Observable;
import java.util.Observer;

public class Subscriber implements Observer{

	private String name;
	
	public Subscriber(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}	
	
	public String getName() {
		return name;
	}

	@Override
	public void update(Observable object, Object event) {
		// TODO Auto-generated method stub
		System.out.println("Subscriber " + this.name + " is notified, that there is new release of " + ((Newspaper)object).getName());
	}

}
