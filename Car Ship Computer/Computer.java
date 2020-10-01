
public class Computer extends Machine {
	
	public Computer(int type) {
		super(type);
	}

	@Override
	void mainProperty() {
		System.out.println("I have CPU.");
	}

	@Override
	void howItWorks() {
		System.out.println("I need electricity to run.");
	}
	

}
