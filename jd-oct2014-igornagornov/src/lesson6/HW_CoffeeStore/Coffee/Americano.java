package lesson6.HW_CoffeeStore.Coffee;

public class Americano extends Coffee {

	public Americano(boolean sugar) {
		coffeeMl = 30;		
		waterMl = volume - coffeeMl;
		this.sugar = sugar;
		
		if(sugar) {
			price = waterMlPrice * waterMl + coffeeMlPrice * coffeeMl + sugarPrice;
		}
		else {
			price = waterMlPrice * waterMl + coffeeMlPrice * coffeeMl;
		}
			
	}


	@Override
	public void printComposition() {
		// TODO Auto-generated method stub
		System.out.print("Coffee - " + coffeeMl + " ml, ");		
		System.out.print("Water - " + waterMl + " ml ");
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
		System.out.print("Americano");
	}
	

}
