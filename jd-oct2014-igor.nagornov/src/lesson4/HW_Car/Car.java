package lesson4.HW_Car;

public class Car {
	
	private String modelName;
	private Color color;
	private float engineVolume;
	private short numberOfHorseForces;
	private DriveType driveType;
	private FuelType fuelType;
	private TransBoxType transBoxType;
	private int numberOfDoors;
	private int maxSpeed;
	private int price;
	
	public Car(){
		
		this.modelName = "Chevrolet Aveo";
		this.color = color.WHITE;
		this.engineVolume = 1.6f;
		this.numberOfHorseForces = 106;
		this.driveType = driveType.FRONTWHEELDRIVE;
		this.fuelType = fuelType.BENZINE_95;
		this.transBoxType = transBoxType.MT;
		this.numberOfDoors = 5;
		this.maxSpeed = 180;
		this.price = 500000;
		
		
	}
	
	public Car(String modelName, Color color, float engineVolume, short numberOfHorseForces, DriveType driveType, 
			FuelType fuelType, TransBoxType transBoxType, int numberOfDoors, 
				int maxSpeed, int price){
		this.modelName = modelName;
		this.color = color;
		this.engineVolume = engineVolume;
		this.numberOfHorseForces = numberOfHorseForces;
		this.driveType = driveType;
		this.fuelType = fuelType;
		this.transBoxType = transBoxType;
		this.numberOfDoors = numberOfDoors;
		this.maxSpeed = maxSpeed;
		this.price = price;
		
	}
	
	public Car(Color color, TransBoxType transBoxType){
		
		this.modelName = "Chevrolet Aveo";
		this.color = color;
		this.engineVolume = 1.6f;
		this.numberOfHorseForces = 106;
		this.driveType = driveType.FRONTWHEELDRIVE;
		this.fuelType = fuelType.BENZINE_95;
		this.transBoxType = transBoxType;
		this.numberOfDoors = 5;
		this.maxSpeed = 180;
		this.price = 500000;
		
		
	}


	public String getModelName() {
		return modelName;
	}

	public Color getColor() {
		return color;
	}

	public float getEngineVolume() {
		return engineVolume;
	}

	public DriveType getDriveType() {
		return driveType;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public short getNumberOfHorseForces() {
		return numberOfHorseForces;
	}

	public TransBoxType getTransBoxType() {
		return transBoxType;
	}


	public int getNumberOfDoors() {
		return numberOfDoors;
	}


	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getPrice() {
		return price;
	}	
	
}
