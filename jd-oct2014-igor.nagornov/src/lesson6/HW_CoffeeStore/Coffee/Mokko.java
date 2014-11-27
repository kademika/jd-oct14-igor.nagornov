package lesson6.HW_CoffeeStore.Coffee;

public class Mokko extends Coffee{
	
	private int whippedCreamMl;
	private int chocolateMl;
	private final float whippedCreamMlPrice = 0.2f;
	private final float chocolateMlPrice = 0.5f;

	public Mokko(boolean sugar) {
		// TODO Auto-generated constructor stub

		coffeeMl = 50;
		MilkMl = 50;
		chocolateMl = 50;		
		whippedCreamMl = volume - coffeeMl - MilkMl - chocolateMl;
		this.sugar = sugar;

		if (sugar) {
			price = coffeeMlPrice * coffeeMl + MilkMlPrice * MilkMl
					+ + chocolateMl*chocolateMlPrice + whippedCreamMlPrice * whippedCreamMl + sugarPrice;
		} else {
			price = coffeeMlPrice * coffeeMl + MilkMlPrice * MilkMl
					+ + chocolateMl*chocolateMlPrice + whippedCreamMlPrice * whippedCreamMl;
		}

	}


	@Override
	public void printComposition() {
		// TODO Auto-generated method stub
		System.out.print("Coffee - " + coffeeMl + " ml, ");
		System.out.print("Milk - " + MilkMl + " ml, ");
		System.out.print("Whipped Cream - " + whippedCreamMl + " ml, ");
		System.out.print("Chocolate - " + chocolateMl + " ml, ");
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
		System.out.print("Mokka");
	}

}
