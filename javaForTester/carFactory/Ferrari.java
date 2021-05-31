package carFactory;

public class Ferrari implements ICar {

	@Override
	public void driveCar() {
		// TODO Auto-generated method stub
		System.out.println("drive Ferrari Car");
	}

	@Override
	public void viewCar() {
		// TODO Auto-generated method stub
		System.out.println("view Ferrari Car");
	}

	@Override
	public double speedCar() {
		// TODO Auto-generated method stub
		return 450;
	}
}
