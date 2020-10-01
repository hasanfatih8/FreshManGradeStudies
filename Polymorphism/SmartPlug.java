//Hasan Fatih Baþar - 150118015
/*The aim of this program is to control some smart devices (i.e smart light) 
 * if they're working properly or not and check their properties.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SmartPlug extends SmartObject implements Programmable {
	private boolean status;
	private Calendar programTime;
	private boolean programAction;

	public SmartPlug(String alias, String MacId) {
		setAlias(alias);
		setMacId(MacId);
	}

	// to turn on the plug
	public void turnOn() {
		if (isConnectionStatus()) {
			if (status) {
				System.out.println("Smart Plug - " + getAlias() + " has been already turned on");
			} else {
				System.out.println("Smart Plug - " + getAlias() + " is turned on now (Current time: "
						+ getCurrentTimeString() + ")");
				status = true;
			}
		}
	}

	// to turn off the plug
	public void turnOff() {
		if (isConnectionStatus()) {
			if (status) {
				System.out.println("Smart Plug - " + getAlias() + " is turned off now (Current time: "
						+ getCurrentTimeString() + ")");
				status = false;
			} else {
				System.out.println("Smart Plug - " + getAlias() + " has been already turned off");
			}
		}
	}

	// override abstract methods inherited
	@Override
	public boolean testObject() {
		if (isConnectionStatus()) {
			System.out.println("Test is starting for SmartPlug");
			SmartObjectToString();
			turnOn();
			turnOff();
			System.out.println("Test completed for SmartPlug");
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
			turnOff();
			return true;
		} else {
			return false;
		}
	}

	// override abstract methods implemented
	@Override
	public void setTimer(int seconds) {
		if (isConnectionStatus()) {
			programTime = Calendar.getInstance();
			if (status) {
				System.out.println("Smart plug -" + getAlias() + " will be turned off " + seconds
						+ "  seconds later! (Current Time: " + getCurrentTimeString() + ")");
			} else {
				System.out.println("Smart plug -" + getAlias() + " will be turned on " + seconds
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
						System.out.println("runProgram -> Smart Plug - " + getAlias());
						if(isStatus()) {
							turnOff();
						} else {
							turnOn();
						}
					} 
				}
			}
		}
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
