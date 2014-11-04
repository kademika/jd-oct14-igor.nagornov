package lesson6.Video20OverridingStatic;

public class ModernStorage extends Storage {

	public static final String producer = "MODERN PRODUCER";

	private String[] quotes; // quotes are different in classes Storage and
								// ModernStorage

	ModernStorage() {
		quotes = new String[] { "My test string" };
	}	
	
//	public void printQuotes() {
//		for (String quote : quotes) {
//			System.out.println(quote); //esli ne perepishem etot metod, on budet zapuskat'sya iz super klassa i rabotat' s drugoi quotes
//		}
//	}
	
	public static String getProducer() { //staticheskiy metod ne mozhem perepisat', poetomu vidaetsa producer iz super klassa
		return producer;
	}

}
