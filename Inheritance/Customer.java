import java.util.ArrayList;
import java.util.Calendar;

public class Customer extends Person {

	private ArrayList<Product> products;

	public Customer( String firstName, String lastName, int id, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, ArrayList<Product> products) {
		super(firstName, lastName, id, gender, birthDate, maritalStatus, hasDriverLicence);
		this.products = products;

	}

	public Customer(Person person, ArrayList<Product> products) {
		super( person.getFirstName(), person.getLastName(), person.getId(), person.getGender(), person.getBirthDate(),
				person.getMaritalStatus(), person.getHasDriverLicence());
		this.products = products;
	}
	// GETTER AND SETTER METHODS
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return super.toString() + "\nProducts: " + this.products;
	}
	

}
