package lesson9.video10publish_subscribe;

public class DemoPublishSubscribe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Subscriber s1 = new Subscriber("Igor Nagornov");
		Subscriber s2 = new Subscriber("Ivan Petrov");
		Subscriber s3 = new Subscriber("Semen Olegov");
		Subscriber s4 = new Subscriber("Oleg Smirnov");
		Subscriber s5 = new Subscriber("Sergey Ivanov");		
		
		Newspaper.observers.add(s1);
		Newspaper.observers.add(s2);
		Newspaper.observers.add(s5);
		
		Magazine.observers.add(s1);
		Magazine.observers.add(s3);
		Magazine.observers.add(s4);
		Magazine.observers.add(s5);		
		
		new Newspaper();		
		new Magazine();	
		
		Magazine.observers.remove(s5);
		new Magazine();

	}

}
