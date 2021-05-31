package carFactory;

public class CarFactory {
	public void getCarFactory(String nameCar) {
		if(nameCar.equalsIgnoreCase("Honda")) {
			Honda honda = new Honda();
			honda.driveCar();
			honda.viewCar();
			System.out.println(honda.speedCar());
		}
		else if(nameCar.equalsIgnoreCase("Mazda")) {
			Mazda mazda = new Mazda();
			mazda.driveCar();
			mazda.viewCar();
			System.out.println(mazda.speedCar());
		}
	}
}
