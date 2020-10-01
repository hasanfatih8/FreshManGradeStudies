
public class Ship extends Machine implements Drivable {

	public Ship(int type) {
		super(type);
	}
	
	@Override
	public void howToDrive() {
		System.out.println("Use my rudder.");
	}

	@Override
	void mainProperty() {
		System.out.println("I have anchor.");
	}

	@Override
	void howItWorks() {
		System.out.println("I need fuel to run.");
	}

}
