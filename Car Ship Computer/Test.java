public class Test {

	public static void main(String[] args) {
		
		Machine[] machines = new Machine[5];

		machines[0] = new Car(1);
		machines[1] = new Computer(2);
		machines[2] = new Computer(2);
		machines[3] = new Ship(3);
		machines[4] = new Ship(3);
		
		for (int i = 0; i < machines.length; i++) {
			if(machines[i].getType() == 1) {
				System.out.println("Machine type: Car / " + machines[i].getType());
			} else if(machines[i].getType() == 2) {
				System.out.println("Machine type: Computer / " + machines[i].getType());
			} else if(machines[i].getType() == 3) {
				System.out.println("Machine type: Ship / " + machines[i].getType());
				
			}
		}
		
		for (int i = 0; i < machines.length; i++) {
			if(machines[i] instanceof Drivable) {
				Drivable temp = (Drivable)machines[i];
				temp.howToDrive();
			}
			
		}
		
		for (int i = 0; i < machines.length; i++) {
			if(machines[i].getType() == 2) {
				machines[i].howItWorks();
			}
		}
		
		for (int i = 0; i < machines.length; i++) {
			if(machines[i].getType() == 3) {
				machines[i].mainProperty();
			}
		}
		
	}

}
