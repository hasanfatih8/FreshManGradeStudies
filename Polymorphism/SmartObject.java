//Hasan Fatih Baþar - 150118015
/*The aim of this program is to control some smart devices (i.e smart light) 
 * if they're working properly or not and check their properties.
 */

public abstract class SmartObject {
	
	private String alias;
	private String macId;
	private String IP;
	private boolean connectionStatus;

	public SmartObject() {
	}

	// connect
	public boolean connect(String IP) {
		this.IP = IP;
		System.out.println(getAlias() + " connection is established.");
		connectionStatus = true;
		return true;
	}

	// disconnect 
	public boolean disconnect() {
		this.IP = null;
		connectionStatus = false;
		return true;
	}

	// toString
	public void SmartObjectToString() {
		System.out.println("This is " + getClass().getSimpleName() + " device " + getAlias() + "\n\tMacId: " + getMacId()
				+ "\n\tIP: " + getIP());
	}

	// control connection
	public boolean controlConnection() {
		if (connectionStatus) {
			
			return true;
		} else {
			System.out.println("This device is not connected. " + getClass().getSimpleName() + " -> " + getAlias());
			return true;
		}
	}

	// abstract methods
	public abstract boolean testObject();

	public abstract boolean shutDownObject();

	// getter/setter methods
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public boolean isConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

}
