package lesson5.video9Upcasting;

public class Musician {
	
	public void play(Instrument i){
		
		i.sound();	//
		if(i instanceof Guitar){ //проверяем является ли иструмент гитарой
			Guitar g = (Guitar)i; //прокаст объекта i класса Instrument в объект Guitar
			g.testMessage(); //если прокаст не сделать, то метод testMessage не будет доступен, потому что 
		}									//в классе Instrument нет такого метода
			
	}

}
