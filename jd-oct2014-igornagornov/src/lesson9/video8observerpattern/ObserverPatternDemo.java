package lesson9.video8observerpattern;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Observer o1 = new ConcreteObserver();
		Observer o2 = new ConcreteObserver();
		
		ConcreteSubject s = new ConcreteSubject();
		s.addObserver(o1);
		s.addObserver(o2);
		
		for(int i=0; i<10; i++){
			s.doTheJob();	
			System.out.println();
		}
		
		s.removeObserver(o1);
		
		for(int i=0; i<10; i++){
			s.doTheJob();	
			System.out.println();
		}
		
	}

}
