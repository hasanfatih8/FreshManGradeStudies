import java.util.ArrayList;
import java.util.Calendar;

public class SalesEmployee extends RegularEmployee {
	private ArrayList<Product> sales;
	public static int numberOfSalesEmployees;
	//the first constructor of SalesEmployee class
	public SalesEmployee(String firstName, String lastName, int id, String gender, Calendar birthDate,
			String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department,
			double performanceScore, ArrayList<Product> s) {
		super(firstName, lastName, id, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
				performanceScore);
		this.sales = s;
		numberOfSalesEmployees++;
	}
	//the second constructor of SalesEmployee class
	public SalesEmployee(RegularEmployee re, ArrayList<Product> sales) {
		super(re.getFirstName(), re.getLastName(), re.getId(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(),
				re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(),
				re.getPerformanceScore());
		this.sales = sales;
	}
	// GETTER AND SETTER METHODS
	public ArrayList<Product> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Product> sales) {
		this.sales = sales;
	}
	//add sale method
	public boolean addSale(Product s) {
		return this.sales.add(s);
	}
	//remove sale method
	public boolean removeSale(Product s) {
		return this.sales.remove(s);
	}

	//toString method
	@Override
	public String toString() {
		return super.toString() + "\nSales Employe =" + sales;
	}
}
