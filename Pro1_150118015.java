import java.util.Scanner;

public class Pro1_150118015 {
//Hasan Fatih Baþar - 150118015
	
	public static void main(String[] args) {
		
		//CSE1141 - BETÜL DEMÝRÖZ BOZ
		
		Scanner input = new Scanner(System.in);
		
		//for first point
		System.out.print("Enter the first point: ");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		
		//for second point
		System.out.print("Enter the second point: ");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		
		//for slope
		double Slope = (y2 - y1)/(x2 - x1);
		double b = y1 - (x1 * Slope);
		
		System.out.println("The slope of the equation is: " + Slope);
		
		System.out.println("The equation is: y =" + Slope + "x + " + b);
	
		
	}

}
