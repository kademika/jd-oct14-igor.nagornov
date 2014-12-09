package lesson9.video8observerpattern;

public interface Subject {
	
	void removeObserver(Observer o);
	void addObserver(Observer o);
	void notifyObservers();
	
}
