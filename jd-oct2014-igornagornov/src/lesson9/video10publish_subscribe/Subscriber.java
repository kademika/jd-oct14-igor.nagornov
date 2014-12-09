package lesson9.video10publish_subscribe;

public class Subscriber implements Observer{

	private String name;
	
	public Subscriber(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Subscriber " + name + " is notified!");
	}
	
	public String getName() {
		return name;
	}

}
