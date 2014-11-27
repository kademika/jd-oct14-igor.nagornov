package Store.Purchase;

import java.util.Date;

import Store.Service.Store;
import Store.Customer.*;
import Store.Guitar.*;

public class Purchase {

	private Customer customer;
	private Guitar guitar;
	private int number;
	private Date date;

	public Purchase(Store store, GuitarType guitarType,
			GuitarBrand guitarBrand, String model, int number) {
		// TODO Auto-generated constructor stub
		Customer customerTemp = new Customer();
		customer = customerTemp;
		int k = guitarType.ordinal();
		int i = guitarBrand.ordinal();
		int j = store.getGuitarIndexByModel(k, i, model);
		this.number = number;
		this.date = new Date();

		try {
			if (j != -1) {

				this.guitar = store.getGuitar()[k][i][j];
				executePurchase(store, k, i, model, number);

			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.err.println("There is no such guitar in store!");
		} catch (IllegalStateException e) {
			System.err.println("Illegal number! We don't have it in store");
		}

	}

	public Purchase(Store store, GuitarType guitarType,
			GuitarBrand guitarBrand, String model, int number,
			String customerName, Date date) {
		// TODO Auto-generated constructor stub
		Customer customer = new Customer(customerName);
		this.customer = customer;
		int k = guitarType.ordinal();
		int i = guitarBrand.ordinal();
		int j = store.getGuitarIndexByModel(k, i, model);
		this.number = number;
		this.date = date;

		try {
			if (j != -1) {

				this.guitar = store.getGuitar()[k][i][j];
				executePurchase(store, k, i, model, number);

			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.err.println("There is no such guitar in store!");
		} catch (IllegalStateException e) {
			System.err.println("Illegal number! We don't have it in store");
		}

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

	private void executePurchase(Store store, int k, int i, String model,
			int number) throws IllegalStateException {

		if (number < 1 || number > store.getGuitarNumberByModel(k, i, model)) {
			throw new IllegalStateException();
		}

		for (int idx = 0; idx < number; idx++) {
			int j = store.getGuitarIndexByModel(k, i, model);
			if (store.getGuitar()[k][i][j] instanceof AcousticGuitar) {
				store.decreaseNumberOfAcousticGuitar();
			}

			if (store.getGuitar()[k][i][j] instanceof ElectricGuitar
					&& !(store.getGuitar()[k][i][j] instanceof BassGuitar)) {
				store.decreasenumberOfElecticGuitar();
			}

			if (store.getGuitar()[k][i][j] instanceof BassGuitar) {
				store.decreaseNumberOfBassGuitar();
			}
			store.getGuitar()[k][i][j] = null;

		}

		store.getPurchase().add(this);

	}

}
