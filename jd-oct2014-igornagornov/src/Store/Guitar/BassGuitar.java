package Store.Guitar;

public class BassGuitar extends ElectricGuitar {
	
	private static int countBassGuitar=0;

	public BassGuitar() {		
		guitarBrand = GuitarBrand.ESP;
		model = "JHGG700";
		color = "red";
		freatboardMaterial = FreatboardMaterial.MAPLE;
		isFreatboardGlued = true;
		numberOfStrings = 6;
		numberOfFrets = 24;
		manufacturer = "USA";
		price = 45000;
		bodyMaterial = "Machogony";
		neckName = "Dimarzio";
		bridgeName = "EMG";		
		numberOfStrings = 4;
		countBassGuitar++;

	}

	public BassGuitar(String bodyMaterial, String neckName, String bridgeName,
			boolean isFloydRose, GuitarBrand guitarBrand, String color,
			String model, FreatboardMaterial freatboardMaterial,
			boolean isFreatboardGlued, int numberOfStrings, int numberOfFrets,
			String manufacturer, int price) {

		this.guitarBrand = guitarBrand;
		this.color = color;
		this.model = model;				
		this.freatboardMaterial = freatboardMaterial;
		this.isFreatboardGlued = isFreatboardGlued;
		this.numberOfStrings = numberOfStrings;
		this.numberOfFrets = numberOfFrets;
		this.manufacturer = manufacturer;
		this.price = price;
		this.bodyMaterial = bodyMaterial;
		this.neckName = neckName;
		this.bridgeName = bridgeName;
				
		countBassGuitar++;

	}

	public static int getCountBassGuitar() {
		return countBassGuitar;
	}

	
}
