
public class Car extends Machine implements Drivable {
	
	public Car(int type) {
		super(type);
	}
	
	@Override
	public void howToDrive() {
		System.out.println("Use my steering wheel to drive.");
		
	}

	@Override
	void mainProperty() {
		System.out.println("I have 4 wheels");
	}

	@Override
	void howItWorks() {
		System.out.println("I need fuel to run.");
	}

	
}
