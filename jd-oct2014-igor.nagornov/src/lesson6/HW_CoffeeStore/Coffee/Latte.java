package lesson6.HW_CoffeeStore.Coffee;

public class Latte extends Coffee{	
	
	private int frothedMilkMl;
	private final float frothedMilkMLPrice = 0.2f;
	
	public Latte(boolean sugar) {		
		
		coffeeMl = 66;
		MilkMl = 66;		
		frothedMilkMl = volume - coffeeMl - MilkMl;
		this.sugar = sugar;

		if (sugar) {
			price = coffeeMlPrice * coffeeMl + MilkMlPrice * MilkMl
					+ frothedMilkMLPrice * frothedMilkMl + sugarPrice;
		} else {
			price = coffeeMlPrice * coffeeMl + MilkMlPrice * MilkMl
					+ frothedMilkMLPrice * frothedMilkMl;
		}
	}

	@Override
	public void printComposition() {
		// TODO Auto-generated method stub
		System.out.print("Coffee - " + coffeeMl + " ml, ");
		System.out.print("Milk - " + MilkMl + " ml, ");
		System.out.print("Frothed Milk - " + frothedMilkMl + " ml, ");
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
		System.out.print("Latte");
	}

	

}
