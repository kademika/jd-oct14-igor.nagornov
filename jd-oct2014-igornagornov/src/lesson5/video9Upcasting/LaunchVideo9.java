package lesson5.video9Upcasting;

public class LaunchVideo9 {
	
	public static void main(String[] args){
		Instrument i = new Instrument();
		Guitar g = new Guitar();
		Musician m = new Musician();
		
		m.play(g);	// пример upcasting'а, передаем в параметры класс наследник и воспринимаем его как класс родитель	
	}					//то есть получается, что в параметрах будет объект класса Instrument, а не класса Guitar

}
