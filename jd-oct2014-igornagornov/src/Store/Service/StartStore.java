package Store.Service;

import java.util.Date;

import Store.Guitar.AcousticGuitar;
import Store.Guitar.BassGuitar;
import Store.Guitar.ElectricGuitar;
import Store.Guitar.GuitarBrand;
import Store.Guitar.GuitarType;
import Store.Purchase.Purchase;

public class StartStore {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		Store store = new Store();	
		StoreGUI storeGUI = new StoreGUI(store);

		store.printStore(true); // if parameter is true, print by date, else print all information
		store.printNumberOfGuitarType();
		store.printGuitarType(GuitarType.ACOUSTIC);	
		
//	    System.out.println(store.getGuitarNumberByModel(GuitarType.ELECTRIC.ordinal(), GuitarBrand.IBANEZ.ordinal(), "JFX500"));
//	    System.out.println(store.getGuitarIndexByModel(GuitarType.ELECTRIC.ordinal(), GuitarBrand.IBANEZ.ordinal(), "JFX500"));
		
		store.newPurchase(GuitarType.BASS, GuitarBrand.GIBSON, "gbg472", 1, "", new Date());					

		store.newPurchase(GuitarType.ACOUSTIC, GuitarBrand.JACKSON,
				"JAG637", 1, "Igor Nagornov", new Date(114, 10, 28, 9, 10, 0)); //year-1900, month, day, hour, minute, second
 
		store.newPurchase(GuitarType.ACOUSTIC, GuitarBrand.FENDER,
				"fag543", 1, "Ivan Petrov", new Date(114, 11, 1, 16, 55, 0));		  	
	    
	    store.newPurchase(GuitarType.ELECTRIC, GuitarBrand.IBANEZ, "JFX500", 3, "", new Date());	    
		
		store.printPurchases(null);	 // if parameter is null, print all purchase, else print by date
	    store.printNumberOfPurchasesByWeek();   
		

	}
}
