package carFactory;

public class Mazda implements ICar{

	@Override
	public void viewCar() {
		// TODO Auto-generated method stub
		System.out.println("view Mazda car");
	}

	@Override
	public void driveCar() {
		// TODO Auto-generated method stub
		System.out.println("drive Mazda car");
	}

	@Override
	public double speedCar() {
		// TODO Auto-generated method stub
		return 160;
	}


}
