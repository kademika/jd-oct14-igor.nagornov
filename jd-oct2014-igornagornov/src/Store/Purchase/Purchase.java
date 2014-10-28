package Store.Purchase;
import java.util.Date;

import  Store.Customer.*;
import Store.Guitar.*;

public class Purchase {
	
	private static short id=0;
	private Customer customer;
	private Guitar guitar;
	private int number;
	private String date;
	
	public Purchase(Guitar guitar, int number) {
		// TODO Auto-generated constructor stub
		Customer customerTemp = new Customer();
		customer = customerTemp;
		this.guitar = guitar;
		this.number = number;
		this.date = "29.10.2014";
		id++;
	}
	
	public Purchase(Guitar guitar, int number, String name) {
		// TODO Auto-generated constructor stub
		Customer customer = new Customer(name);
		this.customer = customer;
		this.guitar = guitar;
		this.number = number;
		date = "28.10.2014";
		id++;
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
	public String getDate() {
		return date;
	}
	
	
	
}
