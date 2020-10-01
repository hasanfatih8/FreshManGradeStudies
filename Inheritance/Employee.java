import java.util.Calendar;
//RAISE SALARY METHODLARINA BAK
public class Employee extends Person {
	private double salary;
	private java.util.Calendar hireDate;
	private Department department;
	public int numberofEmployees;
	//the first constructor of Employee class
	public Employee(String firstName, String lastName, int id, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department) {
		super(firstName, lastName, id, gender, birthDate, maritalStatus, hasDriverLicence);
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;/***************** DÝKKAT ******************/
		numberofEmployees++;

	}
	//the second constructor of Employee class
	public Employee(Person person, double salary, Calendar hireDate, Department department) {
		super(person.getFirstName(), person.getLastName(), person.getId(), person.getGender(), person.getBirthDate(),
				person.getMaritalStatus(), person.getHasDriverLicence());
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;/***************** DÝKKAT ******************/
		numberofEmployees++;
	}
	// raise salary method
	public double raiseSalary(double percent) {
		/*********** exceptipnlu biþeyler *///////
		salary += salary * percent;
		return salary;

	}

	public double raiseSalary(int amount) {
		salary += amount;
		return salary;
	}
	// GETTER AND SETTER METHODS
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	// GETTER AND SETTER METHODS
	public java.util.Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.util.Calendar hireDate) {
		this.hireDate = hireDate;
	}
	// GETTER AND SETTER METHODS
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	//toString method
	@Override
	public String toString() {
		return super.toString() + "\nSalary: " + this.salary + "\nHire Date: " + Test.makeStringDate(hireDate) + "\nDepartment: "
				+ this.department;
	}

}
