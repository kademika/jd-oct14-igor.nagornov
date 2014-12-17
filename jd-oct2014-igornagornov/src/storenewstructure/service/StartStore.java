package storenewstructure.service;

import java.awt.SplashScreen;
import java.util.Calendar;
import java.util.GregorianCalendar;

import storenewstructure.guitar.AcousticGuitar;
import storenewstructure.guitar.BassGuitar;
import storenewstructure.guitar.ElectricGuitar;
import storenewstructure.guitar.FreatboardMaterial;
import storenewstructure.guitar.GuitarBrand;
import storenewstructure.guitar.GuitarType;

public class StartStore {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		SplashScreen sp = SplashScreen.getSplashScreen();
		Thread.sleep(5000);
		sp.close();
		
		Store store = new Store();		
		fillDB(store.getDb());				
		
		store.newPurchase(GuitarType.BASS, GuitarBrand.GIBSON, "gbg472", 1, "", new GregorianCalendar());					

		store.newPurchase(GuitarType.ACOUSTIC, GuitarBrand.JACKSON,
				"JAG637", 1, "Igor Nagornov", new GregorianCalendar()); 						
 
		store.newPurchase(GuitarType.ACOUSTIC, GuitarBrand.FENDER,
				"fag543", 1, "Ivan Petrov", new GregorianCalendar(2014,
						Calendar.DECEMBER, 9, 14, 40));			
	   	
	    store.newPurchase(GuitarType.ELECTRIC, GuitarBrand.IBANEZ, "JFX500", 3, "", new GregorianCalendar(2014,
				Calendar.DECEMBER, 8, 15, 30));	
	    
	    new StoreGUI(store);	
		

	}
	
	private static void fillDB(DataBase db) {

		ElectricGuitar g = new ElectricGuitar(GuitarBrand.IBANEZ, "Black",
				"JFX500", "Machogony", FreatboardMaterial.MACHOGONY, true, 7,
				24, "Indonezia", 20000, "EMG", "Seymor Duncan", true);
		db.addGuitarToDB(g);
		
		ElectricGuitar g1 = new ElectricGuitar(GuitarBrand.ESP, "White",
				"EEG123", "Machogony", FreatboardMaterial.MAPLE, false, 6, 24,
				"USA", 50000, "Seymor Duncan", "Seymor Duncan", true);
		db.addGuitarToDB(g1);

		ElectricGuitar g2 = new ElectricGuitar(GuitarBrand.FENDER, "Yellow",
				"FEG721", "Machogony", FreatboardMaterial.MAPLE, false, 6, 24,
				"USA", 45000, "Dimarzio", "Dimarzio", false);
		db.addGuitarToDB(g2);

		BassGuitar g3 = new BassGuitar(GuitarBrand.GIBSON, "Red", "GBG472",
				"Maple", FreatboardMaterial.MACHOGONY, false, 4, 24, "USA",
				75000, "Dimarzio", "Dimarzio", false);
		db.addGuitarToDB(g3);

		BassGuitar g4 = new BassGuitar(GuitarBrand.FENDER, "White", "FBG412",
				"Maple", FreatboardMaterial.MACHOGONY, false, 5, 24, "USA",
				65000, "EMG", "EMG", false);
		db.addGuitarToDB(g4);

		AcousticGuitar g5 = new AcousticGuitar(GuitarBrand.GIBSON, "red",
				"GAG12", FreatboardMaterial.MAPLE, true, 6, 19, "Japan", 40000,
				true);
		db.addGuitarToDB(g5);

		AcousticGuitar g6 = new AcousticGuitar(GuitarBrand.FENDER, "red",
				"FAG543", FreatboardMaterial.MAPLE, true, 6, 24, "USA", 45000,
				false);
		db.addGuitarToDB(g6);

		AcousticGuitar g7 = new AcousticGuitar(GuitarBrand.JACKSON, "blue",
				"JAG637", FreatboardMaterial.MACHOGONY, false, 12, 24, "USA",
				80000, true);
		db.addGuitarToDB(g7);

		ElectricGuitar g8 = new ElectricGuitar(GuitarBrand.IBANEZ, "Black",
				"JFX500", "Machogony", FreatboardMaterial.MACHOGONY, true, 7,
				24, "Indonezia", 20000, "EMG", "Seymor Duncan", true);
		db.addGuitarToDB(g8);

		ElectricGuitar g9 = new ElectricGuitar(GuitarBrand.IBANEZ, "Black",
				"JFX500", "Machogony", FreatboardMaterial.MACHOGONY, true, 7,
				24, "Indonezia", 20000, "EMG", "Seymor Duncan", true);
		db.addGuitarToDB(g9);

		ElectricGuitar g10 = new ElectricGuitar(GuitarBrand.IBANEZ, "Blue",
				"JFX501", "Machogony", FreatboardMaterial.MACHOGONY, true, 6,
				22, "Indonezia", 65000, "EMG", "EMG", false);
		db.addGuitarToDB(g10);

}

}
