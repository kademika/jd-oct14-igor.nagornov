package lesson6.HW_CoffeeStore.Coffee;

public abstract class Coffee {

	protected final int volume = 200;
	
	protected int waterMl;
	protected int coffeeMl;
	protected int MilkMl;	
	protected boolean sugar;
	protected final float waterMlPrice = 0.05f;
	protected final float coffeeMlPrice = 0.25f;	
	protected final float MilkMlPrice = 0.15f;
	protected final float sugarPrice = 1f;
	protected float price;

	public float getPrice(){
		return price;
	}
	
	public abstract void printName();
	public abstract void printComposition();
}
