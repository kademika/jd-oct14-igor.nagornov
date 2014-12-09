package lesson9.video11_observer_in_eclipse;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class Supervisor implements Observer{
	
	private String name;

	public Supervisor(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	@Override
	public void update(Observable o, Object event) {
		// TODO Auto-generated method stub
		if(event instanceof ActionEvent){
			System.out.println(name + " is notified," + "event - " + ((ActionEvent)event).getClass() + " " + ((ActionEvent)event).hashCode());
		}
		else{
			System.out.println(name + " is notified"); 
		}
		
		Worker w = (Worker) o;
		System.out.println("Job result by worker " + w.getName() + " - " + w.getResult() + "\n");
	}
	
	public String getName() {
		return name;
	}
	
	

}
