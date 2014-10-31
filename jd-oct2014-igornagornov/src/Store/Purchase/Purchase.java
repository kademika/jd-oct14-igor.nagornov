package Store.Purchase;

import Store.Service.Store;
import  Store.Customer.*;
import Store.Guitar.*;

public class Purchase {
	
	private static Purchase purchase[] = new Purchase[100];	
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
	
	public static Purchase[] getPurchase() {
		return purchase;
	}
	
	public void executePurchase(Purchase p, int k, int i, int j) {		

		Store.getGuitar()[k][i][j] = null;

		int kol = 0;
		while (purchase[kol] != null) {
			kol++;
		}
		purchase[kol] = p;
		
	}

	public static void printPurchases() {

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
	
	
	
}
