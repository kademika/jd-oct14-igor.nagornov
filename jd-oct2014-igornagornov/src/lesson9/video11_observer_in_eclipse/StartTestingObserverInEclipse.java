package lesson9.video11_observer_in_eclipse;

import java.util.Observer;

public class StartTestingObserverInEclipse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Worker w = new Worker("Ivan");
		
		Observer o1 = new Supervisor("Supervisor 1");
		Observer o2 = new Supervisor("Supervisor 2");
		
		w.addObserver(o1);
		w.addObserver(o2);
		
		for(int i=0; i<5; i++){
			w.doJob();
		}
		
		w.deleteObserver(o1);
		
		for(int i=0; i<5; i++){
			w.doJob();
		}
		
	}

}
