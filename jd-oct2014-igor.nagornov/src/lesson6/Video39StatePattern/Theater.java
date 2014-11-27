package lesson6.Video39StatePattern;

public class Theater {

	private Actor actor;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Theater t = new Theater();
		t.actor = new HappyActor();
		t.actor.act();

		t.intermisson(); // zdes' proishodit smena sostoyaniya ob'ekta

		t.actor.act();

	}

	public void intermisson() {
		System.out.println("It's intermission now, let's go to cafe!\n");
		getSalary();
	}

	public void getSalary() {

		actor = new SadActor();
	}

}
