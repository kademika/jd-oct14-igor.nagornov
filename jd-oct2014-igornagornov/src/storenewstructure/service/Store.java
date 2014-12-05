package storenewstructure.service;

import java.util.Date;
import java.util.List;
import storenewstructure.customer.Customer;
import storenewstructure.guitar.AcousticGuitar;
import storenewstructure.guitar.BassGuitar;
import storenewstructure.guitar.ElectricGuitar;
import storenewstructure.guitar.Guitar;
import storenewstructure.guitar.GuitarBrand;
import storenewstructure.guitar.GuitarType;
import storenewstructure.purchase.Purchase;

public class Store {

	private DataBase db;

	public Store() {
		db = new DataBase();		
	}

	public void newPurchase(GuitarType guitarType, GuitarBrand guitarBrand,
			String model, int number, String customerName, Date date) {

		Purchase purchase = new Purchase();
		Customer customer;

		if (customerName == "") {
			customer = new Customer();
		} else {
			customer = new Customer(customerName);
		}

		int k = guitarType.ordinal();
		int i = guitarBrand.ordinal();
		int j = this.getGuitarIndexByModel(k, i, model);
		purchase.setCustomer(customer);
		purchase.setNumber(number);
		purchase.setDate(date);

		try {
			if (j != -1) {
				purchase.setGuitar(db.getGuitarTypeList().get(k).get(i).get(j));
				executePurchase(purchase, k, i, model, number);

			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.err.println("There is no such guitar in store!");
		} catch (IllegalStateException e) {
			System.err.println("Illegal number! We don't have it in store");
		}

	}

	private void executePurchase(Purchase purchase, int k, int i, String model,
			int number) throws IllegalStateException {

		if (number < 1 || number > this.getGuitarNumberByModel(k, i, model)) {
			throw new IllegalStateException();
		}

		for (int idx = 0; idx < number; idx++) {
			int j = this.getGuitarIndexByModel(k, i, model);
			db.removeGuitarFromDB(k, i, j);
		}
		
		db.getPurchase().add(purchase);
	}

	public void printStore(boolean pricesOnly) {

		for (List<List<Guitar>> guitarType : db.getGuitarTypeList()) {
			for (List<Guitar> guitarBrand : guitarType) {
				for (Guitar guitarTemp : guitarBrand) {
					if (guitarTemp != null) {

						System.out.print(guitarTemp
								.getClass()
								.getName()
								.substring(
										guitarTemp.getClass().getName()
												.lastIndexOf(".") + 1)
								+ " "
								+ guitarTemp.getGuitarBrand()
								+ " "
								+ guitarTemp.getColor()
								+ " "
								+ guitarTemp.getModel() + " ");

						if (pricesOnly == false) {
							System.out.print(guitarTemp.getFreatboardMaterial()
									+ " " + guitarTemp.isFreatboardGlued()
									+ " " + guitarTemp.getNumberOfStrings()
									+ " " + guitarTemp.getNumberOfFrets() + " "
									+ guitarTemp.getManufacturer() + " ");
						}

						System.out.print(guitarTemp.getPrice() + " ");

						if (pricesOnly == true) {
							System.out.println();
							continue;
						}

						if (guitarTemp instanceof ElectricGuitar
								|| (guitarTemp instanceof BassGuitar)) {
							ElectricGuitar valueTemp = (ElectricGuitar) guitarTemp;
							System.out.println(valueTemp.getBodyMaterial()
									+ " " + valueTemp.getNeckName() + " "
									+ valueTemp.getBridgeName() + " "
									+ valueTemp.isFloydRose());
						}

						if (guitarTemp instanceof AcousticGuitar) {
							AcousticGuitar valueTemp = (AcousticGuitar) guitarTemp;
							System.out.println(valueTemp.isStringsIsNylon());
						}
					}
				}
			}

		}
		System.out
				.println("_____________________________________________________________________________________________________________");

	}

	public void printNumberOfGuitarType() {

		System.out.println("We have " + db.getNumberOfAcousticGuitar()
				+ " acoustic guitars in the stock");
		System.out.println("We have " + db.getNumberOfElectricGuitar()
				+ " electric guitars in the stock");
		System.out.println("We have " + db.getNumberOfBassGuitar()
				+ " bass guitars in the stock");
		System.out
				.println("________________________________________________________");
	}

	public void printGuitarType(GuitarType guitarType) {

		int idx = guitarType.ordinal();

		for (List<Guitar> guitarBrandList : db.getGuitarTypeList().get(idx)) {
			for (Guitar guitarTemp : guitarBrandList) {
				System.out.println(guitarTemp
						.getClass()
						.getName()
						.substring(
								guitarTemp.getClass().getName()
										.lastIndexOf(".") + 1)
						+ " "
						+ guitarTemp.getGuitarBrand()
						+ " "
						+ guitarTemp.getColor()
						+ " "
						+ guitarTemp.getModel()
						+ " " + guitarTemp.getPrice());

			}
		}

	}

	int getGuitarIndexByModel(int k, int i, String model) {

		int index = -1;
		int j = 0;
		model = model.toUpperCase();

		for (Guitar g : db.getGuitarTypeList().get(k).get(i)) {
			if (g.getModel().toUpperCase().equals(model)) {
				index = j;
			}
			j++;
		}

		return index;
	}

	int getGuitarNumberByModel(int k, int i, String model) {

		int kol = 0;
		model = model.toUpperCase();

		for (Guitar g : db.getGuitarTypeList().get(k).get(i)) {
			if (g.getModel().toUpperCase().equals(model)) {
				kol++;
			}
		}

		return kol;
	}

	public void printPurchases(Date date) {

		int sum = 0;
		int number = 0;

		for (Purchase value : db.getPurchase()) {
			if (value != null) {
				if (date != null) {

					if (value.getDate().getDate() != date.getDate()) {
						continue;
					}

				}

				number++;
				sum += (value.getNumber() * value.getGuitar().getPrice());
				System.out.println("Purchase " + number + " "
						+ value.getCustomer().getName() + " "
						+ value.getGuitar().getGuitarBrand() + " "
						+ value.getGuitar().getModel() + " "
						+ value.getNumber() + " "
						+ (value.getNumber() * value.getGuitar().getPrice())
						+ " " + value.getDate());

			}

		}

		System.out
				.println("__________________________________________________");
		System.out.println("All " + number
				+ " purchases                            " + sum);

	}

	public void printNumberOfPurchasesByWeek() {

		Date now = new Date();
		int[] numberOfPurchaseByWeek = new int[7];

		for (Purchase value : db.getPurchase()) {
			if (value != null) {

				for (int i = 0; i < numberOfPurchaseByWeek.length; i++) {
					if (value.getDate().getDate() == now.getDate()
							- (numberOfPurchaseByWeek.length - 1) + i) {
						numberOfPurchaseByWeek[i]++;

					}
				}

			}

		}

		for (int i = 0; i < numberOfPurchaseByWeek.length; i++) {

			if (i == numberOfPurchaseByWeek.length - 1) {
				System.out.println(numberOfPurchaseByWeek[i]
						+ " purchases were made today");
			} else if (i == numberOfPurchaseByWeek.length - 2) {
				System.out.println(numberOfPurchaseByWeek[i]
						+ " purchases were made yesterday");
			} else
				System.out
						.println(numberOfPurchaseByWeek[i]
								+ " purchases were made "
								+ (numberOfPurchaseByWeek.length - i - 1)
								+ " days ago");

		}

		System.out
				.println("__________________________________________________");

	}

	public DataBase getDb() {
		return db;
	}

}
