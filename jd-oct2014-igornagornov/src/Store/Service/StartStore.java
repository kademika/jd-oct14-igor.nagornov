package Store.Service;

import Store.Guitar.AcousticGuitar;
import Store.Guitar.BassGuitar;
import Store.Guitar.ElectricGuitar;
import Store.Guitar.FreatboardMaterial;
import Store.Guitar.Guitar;
import Store.Guitar.GuitarBrand;
import Store.Guitar.GuitarType;
import Store.Purchase.Purchase;
import lesson4.HW_Library.Books;

public class StartStore {

	private static Guitar guitar[][][] = new Guitar[3][5][];
	private static Purchase purchase[] = new Purchase[100];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fillStore();

		// printStore(guitar);
		// printNumberOfGuitarType();
		// printPrices(guitar);
		// printGuitarType(guitar, GuitarType.ACOUSTIC);

		Purchase p = new Purchase(guitar[0][1][0], 1, "Igor Nagornov");
		executePurchase(p, 0, 1, 0);

		Purchase p1 = new Purchase(guitar[1][4][0], 1);
		executePurchase(p1, 1, 4, 0);

		printPurchases(purchase);

	}

	public static void fillStore() {

		ElectricGuitar g = new ElectricGuitar();
		addGuitarToStore(g);
		ElectricGuitar.increaseCountElecticGuitar();

		ElectricGuitar g1 = new ElectricGuitar("Machogony", "Seymor Duncan",
				"Seymor Duncan", true, GuitarBrand.ESP, "Black", "JP123",
				FreatboardMaterial.MACHOGONY, false, 7, 22, "Japan", 65000);
		addGuitarToStore(g1);
		ElectricGuitar.increaseCountElecticGuitar();

		ElectricGuitar g2 = new ElectricGuitar("Machogony", "Seymor Duncan",
				"EMG", false, GuitarBrand.FENDER, "Blue", "PO443",
				FreatboardMaterial.MACHOGONY, false, 7, 22, "Japan", 70000);
		addGuitarToStore(g2);
		ElectricGuitar.increaseCountElecticGuitar();

		BassGuitar g3 = new BassGuitar();
		addGuitarToStore(g3);

		BassGuitar g4 = new BassGuitar("Machogony", "EMG", "EMG", false,
				GuitarBrand.GIBSON, "White", "TE321",
				FreatboardMaterial.MACHOGONY, false, 4, 24, "Japan", 55000);
		addGuitarToStore(g4);

		AcousticGuitar g5 = new AcousticGuitar();
		addGuitarToStore(g5);

		AcousticGuitar g6 = new AcousticGuitar(GuitarBrand.GIBSON, "red",
				"RHD12", FreatboardMaterial.MAPLE, true, 6, 19, "Japan", 40000,
				true);
		addGuitarToStore(g6);

		AcousticGuitar g7 = new AcousticGuitar(GuitarBrand.JACKSON, "blue",
				"PR981", FreatboardMaterial.MACHOGONY, false, 12, 24, "USA",
				80000, true);
		addGuitarToStore(g7);

	}

	public static void addGuitarToStore(Guitar g) {

		int k = 0;
		if (g instanceof AcousticGuitar) {
			k = 0;
		}

		if (g instanceof ElectricGuitar && !(g instanceof BassGuitar)) {
			k = 1;
		}

		if (g instanceof BassGuitar) {
			k = 2;
		}

		if (guitar[k] == null) {
			guitar[k] = new Guitar[5][];
		}

		if (guitar[k][g.getGuitarBrand().ordinal()] == null) {
			guitar[k][g.getGuitarBrand().ordinal()] = new Guitar[10];
		}

		int i = g.getGuitarBrand().ordinal();
		int j = getNumberOfGuitars(guitar[k][g.getGuitarBrand().ordinal()]);

		guitar[k][i][j] = g;

	}

	public static void printStore(Guitar[][][] guitar) {

		for (Guitar[][] valueD : guitar) {
			if (valueD != null) {
				for (Guitar[] valueV : valueD) {
					if (valueV != null) {
						for (Guitar valueH : valueV) {
							if (valueH != null) {
								if (valueH instanceof ElectricGuitar
										&& !(valueH instanceof BassGuitar)) {
									ElectricGuitar valueTemp = (ElectricGuitar) valueH;
									System.out.println("Electric Guitar - "
											+ valueTemp.getGuitarBrand() + " "
											+ valueTemp.getColor() + " "
											+ valueTemp.getModel() + " "
											+ valueTemp.getFreatboardMaterial()
											+ " "
											+ valueTemp.isFreatboardGlued()
											+ " "
											+ valueTemp.getNumberOfStrings()
											+ " "
											+ valueTemp.getNumberOfFrets()
											+ " " + valueTemp.getManufacturer()
											+ " " + valueTemp.getPrice() + " "
											+ valueTemp.getBodyMaterial() + " "
											+ valueTemp.getNeckName() + " "
											+ valueTemp.getBridgeName() + " "
											+ valueTemp.isFloydRose());
								}

								if (valueH instanceof BassGuitar) {
									BassGuitar valueTemp = (BassGuitar) valueH;
									System.out.println("Bass Guitar - "
											+ valueTemp.getGuitarBrand() + " "
											+ valueTemp.getColor() + " "
											+ valueTemp.getModel() + " "
											+ valueTemp.getFreatboardMaterial()
											+ " "
											+ valueTemp.isFreatboardGlued()
											+ " "
											+ valueTemp.getNumberOfStrings()
											+ " "
											+ valueTemp.getNumberOfFrets()
											+ " " + valueTemp.getManufacturer()
											+ " " + valueTemp.getPrice() + " "
											+ valueTemp.getBodyMaterial() + " "
											+ valueTemp.getNeckName() + " "
											+ valueTemp.getBridgeName() + " "
											+ valueTemp.isFloydRose());
								}
								if (valueH instanceof AcousticGuitar) {
									AcousticGuitar valueTemp = (AcousticGuitar) valueH;
									System.out.println("Acoustic Guitar - "
											+ valueTemp.getGuitarBrand() + " "
											+ valueTemp.getColor() + " "
											+ valueTemp.getModel() + " "
											+ valueTemp.getFreatboardMaterial()
											+ " "
											+ valueTemp.isFreatboardGlued()
											+ " "
											+ valueTemp.getNumberOfStrings()
											+ " "
											+ valueTemp.getNumberOfFrets()
											+ " " + valueTemp.getManufacturer()
											+ " " + valueTemp.getPrice() + " "
											+ valueTemp.isStringsIsNylon());

								}
							}
						}
					}
				}
			}

		}
		System.out
				.println("_____________________________________________________________________________________________________________");

	}

	public static void printPrices(Guitar[][][] guitar) {

		for (Guitar[][] valueD : guitar) {
			if (valueD != null) {
				for (Guitar[] valueV : valueD) {
					if (valueV != null) {
						for (Guitar valueH : valueV) {
							if (valueH != null) {
								System.out.println(valueH.getClass().getName()
										+ " " + valueH.getGuitarBrand() + " "
										+ valueH.getColor() + " "
										+ valueH.getModel() + " " + " "
										+ valueH.getPrice());

							}
						}
					}
				}
			}

		}

		System.out
				.println("________________________________________________________");

	}

	public static void printNumberOfGuitarType() {

		System.out.println("We have " + AcousticGuitar.getCountAcousticGuitar()
				+ " acoustic guitars in the stock");
		System.out.println("We have " + ElectricGuitar.getCountElecticGuitar()
				+ " electric guitars in the stock");
		System.out.println("We have " + BassGuitar.getCountBassGuitar()
				+ " bass guitars in the stock");
		System.out
				.println("________________________________________________________");
	}

	public static void printGuitarType(Guitar[][][] guitar,
			GuitarType guitarType) {

		if (guitar != null) {
			for (int i = 0; i < guitar[guitarType.ordinal()].length; i++) {
				if (guitar[guitarType.ordinal()][i] != null) {
					for (int j = 0; j < guitar[guitarType.ordinal()][i].length; j++) {
						if (guitar[guitarType.ordinal()][i][j] != null) {
							System.out
									.println(guitar[guitarType.ordinal()][i][j]
											.getClass().getName()
											+ " "
											+ guitar[guitarType.ordinal()][i][j]
													.getGuitarBrand()
											+ " "
											+ guitar[guitarType.ordinal()][i][j]
													.getColor()
											+ " "
											+ guitar[guitarType.ordinal()][i][j]
													.getModel()
											+ " "
											+ " "
											+ guitar[guitarType.ordinal()][i][j]
													.getPrice());

						}
					}
				}
			}

		}
		System.out
				.println("________________________________________________________");

	}

	public static void executePurchase(Purchase p, int k, int i, int j) {		

		guitar[k][i][j] = null;

		int kol = 0;
		while (purchase[kol] != null) {
			kol++;
		}
		purchase[kol] = p;
		
	}

	public static void printPurchases(Purchase[] purchase) {

		int number=0;
		int sum=0;		
		
		for (Purchase value : purchase) {
			if(value!=null){
				number++;
				sum+=(value.getNumber() * value.getGuitar().getPrice());
				System.out.println("Purchase " + number + " "
						+ value.getCustomer().getName() + " "
						+ value.getGuitar().getGuitarBrand() + " "
						+ value.getGuitar().getModel() + " " + value.getNumber()
						+ " " + (value.getNumber() * value.getGuitar().getPrice()));								
			}			
			
			
		}
		
		System.out
		.println("__________________________________________________");
		System.out.println("All " + number + " purchases                            " + sum);

		

	}

	public static int getNumberOfGuitars(Guitar[] guitar) {

		int i = 0;

		if (guitar != null) {
			while (guitar[i] != null) {
				i++;
			}
		}

		return i;

	}

}
