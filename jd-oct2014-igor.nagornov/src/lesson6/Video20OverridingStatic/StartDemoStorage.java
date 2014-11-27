package lesson6.Video20OverridingStatic;

public class StartDemoStorage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Storage storage = new Storage();
		storage.printQuotes();
		System.out.println(storage.getProducer());

		System.out.println();

		Storage modernStorage = new ModernStorage();
		modernStorage.printQuotes();
		System.out.println(modernStorage.getProducer());

	}

}
