package lesson6.Video22ConstructorsAndPolymorf;

public class StartGlyph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Glyph glyph = new RoundGlyph(10); // metod draw klassa RoundGlyph vyzivaetsya vo vseh klassah
		glyph.draw();
		
		new GlyphSon(); //v konstruktore Glyph vyzovetsya metod draw klassa GlyphSon do togo, 
	}						//kak budet inicializirovano pole name, poetomu NPE

}
