import java.util.Calendar;

public class Project {
	private String projectName;
	private java.util.Calendar startDate;
	private boolean state;

	// constructor or Project class
	public Project(String pName, Calendar startDate, String state) {
		this.projectName = pName;
		this.startDate = startDate;
		setState(state);

	}
	
	// GETTER AND SETTER METHODS
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	// GETTER AND SETTER METHODS
	public java.util.Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Calendar startDate) {
		this.startDate = startDate;
	}
	// GETTER AND SETTER METHODS
	public String getState() {
		if (state == true) {
			return "Open";
		} else if(!state){
			return "Close";
		}else {
			return "error";
		}
	}
	public void setState(String state) {
		if (state.equalsIgnoreCase("Open")) {
			this.state = true;
		} else  {
			this.state = false;
		}
	}
	// close method
	public void close() {
		setState("Close");
	}

	//toString method
	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", startDate=" + Test.makeStringDate(startDate) + ", state=" + state + "]";
	}

	
}
