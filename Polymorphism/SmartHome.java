//Hasan Fatih Baþar - 150118015
/*The aim of this program is to control some smart devices (i.e smart light) 
 * if they're working properly or not and check their properties.
 */

import java.util.ArrayList;

public class SmartHome {
	private ArrayList<SmartObject> smartObjectList = new ArrayList<>();
	public static int ip = 100;

	// constructor of SmartHome
	public SmartHome() {

	}

	// add method
	public boolean addSmartObject(SmartObject smartObject) {
		smartObjectList.add(smartObject);
		System.out.println("----------------------------------------------------------");
		System.out.println("----------------------------------------------------------");
		System.out.println("Adding new Smart Object");
		System.out.println("----------------------------------------------------------");
		smartObject.setIP("10.0.0." + convertIpToString(increaseIp(ip)));
		smartObject.connect(smartObject.getIP());
		smartObject.testObject();
		return true;
	}

	// remove method
	public boolean removeSmartObject(SmartObject smartObject) {
		smartObjectList.remove(smartObject);
		return true;
	}

	
	public void controlLocation(boolean onCome) {
		System.out.println("----------------------------------------------------------");
		System.out.println("----------------------------------------------------------");
		System.out.println("LocationControl : onCome");
		System.out.println("----------------------------------------------------------");
		for (SmartObject smartObject : smartObjectList) {
			if (smartObject instanceof LocationControl) {
				if (onCome) {
					((LocationControl) smartObject).onCome();
				} else {
					((LocationControl) smartObject).onLeave();
				}

			}
		}
	}

	// to control is there any motion or not
	public void controlMotion(boolean hasMotion, boolean isDay) {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("MotionControl: HasMotion, isDay");
		System.out.println("--------------------------------------------------------------------------");
		for (SmartObject smartObject : smartObjectList) {
			if (smartObject instanceof MotionControl) {
				if (hasMotion) {
					((MotionControl) smartObject).controlMotion(hasMotion, isDay);
				} else {
					((MotionControl) smartObject).controlMotion(hasMotion, isDay);
				}

			}
		}
	}

	// to control objects if implements runProgram interface
	public void controlProgrammable() {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Programmable: runProgram");
		System.out.println("--------------------------------------------------------------------------");
		for (SmartObject smartObject : smartObjectList) {
			if (smartObject instanceof Programmable) {
				((Programmable) smartObject).runProgram();
			}
		}
	}

	// to control the timer method by given value
	public void controlTimer(int seconds) {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Programmable: Timer = " + seconds + "seconds");
		System.out.println("--------------------------------------------------------------------------");

		for (SmartObject smartObject : smartObjectList) {
			if (smartObject instanceof Programmable) {
				if (seconds == 0) {
					((Programmable) smartObject).cancelTimer();
				} else {
					((Programmable) smartObject).setTimer(seconds);
				}
			}
		}

	}
	
	//to control the timer method randomly
	public void controlTimerRandomly() {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Programmable: Timer = 0, 5 or 10 seconds randomly");
		System.out.println("--------------------------------------------------------------------------");
		int[] randomSecArray = {0, 5, 10};
		for (SmartObject smartObject : smartObjectList) {
			int randomSec = randomSecArray[(int) (Math.random() * 3)];
			if (smartObject instanceof Programmable) {

				if (randomSec == 5 || randomSec == 10) {
					((Programmable) smartObject).setTimer(randomSec);
				} else {
					((Programmable) smartObject).cancelTimer();
				}
			}
		}
	}

	// to sort cameras according to battery life
	public void sortCameras() {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Sort Smart Cameras");
		System.out.println("--------------------------------------------------------------------------");
		ArrayList<Object> smartCameraList = new ArrayList<>();
		for (SmartObject smartObject : smartObjectList) {
			if (smartObject instanceof SmartCamera) {
				smartCameraList.add(smartObject);
			}
		}
		Object[] smartCameraArray = smartCameraList.toArray();
		java.util.Arrays.sort(smartCameraArray);
		for (Object object : smartCameraArray) {
			System.out.println(object + " ");
		}

	}

	// extra methods to arrange ip
	public static int increaseIp(int a) {
		a = ip++;
		return a;
	}

	public String convertIpToString(int a) {
		String idString = String.valueOf(a);
		return idString;
	}
}
