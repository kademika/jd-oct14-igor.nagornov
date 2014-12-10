package lesson9.video12publish_subscribe_using_internal_eclipse_classes;

import java.util.Observable;

public class Newspaper extends Observable{

	String name;
	
	public Newspaper() {
		// TODO Auto-generated constructor stub
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void newRelease(){
		System.out.println("New release of " + this.name);
		setChanged();
		notifyObservers();
	}
	
}
