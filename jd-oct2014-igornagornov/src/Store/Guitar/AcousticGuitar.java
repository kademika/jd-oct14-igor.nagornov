package Store.Guitar;

public class AcousticGuitar extends Guitar {

	private boolean stringsIsNylon;
	private static int countAcousticGuitar=0;

	public AcousticGuitar() {
		super();
		this.stringsIsNylon = false;		
	}

	public AcousticGuitar(GuitarBrand guitarBrand, String color, String model,
			FreatboardMaterial freatboardMaterial, boolean isFreatboardGlued,
			int numberOfStrings, int numberOfFrets, String manufacturer,
			int price, boolean stringsIsNylon) {

		super(guitarBrand, color, model, freatboardMaterial, isFreatboardGlued,
				numberOfStrings, numberOfFrets, manufacturer, price);			

		this.stringsIsNylon = stringsIsNylon;		

	}

	public boolean isStringsIsNylon() {
		return stringsIsNylon;
	}

	public static int getCountAcousticGuitar() {
		return countAcousticGuitar;
	}
	
	public static void increaseCountAcousticGuitar(){
		countAcousticGuitar++;
	}
}
