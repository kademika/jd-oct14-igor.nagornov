package Store.Service;

import Store.Guitar.GuitarBrand;
import Store.Guitar.GuitarType;
import Store.Purchase.Purchase;

public class StartStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Store store = new Store();
		store.fillStore();

		store.printStore();
		store.printNumberOfGuitarType();
		store.printPrices();
		store.printGuitarType(GuitarType.ACOUSTIC);

		Purchase p = new Purchase(Store.getGuitar()[GuitarType.ACOUSTIC.ordinal()][GuitarBrand.IBANEZ.ordinal()][0], 2, "Igor Nagornov");
		p.executePurchase(p, GuitarType.ACOUSTIC.ordinal(), GuitarBrand.IBANEZ.ordinal(), 0);

		Purchase p1 = new Purchase(Store.getGuitar()[GuitarType.ELECTRIC.ordinal()][GuitarBrand.ESP.ordinal()][0], 1);
		p1.executePurchase(p1, GuitarType.ELECTRIC.ordinal(), GuitarBrand.ESP.ordinal(), 1);

		Purchase.printPurchases();

	}	

}
