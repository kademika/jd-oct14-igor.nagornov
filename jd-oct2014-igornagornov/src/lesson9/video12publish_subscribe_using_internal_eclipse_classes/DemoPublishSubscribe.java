package lesson9.video12publish_subscribe_using_internal_eclipse_classes;

import java.util.Observer;

public class DemoPublishSubscribe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Observer s1 = new Subscriber("Igor Nagornov");
		Observer s2 = new Subscriber("Ivan Petrov");
		Observer s3 = new Subscriber("Semen Olegov");
		Observer s4 = new Subscriber("Oleg Smirnov");
		Observer s5 = new Subscriber("Sergey Ivanov");
				
		Magazine mg1 = new Magazine();
		mg1.setName("Poster");
		Newspaper np1 = new Newspaper();	
		np1.setName("News"); 		
		
		mg1.addObserver(s1);
		mg1.addObserver(s5);
		mg1.newRelease();		
	
		np1.addObserver(s2);
		np1.addObserver(s3);
		np1.addObserver(s4);
		np1.newRelease();
		
		np1.deleteObserver(s2);
		np1.newRelease();	
		

	}

}
