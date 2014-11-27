package lesson6.Video20OverridingStatic;

public class Storage {

	public static final String producer = "PRODUCER";

	public String[] quotes;

	public Storage() {
		quotes = new String[] { "test string 1", "test string 2" };
	}

	public void printQuotes() {
		for (String quote : quotes) {
			System.out.println(quote);
		}
	}

	public static String getProducer() {
		return producer;
	}

}
