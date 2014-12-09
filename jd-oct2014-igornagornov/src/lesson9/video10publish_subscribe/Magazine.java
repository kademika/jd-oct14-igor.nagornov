package lesson9.video10publish_subscribe;

import java.util.ArrayList;
import java.util.List;


public class Magazine implements SubjectActions{
	
	static List<Observer> observers = new ArrayList<>();
	
	public Magazine() {
		// TODO Auto-generated constructor stub
		System.out.println("New magazine publication");
		notifyObservers();
		System.out.println();
	}
	

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer o: observers){
			o.update();
		}
	}
	

}
