import java.util.ArrayList;
import java.util.Calendar;

public class Developer extends RegularEmployee {
	private ArrayList<Project> projects;
	public static int numberOfDevelopers;

	public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore,
			ArrayList<Project> p) {
		super( firstName, lastName, id, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
				performanceScore);
		this.projects = p;
		numberOfDevelopers++;
	}

	public Developer(RegularEmployee re, ArrayList<Project> p) {
		super(re.getFirstName(), re.getLastName(), re.getId(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(),
				re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(),
				re.getPerformanceScore());
		this.projects = p;
	}

	public boolean addProject(Project p) {
		return this.projects.add(p);
	}

	public boolean removeProject(Project p) {
		return this.projects.remove(p);
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return super.toString() + "\nProjects= " + projects;
	}

}
