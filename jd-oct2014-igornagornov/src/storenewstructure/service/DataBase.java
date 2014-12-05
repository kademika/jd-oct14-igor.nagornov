package storenewstructure.service;

import java.util.ArrayList;
import java.util.List;

import storenewstructure.guitar.AcousticGuitar;
import storenewstructure.guitar.BassGuitar;
import storenewstructure.guitar.ElectricGuitar;
import storenewstructure.guitar.Guitar;
import storenewstructure.purchase.Purchase;

public class DataBase {

	private GuitarTypeList guitarTypeList;
	private List<Purchase> purchase;

	public DataBase() {
		// TODO Auto-generated constructor stub

		guitarTypeList = new GuitarTypeList();
		purchase = new ArrayList<>();

	}

	class GuitarTypeList extends ArrayList<List<List<Guitar>>> {

		public GuitarTypeList() {
			// TODO Auto-generated constructor stub

			GuitarBrandList acousticGuitarBrandList = new GuitarBrandList();
			this.add(acousticGuitarBrandList);

			GuitarBrandList electricGuitarBrandList = new GuitarBrandList();
			this.add(electricGuitarBrandList);

			GuitarBrandList bassGuitarBrandList = new GuitarBrandList();
			this.add(bassGuitarBrandList);

		}

		private class GuitarBrandList extends ArrayList<List<Guitar>> {

			public GuitarBrandList() {

				List<Guitar> fender = new ArrayList<>();
				this.add(fender);

				List<Guitar> ibanez = new ArrayList<>();
				this.add(ibanez);

				List<Guitar> gibson = new ArrayList<>();
				this.add(gibson);

				List<Guitar> jackson = new ArrayList<>();
				this.add(jackson);

				List<Guitar> esp = new ArrayList<>();
				this.add(esp);
			}

		}

	}

	public void addGuitarToDB(Guitar g) {

		if (g instanceof AcousticGuitar) {
			guitarTypeList.get(0).get(g.getGuitarBrand().ordinal()).add(g);
		}

		if (g instanceof ElectricGuitar && !(g instanceof BassGuitar)) {
			guitarTypeList.get(1).get(g.getGuitarBrand().ordinal()).add(g);
		}

		if (g instanceof BassGuitar) {
			guitarTypeList.get(2).get(g.getGuitarBrand().ordinal()).add(g);
		}

	}

	public void removeGuitarFromDB(int k, int i, int j) {

		if (guitarTypeList.get(k).get(i).size()==0) {
			throw new IllegalArgumentException(
					"There is no elements in data base! Nothing could be removed!");
		}
		
		guitarTypeList.get(k).get(i).remove(j);

		
		
	}

	public int getNumberOfAcousticGuitar() {

		return guitarTypeList.get(0).get(0).size()
				+ guitarTypeList.get(0).get(1).size()
				+ guitarTypeList.get(0).get(2).size()
				+ guitarTypeList.get(0).get(3).size()
				+ guitarTypeList.get(0).get(4).size();
	}

	public int getNumberOfElectricGuitar() {

		return guitarTypeList.get(1).get(0).size()
				+ guitarTypeList.get(1).get(1).size()
				+ guitarTypeList.get(1).get(2).size()
				+ guitarTypeList.get(1).get(3).size()
				+ guitarTypeList.get(1).get(4).size();
	}

	public int getNumberOfBassGuitar() {

		return guitarTypeList.get(2).get(0).size()
				+ guitarTypeList.get(2).get(1).size()
				+ guitarTypeList.get(2).get(2).size()
				+ guitarTypeList.get(2).get(3).size()
				+ guitarTypeList.get(2).get(4).size();
	}

	public List<Purchase> getPurchase() {
		return purchase;
	}

	public GuitarTypeList getGuitarTypeList() {
		return guitarTypeList;
	}

}