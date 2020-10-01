
public abstract class Machine {
	
	private int Type;
	
	public Machine(int type) {
		setType(type);
	}

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		this.Type = type;
	}
	
	abstract void mainProperty();
	abstract void howItWorks();
	
}
