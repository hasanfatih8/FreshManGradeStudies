import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**********************************
 * HASAN FATÝH BAÞAR
 ****************************/
//150118015
//purpose of this program is to detect customers, employees, managers, developers etc. and determine their salaries

public class Test {
	//CREATING ARRAYLISTS
	public static ArrayList<Person> persons = new ArrayList<>();

	public static ArrayList<Project> projects = new ArrayList<>();
	public static ArrayList<Product> products = new ArrayList<>();
	public static ArrayList<Department> departments = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// file class
		File file = new File("C:\\Users\\Hasan Fatih\\Desktop\\input.txt");
		Scanner scan = new Scanner(file);

		while (scan.hasNext()) {
			String inputFile = scan.next();
			// TO FIND DEPARTMENTS
			if (inputFile.equalsIgnoreCase("Department")) {
				int departmentId = scan.nextInt();
				String departmentName = scan.next();
				Department dep = new Department(departmentId, departmentName);
				departments.add(dep);
				// TO FIND PROJECTS
			} else if (inputFile.equalsIgnoreCase("Project")) {
				String projectName = scan.next();
				String cal = scan.next();
				Calendar startDate = makeCalendar(cal);
				String state = scan.next();
				Project p = new Project(projectName, startDate, state);
				projects.add(p);
				// TO FIND PRODUCTS
			} else if (inputFile.equalsIgnoreCase("Product")) {
				String productName = scan.next();
				String cal = scan.next();
				Calendar saleDate = makeCalendar(cal);
				double price = scan.nextDouble();
				Product prod = new Product(productName, saleDate, price);
				products.add(prod);
				// TO FIND PERSONS
			} else if (inputFile.equalsIgnoreCase("Person")) {
				String firstName = scan.next();
				String secondName = scan.next();
				int id = scan.nextInt();
				String gender = scan.next();
				String cal = scan.next();
				Calendar birthDate = makeCalendar(cal);
				String maritalStatus = scan.next();
				String hasDriverLicence = scan.next();
				Person person = new Person(firstName, secondName, id, gender, birthDate, maritalStatus,
						hasDriverLicence);
				persons.add(person);

				// TO FIND EMPLOYEES
			} else if (inputFile.equalsIgnoreCase("Employee")) {
				int id = scan.nextInt();
				double salary = scan.nextDouble();
				String cal = scan.next();
				Calendar hireDate = makeCalendar(cal);
				String depName = scan.next();
				for (int i = 0; i < persons.size(); ++i) {
					if (id == ((Person) persons.get(i)).getId()) {
						
					}
				}
				/*int idx1 = 0, idx2 = 0;
				int id = scan.nextInt();
				double salary = scan.nextDouble();
				String cal = scan.next();
				Calendar hireDate = makeCalendar(cal);
				String depName = scan.next();
				for (int i = 0; i < persons.size(); ++i) {
					if (id == ((Person) persons.get(i)).getId()) {
						idx1 = i;
					}
				}
				for (int i = 0; i < departments.size(); ++i)
					if (depName.equalsIgnoreCase(departments.get(i).getDepartmentName())) {
						idx2 = i;
					}
					Object ps = new Employee((Person) persons.get(idx1), salary, hireDate, departments.get(idx2));
					persons.remove(persons.get(idx1));
					persons.add((Employee) ps);*/

				// TO FIND MANAGER
			} else if (inputFile.equalsIgnoreCase("Manager")) {
				int mId = scan.nextInt();
				double bonusBudget = scan.nextDouble();
				for (int i = 0; i < persons.size(); ++i)
					if (mId == ((Person) persons.get(i)).getId()) {

						Object tempM = new Manager((Employee) persons.get(i), bonusBudget);
						persons.remove(persons.get(i));
						persons.add((Manager) tempM);
					}

			} else if (inputFile.equalsIgnoreCase("RegularEmployee")) {
				int reId = scan.nextInt();
				double performanceScore = scan.nextDouble();

			} else if (inputFile.equalsIgnoreCase("SalesEmployee")) {
				// ???????????????????????

			} else if (inputFile.equalsIgnoreCase("Developer")) {

			} else if (inputFile.equalsIgnoreCase("Customer")) {

			}

		}
		// to write in a output file
		java.io.File outputFile = new java.io.File("output.txt");
		if (outputFile.exists()) {
			System.out.println("File already exists");
			System.exit(0);
		}
		// try to create an output file
		try (java.io.PrintWriter output = new java.io.PrintWriter(outputFile)) {

			/*for (int i = 0; i < departments.size(); i++) {
				output.println(departments.get(i).toString());
			}

			for (int i = 0; i < projects.size(); i++) {
				output.println(projects.get(i).toString());
			}

			for (int i = 0; i < products.size(); i++) {
				output.println(products.get(i).toString());
			}

			for (int i = 0; i < persons.size(); i++) {
				output.println(persons.get(i).toString());
			}*/

			for (int i = 0; i < persons.size(); i++) {
				if (persons.get(i) instanceof Employee) {
					output.println(((Employee) persons.get(i)).toString());
				}
			}
			for (int i = 0; i < persons.size(); i++) {
				if (persons.get(i) instanceof Manager) {
					output.println(((Manager) persons.get(i)).toString());
				}
			}

		}

	}

	// calendar method
	public static Calendar makeCalendar(String sDate) throws Exception {
		String[] stringDate = sDate.split("/");
		int[] intDate = new int[3];
		for (int i = 0; i < 3; i++) {
			intDate[i] = Integer.parseInt(stringDate[i]);
		}
		Calendar cal = Calendar.getInstance();
		cal.set(intDate[2], intDate[1], intDate[0]);
		return cal;
	}

	public static String makeStringDate(Calendar cal) {
		int day = cal.get(5);
		int month = cal.get(2);
		int year = cal.get(1);
		String date = Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
		return date;
	}

}
