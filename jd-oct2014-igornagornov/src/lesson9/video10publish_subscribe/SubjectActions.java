package lesson9.video10publish_subscribe;

public interface SubjectActions {
	
	void removeObserver(Observer o);
	void addObserver(Observer o);
	void notifyObservers();

}
