package lesson6.Video22ConstructorsAndPolymorf;

public class RoundGlyph extends Glyph{

	private int radius = 5;
	
	RoundGlyph(int radius){
		System.out.println("RoundGlyph constructor");
		draw();
		this.radius = radius;
		
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("RoundGlyph is drawing");
		System.out.println("RoundGlyph radius is " + radius + " now");
	}
	
}
