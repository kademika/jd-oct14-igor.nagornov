package Store.Service;

import java.util.ArrayList;
import java.util.List;
import Store.Guitar.AcousticGuitar;
import Store.Guitar.BassGuitar;
import Store.Guitar.ElectricGuitar;
import Store.Guitar.FreatboardMaterial;
import Store.Guitar.Guitar;
import Store.Guitar.GuitarBrand;
import Store.Purchase.Purchase;

public class DataBase {

	public DataBase() {
		fillDB();
	}

	private Guitar guitar[][][] = new Guitar[3][5][];
	List<Purchase> purchase = new ArrayList<>();

	private int numberOfElectricGuitar;
	private int numberOfBassGuitar;
	private int numberOfAcousticGuitar;

	private void fillDB() {

		ElectricGuitar g = new ElectricGuitar(GuitarBrand.IBANEZ, "Black",
				"JFX500", "Machogony", FreatboardMaterial.MACHOGONY, true, 7,
				24, "Indonezia", 20000, "EMG", "Seymor Duncan", true);
		addGuitarToDB(g);

		// new ElectricGuitar(guitarBrand, color, model, bodyMaterial,
		// freatboardMaterial, isFreatboardGlued, numberOfStrings,
		// numberOfFrets, manufacturer, price, bridgeName, neckName,
		// isFloydRose)

		ElectricGuitar g1 = new ElectricGuitar(GuitarBrand.ESP, "White",
				"EEG123", "Machogony", FreatboardMaterial.MAPLE, false, 6, 24,
				"USA", 50000, "Seymor Duncan", "Seymor Duncan", true);
		addGuitarToDB(g1);

		ElectricGuitar g2 = new ElectricGuitar(GuitarBrand.FENDER, "Yellow",
				"FEG721", "Machogony", FreatboardMaterial.MAPLE, false, 6, 24,
				"USA", 45000, "Dimarzio", "Dimarzio", false);
		addGuitarToDB(g2);

		// new BassGuitar(guitarBrand, color, model, bodyMaterial,
		// freatboardMaterial, isFreatboardGlued, numberOfStrings,
		// numberOfFrets, manufacturer, price, bridgeName, neckName,
		// isFloydRose)
		BassGuitar g3 = new BassGuitar(GuitarBrand.GIBSON, "Red", "GBG472",
				"Maple", FreatboardMaterial.MACHOGONY, false, 4, 24, "USA",
				75000, "Dimarzio", "Dimarzio", false);
		addGuitarToDB(g3);

		BassGuitar g4 = new BassGuitar(GuitarBrand.FENDER, "White", "FBG412",
				"Maple", FreatboardMaterial.MACHOGONY, false, 5, 24, "USA",
				65000, "EMG", "EMG", false);
		addGuitarToDB(g4);

		// new AcousticGuitar(guitarBrand, color, model, freatboardMaterial,
		// isFreatboardGlued, numberOfStrings, numberOfFrets, manufacturer,
		// price, stringsIsNylon)
		AcousticGuitar g5 = new AcousticGuitar(GuitarBrand.GIBSON, "red",
				"GAG12", FreatboardMaterial.MAPLE, true, 6, 19, "Japan", 40000,
				true);
		addGuitarToDB(g5);

		AcousticGuitar g6 = new AcousticGuitar(GuitarBrand.FENDER, "red",
				"GAG12", FreatboardMaterial.MAPLE, true, 6, 24, "USA", 45000,
				false);
		addGuitarToDB(g6);

		AcousticGuitar g7 = new AcousticGuitar(GuitarBrand.JACKSON, "blue",
				"JAG637", FreatboardMaterial.MACHOGONY, false, 12, 24, "USA",
				80000, true);
		addGuitarToDB(g7);

		ElectricGuitar g8 = new ElectricGuitar(GuitarBrand.IBANEZ, "Black",
				"JFX500", "Machogony", FreatboardMaterial.MACHOGONY, true, 7,
				24, "Indonezia", 20000, "EMG", "Seymor Duncan", true);
		addGuitarToDB(g8);

		ElectricGuitar g9 = new ElectricGuitar(GuitarBrand.IBANEZ, "Black",
				"JFX500", "Machogony", FreatboardMaterial.MACHOGONY, true, 7,
				24, "Indonezia", 20000, "EMG", "Seymor Duncan", true);
		addGuitarToDB(g9);

		ElectricGuitar g10 = new ElectricGuitar(GuitarBrand.IBANEZ, "Blue",
				"JFX501", "Machogony", FreatboardMaterial.MACHOGONY, true, 6,
				22, "Indonezia", 65000, "EMG", "EMG", false);
		addGuitarToDB(g10);

	}

	public void addGuitarToDB(Guitar g) {

		int k = 0;
		if (g instanceof AcousticGuitar) {
			k = 0;
			numberOfAcousticGuitar++;
		}

		if (g instanceof ElectricGuitar && !(g instanceof BassGuitar)) {
			k = 1;
			numberOfElectricGuitar++;
		}

		if (g instanceof BassGuitar) {
			k = 2;
			numberOfBassGuitar++;
		}

		if (guitar[k] == null) {
			guitar[k] = new Guitar[5][];
		}

		int i = g.getGuitarBrand().ordinal();
		if (guitar[k][i] == null) {
			guitar[k][i] = new Guitar[1];
			guitar[k][i][0] = g;
			return;
		}

		Guitar[] tempGuitarArray = new Guitar[guitar[k][i].length + 1];

		tempGuitarArray[tempGuitarArray.length - 1] = g;
		for (int j = 0; j < guitar[k][i].length; j++) {
			tempGuitarArray[j] = guitar[k][i][j];
		}

		guitar[k][i] = tempGuitarArray;

	}

	public void removeGuitarFromDB(int k, int i, int j) {

		Guitar[] tempArray;
		Guitar returnGuitar;

		if (guitar[k][i] == null || guitar[k][i].length == 0) {
			throw new IllegalArgumentException(
					"There is no elements in data base! Nothing could be removed!");
		}

		tempArray = new Guitar[guitar[k][i].length - 1];

		for (int idx = 0, jdx=0; idx < guitar[k][i].length;) {
			if(idx==j) {
				guitar[k][i][idx] = null;
				idx++;
				continue;
			}			
			tempArray[jdx] = guitar[k][i][idx];
			idx++;
			jdx++;
		}
		
		guitar[k][i] = tempArray;

	}

	public Guitar[][][] getGuitar() {
		return guitar;
	}

	public List<Purchase> getPurchase() {
		return purchase;
	}

	public int getNumberOfElectricGuitar() {
		return numberOfElectricGuitar;
	}

	public int getNumberOfBassGuitar() {
		return numberOfBassGuitar;
	}

	public int getNumberOfAcousticGuitar() {
		return numberOfAcousticGuitar;
	}

	public void decreaseNumberOfAcousticGuitar() {
		// TODO Auto-generated method stub
		numberOfAcousticGuitar--;
	}

	public void decreasenumberOfElecticGuitar() {
		// TODO Auto-generated method stub
		numberOfElectricGuitar--;
	}

	public void decreaseNumberOfBassGuitar() {
		// TODO Auto-generated method stub
		numberOfBassGuitar--;
	}

}
