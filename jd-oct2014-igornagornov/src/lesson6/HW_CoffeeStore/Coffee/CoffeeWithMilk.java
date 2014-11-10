package lesson6.HW_CoffeeStore.Coffee;

public class CoffeeWithMilk extends Coffee {

	public CoffeeWithMilk(boolean sugar) {
		// TODO Auto-generated constructor stub
		coffeeMl = 50;
		MilkMl = 30;		
		waterMl = volume - coffeeMl - MilkMl;
		this.sugar = sugar;

		if (sugar) {
			price = waterMlPrice * waterMl + coffeeMlPrice * coffeeMl
					+ MilkMlPrice * MilkMl + sugarPrice;
		} else {
			price = waterMlPrice * waterMl + coffeeMlPrice * coffeeMl
					+ MilkMlPrice * MilkMl;
		}

	}

	@Override
	public void printComposition() {
		// TODO Auto-generated method stub
		
		System.out.print("Coffee - " + coffeeMl + " ml, ");
		System.out.print("Milk - " + MilkMl + " ml, ");
		System.out.print("Water - " + waterMl + " ml, ");
		if(this.sugar){
			System.out.print("Sugar - yes");
		}
		else{
			System.out.print("Sugar - no");
		}
		
	}



	@Override
	public void printName() {
		// TODO Auto-generated method stub
		System.out.print("Coffee with milk");
	}

}
