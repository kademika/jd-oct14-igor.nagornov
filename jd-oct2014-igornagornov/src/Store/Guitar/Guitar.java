package Store.Guitar;

public class Guitar {
	
	protected GuitarBrand guitarBrand;	
	protected String model;
	protected String color;
	protected FreatboardMaterial freatboardMaterial;
	protected boolean isFreatboardGlued;
	protected int numberOfStrings;
	protected int numberOfFrets;
	protected String manufacturer;
	protected int price;

	public Guitar() {
		this(GuitarBrand.IBANEZ, "Black", "Indonezia", 20000);
	}

	public Guitar(GuitarBrand guitarBrand, String color, String manufacturer,
			int price) {
		this.guitarBrand = guitarBrand;
		model = "JFX500";
		this.color = color;
		freatboardMaterial = FreatboardMaterial.MAPLE;
		isFreatboardGlued = true;
		numberOfStrings = 6;
		numberOfFrets = 24;
		this.manufacturer = manufacturer;
		this.price = price;

	}

	public Guitar(GuitarBrand guitarBrand, String color, String model,
			FreatboardMaterial freatboardMaterial, boolean isFreatboardGlued,
			int numberOfStrings, int numberOfFrets, String manufacturer,
			int price) {

		this.guitarBrand = guitarBrand;
		this.color = color;
		this.model = model;
		this.freatboardMaterial = freatboardMaterial;
		this.isFreatboardGlued = isFreatboardGlued;
		this.numberOfStrings = numberOfStrings;
		this.numberOfFrets = numberOfFrets;
		this.manufacturer = manufacturer;
		this.price = price;
	}

	public GuitarBrand getGuitarBrand() {
		return guitarBrand;
	}

	public FreatboardMaterial getFreatboardMaterial() {
		return freatboardMaterial;
	}

	public boolean isFreatboardGlued() {
		return isFreatboardGlued;
	}

	public int getNumberOfStrings() {
		return numberOfStrings;
	}

	public int getNumberOfFrets() {
		return numberOfFrets;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public int getPrice() {
		return price;
	}

	public String getColor() {
		return color;
	}

	public String getModel() {
		return model;
	}


}
