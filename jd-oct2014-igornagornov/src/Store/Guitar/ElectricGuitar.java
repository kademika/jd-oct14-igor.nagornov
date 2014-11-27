package Store.Guitar;

public class ElectricGuitar extends Guitar {
	
	protected String bodyMaterial;
	protected String neckName;
	protected String bridgeName;	
	private boolean isFloydRose;

	public ElectricGuitar() {
		// TODO Auto-generated constructor stub

		super();
		bodyMaterial = "Machogony";
		neckName = "Dimarzio";
		bridgeName = "Dimarzio";
		isFloydRose = true;			
		
	}

	public ElectricGuitar(String bodyMaterial, String neckName,
			String bridgeName, boolean isFloydRose, GuitarBrand guitarBrand,
			String color, String model, FreatboardMaterial freatboardMaterial,
			boolean isFreatboardGlued, int numberOfStrings, int numberOfFrets,
			String manufacturer, int price) {

		super(guitarBrand, color, model, freatboardMaterial, isFreatboardGlued, numberOfStrings, numberOfFrets, manufacturer, price);

		this.bodyMaterial = bodyMaterial;
		this.neckName = neckName;
		this.bridgeName = bridgeName;
		this.isFloydRose = isFloydRose;		

	}

	public String getBodyMaterial() {
		return bodyMaterial;
	}

	public String getNeckName() {
		return neckName;
	}
	
	public String getBridgeName() {
		return bridgeName;
	}	

	public boolean isFloydRose() {
		return isFloydRose;
	}
	
	
}
