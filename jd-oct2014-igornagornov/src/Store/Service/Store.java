package Store.Service;

import Store.Guitar.AcousticGuitar;
import Store.Guitar.BassGuitar;
import Store.Guitar.ElectricGuitar;
import Store.Guitar.FreatboardMaterial;
import Store.Guitar.Guitar;
import Store.Guitar.GuitarBrand;
import Store.Guitar.GuitarType;

public class Store {

	private static Guitar guitar[][][] = new Guitar[3][5][];

	public void fillStore() {

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
		
		ElectricGuitar g8 = new ElectricGuitar();
		addGuitarToStore(g8);
		ElectricGuitar.increaseCountElecticGuitar();
		
		ElectricGuitar g9 = new ElectricGuitar();
		addGuitarToStore(g9);
		ElectricGuitar.increaseCountElecticGuitar();

	}

	public void addGuitarToStore(Guitar g) {

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
		int j = getNumberOfGuitars(guitar[k][i]);

		guitar[k][i][j] = g;

	}

	public void printStore() {		
		
		for (Guitar[][] guitarType : guitar) {
			if (guitarType != null) {
				for (Guitar[] guitarBrand : guitarType) {
					if (guitarBrand != null) {
						for (Guitar guitarTemp : guitarBrand) {
							if (guitarTemp != null) {
								if (guitarTemp instanceof ElectricGuitar
										&& !(guitarTemp instanceof BassGuitar)) {
									ElectricGuitar valueTemp = (ElectricGuitar) guitarTemp;
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

								if (guitarTemp instanceof BassGuitar) {
									BassGuitar valueTemp = (BassGuitar) guitarTemp;
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
								if (guitarTemp instanceof AcousticGuitar) {
									AcousticGuitar valueTemp = (AcousticGuitar) guitarTemp;
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
		System.out.println("_____________________________________________________________________________________________________________");

	}

	public void printPrices() {		
		
		for (Guitar[][] guitarType : guitar) {
			if (guitarType != null) {
				for (Guitar[] guitarBrand : guitarType) {
					if (guitarBrand != null) {
						for (Guitar guitarTemp : guitarBrand) {
							if (guitarTemp != null) {
								System.out.println(guitarTemp.getClass()
										.getName()
										+ " "
										+ guitarTemp.getGuitarBrand()
										+ " "
										+ guitarTemp.getColor()
										+ " "
										+ guitarTemp.getModel()
										+ " "
										+ guitarTemp.getPrice());

							}
						}
					}
				}
			}

		}

		System.out.println("________________________________________________________");

	}

	public void printNumberOfGuitarType() {		
		
		System.out.println("We have " + AcousticGuitar.getCountAcousticGuitar()
				+ " acoustic guitars in the stock");
		System.out.println("We have " + ElectricGuitar.getCountElecticGuitar()
				+ " electric guitars in the stock");
		System.out.println("We have " + BassGuitar.getCountBassGuitar()
				+ " bass guitars in the stock");
		System.out.println("________________________________________________________");
	}

	public void printGuitarType(GuitarType guitarType) {
		
		
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
											+ guitar[guitarType.ordinal()][i][j]
													.getPrice());

						}
					}
				}
			}

		}
		System.out.println("________________________________________________________");

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

	public static Guitar[][][] getGuitar() {
		return guitar;
	}

	public static int getGuitarIndexByModel(int k, int i, String model) {			
		
		int kol = 0;
		model = model.toUpperCase();
		
		for(int j=0; j<getNumberOfGuitars(guitar[k][i]); j++){
			if(guitar[k][i][j].getModel().toUpperCase().equals(model)){
				kol=j;				
			}
		}

		return kol;
	}

}
