package storenewstructure.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
			String model, int number, String customerName, Calendar date)
			throws RuntimeException {

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

		if (j != -1) {
			purchase.setGuitar(db.getGuitarTypeList().get(k).get(i).get(j));
			executePurchase(purchase, k, i, model, number);

		} else {
			throw new IllegalArgumentException();
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

	public String printStore(boolean onlyPrices) {

		String result = "";

		for (List<List<Guitar>> guitarType : this.getDb().getGuitarTypeList()) {
			for (List<Guitar> guitarBrand : guitarType) {
				for (Guitar guitarTemp : guitarBrand) {
					result += guitarTemp
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
							+ guitarTemp.getModel() + " ";

					if (onlyPrices == false) {
						result += guitarTemp.getFreatboardMaterial() + " "
								+ guitarTemp.isFreatboardGlued() + " "
								+ guitarTemp.getNumberOfStrings() + " "
								+ guitarTemp.getNumberOfFrets() + " "
								+ guitarTemp.getManufacturer() + " ";
					}

					result += guitarTemp.getPrice() + " ";

					if (onlyPrices == true) {
						result += "\n";
						continue;
					}

					if (guitarTemp instanceof ElectricGuitar
							|| (guitarTemp instanceof BassGuitar)) {
						ElectricGuitar valueTemp = (ElectricGuitar) guitarTemp;
						result += valueTemp.getBodyMaterial() + " "
								+ valueTemp.getNeckName() + " "
								+ valueTemp.getBridgeName() + " "
								+ valueTemp.isFloydRose();
					}

					if (guitarTemp instanceof AcousticGuitar) {
						AcousticGuitar valueTemp = (AcousticGuitar) guitarTemp;
						result += valueTemp.isStringsIsNylon();

					}

					result += "\n";
				}
			}

		}
		return result;
	}

	public String printNumberOfGuitarType() {

		String result = "";

		return result += "We have " + db.getNumberOfAcousticGuitar()
				+ " acoustic guitars, " + db.getNumberOfElectricGuitar()
				+ " electric guitars, " + db.getNumberOfBassGuitar()
				+ " bass guitars in the stock\n";

	}

	public String printGuitarByType(GuitarType guitarType, boolean onlyPrices) {

		String result = "";

		int idx = guitarType.ordinal();

		for (List<Guitar> guitarBrandList : db.getGuitarTypeList().get(idx)) {
			for (Guitar guitarTemp : guitarBrandList) {
				result += guitarTemp
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
						+ " ";

				if (onlyPrices == false) {
					result += guitarTemp.getFreatboardMaterial() + " "
							+ guitarTemp.isFreatboardGlued() + " "
							+ guitarTemp.getNumberOfStrings() + " "
							+ guitarTemp.getNumberOfFrets() + " "
							+ guitarTemp.getManufacturer() + " ";
				}

				result += guitarTemp.getPrice() + " ";

				if (onlyPrices == true) {
					result += "\n";
					continue;
				}

				if (guitarTemp instanceof ElectricGuitar
						|| (guitarTemp instanceof BassGuitar)) {
					ElectricGuitar valueTemp = (ElectricGuitar) guitarTemp;
					result += valueTemp.getBodyMaterial() + " "
							+ valueTemp.getNeckName() + " "
							+ valueTemp.getBridgeName() + " "
							+ valueTemp.isFloydRose();
				}

				if (guitarTemp instanceof AcousticGuitar) {
					AcousticGuitar valueTemp = (AcousticGuitar) guitarTemp;
					result += valueTemp.isStringsIsNylon();

				}

				result += "\n";

			}
		}

		return result;

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

	public String printPurchases(Calendar date) {

		int sum = 0;
		int number = 0;
		String result = "";

		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("EEEE dd.MM.YYYY k:mm");

		for (Purchase value : db.getPurchase()) {
			if (value != null) {
				if (date != null) {

					if (value.getDate().getTime() != date.getTime()) {
						continue;
					}

				}

				number++;
				sum += (value.getNumber() * value.getGuitar().getPrice());
				result += "Purchase " + number + " "
						+ value.getCustomer().getName() + " "
						+ value.getGuitar().getGuitarBrand() + " "
						+ value.getGuitar().getModel() + " "
						+ value.getNumber() + " "
						+ (value.getNumber() * value.getGuitar().getPrice())
						+ " " + formatter.format(value.getDate().getTime())
						+ "\n";

			}

		}

		result += "\nAll " + number + " purchases, all wasted money - " + sum
				+ "\n";

		return result;

	}

	public String printNumberOfPurchasesByWeek() {

		String result = "";
		Calendar now = new GregorianCalendar();;
		int[] numberOfPurchaseByWeek = new int[7];

		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("EEEE dd.MM.YYYY");
		
		for (int i = 0; i < numberOfPurchaseByWeek.length; i++) {

			for (Purchase value : db.getPurchase()) {

				{
					String valueDate = formatter.format(value.getDate()
							.getTime());
					String currentDate = formatter.format(now.getTime());
					
					if (valueDate.equals(currentDate)) {
						numberOfPurchaseByWeek[i]++;						
					}

				}

			}

			now.add(Calendar.DATE, -1);
		}

		for (int i = 0; i < numberOfPurchaseByWeek.length; i++) {

			if (i == 0) {
				result += numberOfPurchaseByWeek[i]
						+ " purchases were made today\n";
			} else if (i == 1) {
				result += numberOfPurchaseByWeek[i]
						+ " purchases were made yesterday\n";
			} else
				result += numberOfPurchaseByWeek[i] + " purchases were made "
						+ i + " days ago\n";

		}

		return result;

	}

	public DataBase getDb() {
		return db;
	}

}
