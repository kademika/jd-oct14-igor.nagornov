package lesson9.video8observerpattern;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

	List<Observer> observers;

	public ConcreteSubject() {
		// TODO Auto-generated constructor stub
		observers = new ArrayList<>();
	}

	public void doTheJob() {
		double d = Math.random();
		if (d < 0.5 || d > 10.5) {
			System.out.println("Job is done");
			notifyObservers();
		}else{
			System.out.println("Job is failed");
		}
	}

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Observer o : observers) {
			o.update();
		}
	}

}
