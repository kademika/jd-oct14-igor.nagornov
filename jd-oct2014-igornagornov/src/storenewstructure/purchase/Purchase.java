package storenewstructure.purchase;

import java.util.Calendar;
import storenewstructure.customer.Customer;
import storenewstructure.guitar.Guitar;

public class Purchase {

	private Customer customer;
	private Guitar guitar;
	private int number;
	private Calendar date;

	public Purchase() {
		// TODO Auto-generated constructor stub
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

	public Calendar getDate() {
		return date;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setGuitar(Guitar guitar) {
		this.guitar = guitar;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	
	

}
