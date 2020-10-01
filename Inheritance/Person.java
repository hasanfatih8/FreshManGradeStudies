import java.util.Calendar;

public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private java.util.Calendar birthDate;
	private byte maritalStatus;
	private boolean hasDriverLicence;

	// constructor of Person class
	public Person(String firstName, String lastName, int id, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		setGender(gender);
		setMaritalStatus(maritalStatus);
		setHasDriverLicence(hasDriverLicence);
	}

	// GETTER AND SETTER METHODS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	// GETTER AND SETTER METHODS
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	// GETTER AND SETTER METHODS
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	// GETTER AND SETTER METHODS
	public String getGender() {
		if (gender == 1) {
			return "Man";
		} else {
			return "Woman";
		}
	}

	public void setGender(String gender) {
		if (gender.equalsIgnoreCase("man")) {
			this.gender = 1;
		} else if (gender.equalsIgnoreCase("woman")) {
			this.gender = 2;
		} else {
		}

	}
	// GETTER AND SETTER METHODS
	public java.util.Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.util.Calendar birthDate) {
		this.birthDate = birthDate;
	}
	// GETTER AND SETTER METHODS
	public String getMaritalStatus() {
		if (maritalStatus == 1) {
			return "Single";
		} else if (maritalStatus == 2) {
			return "Married";
		} else {
			return "";
		}

	}

	public void setMaritalStatus(String maritalStatus) throws IllegalArgumentException {

		if (maritalStatus.equalsIgnoreCase("Single")) {
			this.maritalStatus = 1;
		} else if (maritalStatus.equalsIgnoreCase("Married")) {
			this.maritalStatus = 2;
		} else {

		}
	}
	// GETTER AND SETTER METHODS
	public String getHasDriverLicence() {
		if (hasDriverLicence) {
			return "Yes";
		} else {
			return "No";
		}
	}

	public void setHasDriverLicence(String hasDriverLicence) {
		if (hasDriverLicence.equalsIgnoreCase("Yes")) {
			this.hasDriverLicence = true;
		} else if (hasDriverLicence.equalsIgnoreCase("No")) {
			this.hasDriverLicence = false;
		} else {
			// throws exception bbiþelrer
		}
	}

	
	//toString method 
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", birthDate=" + Test.makeStringDate(birthDate) + ", maritalStatus=" + maritalStatus
				+ ", hasDriverLicence=" + hasDriverLicence + "]";
	}

}
