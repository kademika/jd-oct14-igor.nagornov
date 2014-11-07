package Store.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import Store.Guitar.GuitarBrand;
import Store.Guitar.GuitarType;
import Store.Purchase.Purchase;

public class StartStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Store store = new Store();
		store.fillStore();

//		store.printStore();
		store.printNumberOfGuitarType();
		store.printPrices();
//		store.printGuitarType(GuitarType.BASS);
		
		new Purchase(GuitarType.BASS, GuitarBrand.GIBSON, "TE321", 1);
		
		new Purchase(GuitarType.ELECTRIC, GuitarBrand.IBANEZ, "JFX500", 1);
		
		new Purchase(GuitarType.ELECTRIC, GuitarBrand.IBANEZ, "JFX500", 1);		

		new Purchase(GuitarType.ACOUSTIC, GuitarBrand.IBANEZ,
				"JFX500", 1, "Igor Nagornov", new Date(114, 10, 1, 9, 10, 0)); //year-1900, month, day, hour, minute, second

	    new Purchase(GuitarType.ACOUSTIC, GuitarBrand.JACKSON,
				"PR981", 1, "Ivan Petrov", new Date(114, 10, 2, 16, 55, 0));		  

	    
	    
		Purchase.printPurchases();
//	    Purchase.printPurchasesByDate(new Date(114, 10, 1));
	    Purchase.printNumberOfPurchasesByWeek();
	    
		

	}
}
