import java.util.ArrayList;
import java.util.Calendar;

//ÇOK ÝÞ VAR ÇOK
public class Manager extends Employee {
	private ArrayList<RegularEmployee> regularEmployees;
	private double bonusBudget;

	public Manager( String firstName, String lastName, int id, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double bonusBudget) {
		super(firstName, lastName, id, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate,
				department);
		this.bonusBudget = bonusBudget;
	}

	public Manager(Employee employee, double bonusBudget) {
		super( employee.getFirstName(), employee.getLastName(), employee.getId(), employee.getGender(),
				employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicence(),
				employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		this.bonusBudget = bonusBudget;
	}
	// GETTER AND SETTER METHODS
	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}

	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		this.regularEmployees = regularEmployees;
	}
	// GETTER AND SETTER METHODS
	public double getBonusBudget() {
		return bonusBudget;
	}

	public void setBonusBudget(double bonusBudget) {
		this.bonusBudget = bonusBudget;
	}
	//add employee method
	public void addEmployee(RegularEmployee e) {
		this.regularEmployees.add(e);
	}
	//remove employee method
	public void removeEmployee(RegularEmployee e) {
		this.regularEmployees.remove(e);
	}
	
	//distribute method
	public void distributeBonusBudget() {
		double unit = 0;
		for (RegularEmployee e : this.regularEmployees) {
			unit = +e.getSalary() * e.getPerformanceScore();
		}
		unit = bonusBudget / unit;
		for (int i = 0; i < regularEmployees.size(); i++) {
			regularEmployees.get(i).setBonus(
					unit * regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore());

		}

	}

	//toString method
	@Override
	public String toString() {
		return super.toString() + "\nRegular Employees=" + regularEmployees + "\nBonus Budget=" + bonusBudget;
	}

}
