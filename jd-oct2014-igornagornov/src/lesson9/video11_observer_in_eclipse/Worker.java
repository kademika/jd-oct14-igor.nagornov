package lesson9.video11_observer_in_eclipse;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Random;

public class Worker extends Observable{

	private String result;
	private String name;	

	public Worker(String name) {
		
		this.name = name;	
		
	}
	
	public String doJob(){		
	
		Random r = new Random();
		int i = r.nextInt(3);
		switch (i) {
		
			case 0: {
				result = "Worker has worked awful";
				setChanged(); //esli ne sdelat' setChanges, to pri notifyObservers yichego ne proizoidet
				notifyObservers();
				break;
			}
			case 1: {
				result = "Worker has worked bad";
				setChanged();
				notifyObservers();
				break;
			}
			case 2: {
				result = "Worker has worked good";
				setChanged();
				notifyObservers(new ActionEvent(i, i, name));
				break;
			}
		}
		
		return result;
	}

	public String getResult() {
		return result;
	}
	
	public String getName() {
		return name;
	}

}
