package Store.Service;

import Store.Guitar.GuitarType;
import Store.Purchase.Purchase;

public class StartStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Store store = new Store();
		store.fillStore();

		store.printStore(Store.getGuitar());
		store.printNumberOfGuitarType();
		store.printPrices(Store.getGuitar());
		store.printGuitarType(Store.getGuitar(), GuitarType.ACOUSTIC);

		Purchase p = new Purchase(Store.getGuitar()[0][1][0], 1, "Igor Nagornov");
		p.executePurchase(p, 0, 1, 0);

		Purchase p1 = new Purchase(Store.getGuitar()[1][4][0], 1);
		p1.executePurchase(p1, 1, 4, 0);

		Purchase.printPurchases();

	}	

}
