package lesson5.video9Upcasting;

public class LaunchVideo9 {
	
	public static void main(String[] args){
		Instrument i = new Instrument();
		Guitar g = new Guitar();
		Musician m = new Musician();
		
		m.play(g);	// primer upcasting'à, peredaem v parametr class naslednik i vosprinimaem ego kak klass roditel	
	}					//to est' poluchaetsya, chto v parametrah budet object classa Instrument, a ne klassa Guitar

}
