import java.util.Calendar;

public class RegularEmployee extends Employee {
	private double performanceScore;
	private double bonus;
	public static int numberOfEmployees;
	//the first constructor of RegularEmployee class
	public RegularEmployee( String firstName, String lastName, int id, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore) {
		super(firstName, lastName, id, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate,
				department);
		this.performanceScore = performanceScore;
		numberOfEmployees++;
	}
	//the second constructor of RegularEmployee class
	public RegularEmployee(Employee employee, double performanceScore) {
		super( employee.getFirstName(), employee.getLastName(), employee.getId(), employee.getGender(), employee.getBirthDate(),
				employee.getMaritalStatus(), employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(),
				employee.getDepartment());
		this.performanceScore = performanceScore;

	}
	// GETTER AND SETTER METHODS
	public double getPerformanceScore() {
		return performanceScore;
	}

	public void setPerformanceScore(double performanceScore) {
		this.performanceScore = performanceScore;
	}
	// GETTER AND SETTER METHODS
	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	//toString method
	@Override
	public String toString() {
		return super.toString() + "\nPerformance Score: " + this.performanceScore + "\nBonus: " + this.bonus;
	}
}
