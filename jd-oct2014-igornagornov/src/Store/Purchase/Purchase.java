package Store.Purchase;

import java.util.Date;
import Store.Customer.*;
import Store.Guitar.*;

public class Purchase {

	private Customer customer;
	private Guitar guitar;
	private int number;
	private Date date;

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

	public Date getDate() {
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

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
