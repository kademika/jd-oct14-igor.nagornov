package lesson4.HW_Car;

public class CarLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car = new Car(Color.GREY, TransBoxType.MT);
		printCarInfo(car);
		Car car2 = new Car(Color.BLUE, TransBoxType.AT);		
		printCarInfo(car2);	
		Car car3 = new Car();
		printCarInfo(car3);	

	}
	
	private static void printCarInfo(Car car){
		System.out.println(car.getModelName());
		System.out.println(car.getColor());
		System.out.println(car.getEngineVolume());
		System.out.println(car.getNumberOfHorseForces());
		System.out.println(car.getDriveType());
		System.out.println(car.getFuelType());
		System.out.println(car.getTransBoxType());
		System.out.println(car.getNumberOfDoors());
		System.out.println(car.getMaxSpeed());
		System.out.println(car.getPrice());
		System.out.println();
	}

}
