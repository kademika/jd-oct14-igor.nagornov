package lesson6.HW_CoffeeStore;

import lesson6.HW_CoffeeStore.Coffee.Americano;
import lesson6.HW_CoffeeStore.Coffee.Capuchino;
import lesson6.HW_CoffeeStore.Coffee.Coffee;
import lesson6.HW_CoffeeStore.Coffee.CoffeeWithMilk;
import lesson6.HW_CoffeeStore.Coffee.Latte;
import lesson6.HW_CoffeeStore.Coffee.Mokko;

public class MakeDrink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Americano a = new Americano(false);
		printInfo(a);
		
		CoffeeWithMilk c = new CoffeeWithMilk(true);
		printInfo(c);
		
		Capuchino cpc = new Capuchino(true);
		printInfo(cpc);
		
		Latte l = new Latte(false);
		printInfo(l);
		
		Mokko m = new Mokko(false);
		printInfo(m);

	}

	private static void printInfo(Coffee c) {
		c.printName();
		System.out.print(", composition: ");
		c.printComposition();
		System.out.println(", Price - " + c.getPrice());
	}

}
