package lesson5.video16Static;

public class StartInstrument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Instrument i1 = new Instrument();
		Instrument i2 = new Instrument();		
		
		System.out.println("Поле fabric, общее для всех объектов сейчас - " + Instrument.fabric);
		System.out.println(i1.fabric);
		System.out.println(i2.fabric);
		System.out.println(); 
		
		i2.fabric = "Jackson"; //меняем статическое поле в одном объекте

		System.out.println("Поле fabric, общее для всех объектов сейчас - " + Instrument.fabric);
		System.out.println(i1.fabric); //получаем, что в другом объекте оно тоже сменилось, т.к. статическое поле общее
		System.out.println(i2.fabric); 			//для всех объектов класса и принадлежит к самому классу, 
													//а не к конкретным объектам
														

	}

	
	void temp(){
		System.out.println(1);
	}
}
