import java.util.Scanner;

public class Pro2_150118015 {

	//this program will be using in order to choose a house and calculate those house's prices.
	//HASAN FATÝH BAÞAR - 150118015 - CSE1141 - BETÜL BOZ
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("--- Buy a House ---");
		System.out.println("(A) A Block");
		System.out.println("(B) B Block");
		System.out.println("(C) C Block");
		System.out.println("(D) D Block");
		
		System.out.print("Which block you prefer? (A, B, C, D): ");
		String block = input.nextLine();
		int room;
		
		double BasePrice; 
		double KDV;
		
		switch (block.toUpperCase()) {
			case "A":
				System.out.println("(1) 1+1");
				System.out.println("(2) 2+1");
				System.out.print("Which type of house you perefer? (1, 2): ");
				room = input.nextInt();
				
				switch (room) { //for block A - max 10 storey
					
					case 1: //certainly unfurnitured A
						System.out.print("Select storey? (max 10): ");
						int storey = input.nextInt();
						BasePrice = 45000;
						BasePrice = BasePrice + BasePrice * 0.0165 * (storey-1);
						System.out.println("Your house price without furnished: " + BasePrice);
						if(BasePrice < 100000) {	
							KDV = BasePrice * 1 / 100;
							System.out.println("%1 KDV costs: " + KDV);
						}
						else {  
							KDV = BasePrice * 8 / 100;
							System.out.println("%8 KDV costs: " + KDV);
						}
						BasePrice += KDV;
						System.out.println("You select block " + block.toUpperCase() + ", 1+1 type on floor " + storey + " house with total costs " + BasePrice);
						break;
					
					case 2://certainly furnitured A
						System.out.println("Select storey? (max 10): ");
						storey = input.nextInt();
						BasePrice = 65000;
						BasePrice = BasePrice + BasePrice * 0.0174 * (storey-1);
						
						BasePrice += 19000; //adding furniture costs
						System.out.println("Your house price with furnished: " + BasePrice);
						if(BasePrice < 100000) {	
							KDV = BasePrice * 1 / 100;
							System.out.println("%1 KDV costs: " + KDV);
						}
						else {  
							KDV = BasePrice * 8 / 100;
							System.out.println("%8 KDV costs: " + KDV);
						}
						BasePrice += KDV;
						System.out.println("You select block " + block.toUpperCase() + ", 2+1 type on floor " + storey + " furnitured house with total costs " + BasePrice);
					break;
					default:
						System.out.println("There is no type of houses except 1+1 and 2+1");
				}
				break;
			
			case "B":
				System.out.println("(1) 1+1");
				System.out.println("(2) 2+1");
				System.out.println("(3) 3+1");
				System.out.print("Which type of house you perefer? (1, 2, 3): ");
				room = input.nextInt();
					
				switch (room) { //for block B - max 8 storey
						
					case 1:	//certainly furnitured B
						System.out.print("Select storey? (max 8): ");
						int storey = input.nextInt();
						BasePrice = 50000;
						BasePrice = BasePrice + BasePrice * 0.0200 * (storey-1);
						BasePrice += 13000; //adding furniture costs
						System.out.println("Your house price with furnished: " + BasePrice);
						if(BasePrice < 100000) {	
							KDV = BasePrice * 1 / 100;
							System.out.println("%1 KDV costs: " + KDV);
						}
						else {  
							KDV = BasePrice * 8 / 100;
							System.out.println("%8 KDV costs: " + KDV);
						}
						BasePrice += KDV;
						System.out.println("You select block " + block.toUpperCase() + ", 1+1 type on floor " + storey + " furnitured house with total costs " + BasePrice);
						break;
					
					case 2: //certainly unfurnitured B
						System.out.print("Select storey? (max 8): ");
						storey = input.nextInt();
						BasePrice = 72000;
						BasePrice = BasePrice + BasePrice * 0.0170 * (storey-1);
						System.out.println("Your house price: " + BasePrice);
						if(BasePrice < 100000) {	
							KDV = BasePrice * 1 / 100;
							System.out.println("%1 KDV costs: " + KDV);
						}
						else {  
							KDV = BasePrice * 8 / 100;
							System.out.println("%8 KDV costs: " + KDV);
						}
						BasePrice += KDV;
						System.out.println("You select block " + block.toUpperCase() + ", 2+1 type on floor " + storey + " house with total costs " + BasePrice);
						break;
						
					case 3://optional furnitured B
						System.out.print("Select storey? (max 8): ");
						storey = input.nextInt();
						BasePrice = 97500;
						BasePrice = BasePrice + BasePrice * 0.0175 * (storey-1);
						System.out.print("Do you want furnitured house? (Y, N): ");
						
						input.nextLine();
						String furnitured = input.nextLine();
						if (furnitured.equals ("Y") || furnitured.equals ("y")) {
							BasePrice += 26000;
							System.out.println("Your house price with furnished: " + BasePrice);
						}
						else 
							System.out.println("Your house price without furnished: " + BasePrice);
						if(BasePrice < 100000) {	
							KDV = BasePrice * 1 / 100;
							System.out.println("%1 KDV costs: " + KDV);
						}
						else {  
							KDV = BasePrice * 8 / 100;
							System.out.println("%8 KDV costs: " + KDV);
						}
						BasePrice += KDV;
						System.out.println("You select block " + block.toUpperCase() + ", 3+1 type on floor " + storey + " house with total costs " + BasePrice);					
					break;
					default:
						System.out.println("There is no type of houses except 1+1, 2+1 and 3+1");
				}
				break;
			case "C":
				System.out.println("(2) 2+1");
				System.out.println("(3) 3+1");
				System.out.println("(4) 4+1");
				System.out.print("Which type of house you perefer? (2, 3, 4): ");
				room = input.nextInt();
							
				switch (room) { //for block C - max 10 storey
						
					case 2://optional furnitured C
						System.out.print("Select storey? (max 10): ");
						int storey = input.nextInt();
						BasePrice = 80000;
						BasePrice = BasePrice + BasePrice * 0.0160 * (storey-1);
						System.out.print("Do you want furnitured house? (Y, N): ");
						
						input.nextLine();
						String furnitured = input.nextLine();
						if (furnitured.equals ("Y") || furnitured.equals ("y")) {
							BasePrice += 19000;
							System.out.println("Your house price with furnished: " + BasePrice);
						}
						else 
							System.out.println("Your house price without furnished: " + BasePrice);
						if(BasePrice < 100000) {	
							KDV = BasePrice * 1 / 100;
							System.out.println("%1 KDV costs: " + KDV);
						}
						else {  
							KDV = BasePrice * 8 / 100;
							System.out.println("%8 KDV costs: " + KDV);
						}
						BasePrice += KDV;
						System.out.println("You select block " + block.toUpperCase() + ", 2+1 type on floor " + storey + " house with total costs " + BasePrice);
						break;
					case 3:	//certainly furnitured B
						System.out.print("Select storey? (max 8): ");
						storey = input.nextInt();
						BasePrice = 102400;
						BasePrice = BasePrice + BasePrice * 0.0185 * (storey-1);
						BasePrice += 26000; //adding furniture costs
						System.out.println("Your house price with furnished: " + BasePrice);
						if(BasePrice < 100000) {	
							KDV = BasePrice * 1 / 100;
							System.out.println("%1 KDV costs: " + KDV);
						}
						else {  
							KDV = BasePrice * 8 / 100;
							System.out.println("%8 KDV costs: " + KDV);
						}
						BasePrice += KDV;
						System.out.println("You select block " + block.toUpperCase() + ", 3+1 type on floor " + storey + " furnitured house with total costs " + BasePrice);
						break;
					case 4: //certainly unfurnitured B
						System.out.print("Select storey? (max 8): ");
						storey = input.nextInt();
						BasePrice = 137000;
						BasePrice = BasePrice + BasePrice * 0.0210 * (storey-1);
						System.out.println("Your house price: " + BasePrice);
						if(BasePrice < 100000) {	
							KDV = BasePrice * 1 / 100;
							System.out.println("%1 KDV costs: " + KDV);
						}
						else {  
							KDV = BasePrice * 8 / 100;
							System.out.println("%8 KDV costs: " + KDV);
						}
						BasePrice += KDV;
						System.out.println("You select block " + block.toUpperCase() + ", 4+1 type on floor " + storey + " house with total costs " + BasePrice);
					break;
					default:
						System.out.println("There is no type of houses except 2+1, 3+1 and 4+1");
				}
				break;
			case "D":
				System.out.println("(3) 3+1");
				System.out.println("(4) 4+1");
				System.out.print("Which type of house you perefer? (3, 4): ");
				room = input.nextInt();
							
				switch (room) { //for block D - max 8 storey
					
					case 3://optional furnitured C
						System.out.print("Select storey? (max 10): ");
						int storey = input.nextInt();
						BasePrice = 119900;
						BasePrice = BasePrice + BasePrice * 0.0190 * (storey-1);
						System.out.print("Do you want furnitured house? (Y, N): ");
						
						input.nextLine();
						String furnitured = input.nextLine();
						if (furnitured.equals ("Y") || furnitured.equals ("y")) {
							BasePrice += 26000;
							System.out.println("Your house price with furnished: " + BasePrice);
						}
						else 
							System.out.println("Your house price without furnished: " + BasePrice);
						if(BasePrice < 100000) {	
							KDV = BasePrice * 1 / 100;
							System.out.println("%1 KDV costs: " + KDV);
						}
						else {  
							KDV = BasePrice * 8 / 100;
							System.out.println("%8 KDV costs: " + KDV);
						}
						BasePrice += KDV;
						System.out.println("You select block " + block.toUpperCase() + ", 3+1 type on floor " + storey + " house with total costs " + BasePrice);
						break;
					case 4: //certainly unfurnitured B
						System.out.print("Select storey? (max 8): ");
						storey = input.nextInt();
						BasePrice = 165000;
						BasePrice = BasePrice + BasePrice * 0.0200 * (storey-1);
						System.out.println("Your house price: " + BasePrice);
						if(BasePrice < 100000) {	
							KDV = BasePrice * 1 / 100;
							System.out.println("%1 KDV costs: " + KDV);
						}
						else {  
							KDV = BasePrice * 8 / 100;
							System.out.println("%8 KDV costs: " + KDV);
						}
						BasePrice += KDV;
						System.out.println("You select block " + block.toUpperCase() + ", 4+1 type on floor " + storey + " house with total costs " + BasePrice);
					break;
					default:
						System.out.println("There is no type of houses except 3+1 and 4+1");
				}
			break;
			default:
				System.out.println("Review your choice");
				System.exit(1);
		}
	}
}