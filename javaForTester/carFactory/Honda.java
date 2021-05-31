package carFactory;

public class Honda implements ICar {
	
	@Override
	public void driveCar() {
		System.out.println("drive Honda Car");		
	}

	@Override
	public void viewCar() {
		System.out.println("wiew Honda Car");
		
	}

	@Override
	public double speedCar() {
		// TODO Auto-generated method stub
		return 200;
	}
	

}
