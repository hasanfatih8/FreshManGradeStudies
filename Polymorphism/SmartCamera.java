//Hasan Fatih Baþar - 150118015
/*The aim of this program is to control some smart devices (i.e smart light) 
 * if they're working properly or not and check their properties.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera> {
	private boolean status;
	private int batteryLife;
	private boolean nightVision;

	public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {
		this.batteryLife = batteryLife;
		this.nightVision = nightVision;
		setAlias(alias);
		setMacId(macId);

	}

	// to start recording for camera
	public void recordOn(boolean isDay) {
		if (isConnectionStatus()) {
			if (!isDay) {
				if (!nightVision) {
					System.out.println("Sorry! Smart Camera - " + getAlias() + " does not have night vision feature.");
					status = false;
				} else {
					if (status) {
						System.out.println("Smart Camera - " + getAlias() + " has been already turned on");
					} else {
						System.out.println("Smart Camera - " + getAlias() + "is turned on now.");
						status = true;
					}
				}
			} else {
				{
					if (status) {
						System.out.println("Smart Camera - " + getAlias() + " has been already turned on");
					} else {
						System.out.println("Smart Camera - " + getAlias() + " is turned on now.");
						status = true;
					}
				}
			}
		}
	}

	// to stop recording for camera
	public void recordOff() {
		if (isConnectionStatus()) {
			if (status) {
				System.out.println("Smart Camera -" + getAlias() + " is turned off now.");
				status = false;
			} else {
				System.out.println("Smart Camera - " + getAlias() + " has been already turned off");
			}
		}
	}

	// abstract methods overridden inherited
	@Override
	public boolean testObject() {
		if (isConnectionStatus()) {
			System.out.println("Test is starting for SmartCamera");
			SmartObjectToString();
			System.out.println("Test is starting for SmartCamera day time");
			recordOn(true);
			recordOff();
			System.out.println("Test is starting for SmartCamera night time");
			recordOn(false);
			recordOff();
			System.out.println("Test completed for SmartCamera");
			System.out.println();

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean shutDownObject() {
		if (isConnectionStatus()) {
			SmartObjectToString();
			recordOff();
			return true;
		} else {
			return false;
		}

	}

	// abstract methods overridden implemented
	@Override
	public int compareTo(SmartCamera o) {
		if (batteryLife > o.getBatteryLife()) {
			return 1;
		} else if (batteryLife < o.getBatteryLife()) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean controlMotion(boolean hasMotion, boolean isDay) {
		if (hasMotion) {
			System.out.println("Motion dedected!");
			if (isDay) {
				recordOn(isDay);
			} else {
				if (nightVision) {
					recordOn(isDay);
				}
			}
			return true;
		} else {
			System.out.println("Motion not dedected!");
			return false;

		}
	}

	// toString method
	@Override
	public String toString() {
		return "SmartCamera ->" + getAlias() + "'s battery life is " + getBatteryLife() + " status is recording";
	}

	// getter/setter methods
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}

	public boolean isNightVision() {
		return nightVision;
	}

	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}

	// extra methods to get current time
	public String getCurrentTime(Calendar cal) {
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}

	public String getCurrentTimeString() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}

}
