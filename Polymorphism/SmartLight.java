//Hasan Fatih Baþar - 150118015
/*The aim of this program is to control some smart devices (i.e smart light) 
 * if they're working properly or not and check their properties.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SmartLight extends SmartObject implements LocationControl, Programmable {
	private boolean hasLightTurned;
	private Calendar programTime;
	private boolean programAction;

	public SmartLight(String alias, String MacId) {
		setAlias(alias);
		setMacId(MacId);
	}

	// to turn on the light
	public void turnOnLight() {
		if (isConnectionStatus()) {
			if (hasLightTurned) {
				System.out.println("Smart Light - " + getAlias() + " has been already turned on");
			} else {
				System.out.println("Smart Light - " + getAlias() + " is turned on now (Current time: "
						+ getCurrentTimeString() + ")");
				hasLightTurned = true;
			}
		}
	}

	// to turn off the light
	public void turnOffLight() {
		if (isConnectionStatus()) {
			if (hasLightTurned) {
				System.out.println("Smart Light - " + getAlias() + " Light is turned off now (Current time: "
						+ getCurrentTimeString() + ")");
				hasLightTurned = false;
			} else {
				System.out.println("Smart Light - " + getAlias() + " Light has been already turned on");
			}
		}
	}

	// override LocationControl methods
	@Override
	public void onLeave() {
		if (isConnectionStatus()) {
			System.out.println("On Leave -> Smart Light -" + getAlias() + " Light");
			turnOffLight();
		}

	}

	@Override
	public void onCome() {
		if (isConnectionStatus()) {
			System.out.println("On Come -> Smart Light - " + getAlias() + " Light");
			turnOnLight();
		}

	}

	// override Programmable methods
	@Override
	public void setTimer(int seconds) {
		if (isConnectionStatus()) {
			programTime = Calendar.getInstance();
			if (hasLightTurned) {
				System.out.println("Smart light - " + getAlias() + " will be turned off " + seconds
						+ "  seconds later! (Current Time: " + getCurrentTimeString() + ")");
			} else {
				System.out.println("Smart light - " + getAlias() + " will be turned on " + seconds
						+ "  seconds later! (Current Time: " + getCurrentTimeString() + ")");
			}
			programTime.add(Calendar.SECOND, seconds);
		}
	}

	@Override
	public void cancelTimer() {
		if (isConnectionStatus()) {
			this.programTime = null;
		}

	}

	@Override
	public void runProgram() {
		if (isConnectionStatus()) {
			if (programTime != null) {
				if (getCurrentTime(programTime).equals(getCurrentTimeString())) {
					if (!programAction) {
						programAction = true;
						System.out.println("runProgram -> Smart Light - " + getAlias());
						if (isHasLightTurned()) {
							turnOffLight();
						} else {
							turnOnLight();
						}
					}
				}
			}
		}
	}

	// override super abstract methods
	@Override
	public boolean testObject() {
		if (isConnectionStatus()) {
			System.out.println("Test is starting for SmartLight");
			SmartObjectToString();
			System.out.println();
			turnOnLight();
			turnOffLight();
			System.out.println("Test completed for SmartLight");
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
			turnOffLight();
			return true;
		} else {
			return false;
		}
	}

	// getter/setter methods
	public boolean isHasLightTurned() {
		return hasLightTurned;
	}

	public void setHasLightTurned(boolean hasLightTurned) {
		this.hasLightTurned = hasLightTurned;
	}

	public Calendar getProgramTime() {
		return programTime;
	}

	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}

	public boolean isProgramAction() {
		return programAction;
	}

	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}

	// extra methods to get current time in the HH:mm:ss format
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
