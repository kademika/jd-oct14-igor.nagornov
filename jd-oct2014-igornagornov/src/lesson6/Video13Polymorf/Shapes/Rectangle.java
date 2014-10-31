package lesson6.Video13Polymorf.Shapes;

public class Rectangle extends Shape{
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("I'm rectangle");//если у данного класса нет своего метода draw, 
										//он запускает его из класса выше по иерархии
	}
}
