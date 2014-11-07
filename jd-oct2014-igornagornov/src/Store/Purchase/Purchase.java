package Store.Purchase;

import java.util.Date;

import Store.Service.Store;
import Store.Customer.*;
import Store.Guitar.*;

public class Purchase {

	private static Purchase purchase[] = new Purchase[100];
	private static short id = 0;

	private Customer customer;
	private Guitar guitar;
	private int number;
	private Date date;

	public Purchase(GuitarType guitarType, GuitarBrand guitarBrand,
			String model, int number) {
		// TODO Auto-generated constructor stub
		Customer customerTemp = new Customer();
		customer = customerTemp;

		int k = guitarType.ordinal();
		int i = guitarBrand.ordinal();
		int j = Store.getGuitarIndexByModel(k, i, model);
		this.guitar = Store.getGuitar()[k][i][j];

		this.number = number;
		this.date = new Date();
		id++;

		executePurchase(k, i, j);
	}

	public Purchase(GuitarType guitarType, GuitarBrand guitarBrand,
			String model, int number, String customerName, Date date) {
		// TODO Auto-generated constructor stub
		Customer customer = new Customer(customerName);
		this.customer = customer;

		int k = guitarType.ordinal();
		int i = guitarBrand.ordinal();
		int j = Store.getGuitarIndexByModel(k, i, model);
		this.guitar = Store.getGuitar()[k][i][j];
		this.guitar = Store.getGuitar()[k][i][j];
		;

		this.number = number;
		this.date = date;
		id++;

		executePurchase(k, i, j);
	}

	public static short getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Guitar getGuitar() {
		return guitar;
	}

	public int getNumber() {
		return number;
	}

	public Date getDate() {
		return date;
	}

	public static Purchase[] getPurchase() {
		return purchase;
	}

	public void executePurchase(int k, int i, int j) {

		Store.getGuitar()[k][i][j] = null;

		int kol = 0;
		while (purchase[kol] != null) {
			kol++;
		}
		purchase[kol] = this;

	}

	public static void printPurchases() {

		int sum = 0;
		int number = 0;

		for (Purchase value : purchase) {
			if (value != null) {
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

		if (number != 0) {
			System.out.println("__________________________________________________");
			System.out.println("All " + id					+ " purchases                            " + sum);
		} else
			System.out.println("At this time there is no purchases!");

	}

	public static void printPurchasesByDate(Date date) {

		int sum = 0;
		int number = 0;

		for (Purchase value : purchase) {
			if (value != null && value.getDate().getDate() == date.getDate()) {
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

		if (number != 0) {
			System.out.println("__________________________________________________");
			System.out.println("All " + number					+ " purchases                            " + sum);
		}

		else
			System.out.println("There is no purchases at this date!");

	}

	public static void printNumberOfPurchasesByWeek() {

		Date now = new Date();
		int[] numberOfPurchaseByWeek = new int[7];

		for (Purchase value : purchase) {
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
				System.out.println(numberOfPurchaseByWeek[i]
						+ " purchases were made " + i + " days ago");

		}
		
		System.out.println("__________________________________________________");

	}

}
