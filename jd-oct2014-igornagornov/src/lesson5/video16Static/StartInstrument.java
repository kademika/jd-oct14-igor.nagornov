package lesson5.video16Static;

public class StartInstrument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Instrument i1 = new Instrument();
		Instrument i2 = new Instrument();		
		
		System.out.println("Common field fabric is - " + Instrument.fabric);
		System.out.println(i1.fabric);
		System.out.println(i2.fabric);
		System.out.println(); 
		
		i2.fabric = "Jackson"; //menyaem staticheskoe pole v odnom klasse

		System.out.println("Common field fabric is - " + Instrument.fabric);
		System.out.println(i1.fabric); //v drugom klasse staticheskoe pole tozhe izmenilos, t.k ono obshee
		System.out.println(i2.fabric); 			//dlya vseh klassov i prenadlezhit k samomu klassu, 
													//a ne k konkretnim objectam
														

	}

	
	void temp(){
		System.out.println(1);
	}
}
