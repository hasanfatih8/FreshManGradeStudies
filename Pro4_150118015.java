import java.util.Scanner;
/*** we find different kind of numbers(prime, perfect, fibo, tau, woodall, smith) between 2 integers in this program ***/
public class Pro4_150118015 {
//HASAN FATÝH BAÞAR - 150118015
	public static void main(String[] args) {
		//to take input from user
		Scanner input = new Scanner(System.in);
		String wannaContinue;
		//to run this program at least one time
		do {
			//taking inputs from user
			System.out.print("Enter the starting value: ");
			int bottomValue = input.nextInt();
			System.out.print("Enter the ending value: ");
			int topValue = input.nextInt();
			//checking the inputs
			if(bottomValue < 0 || topValue < 0) {
				System.out.println("Your inputs must be greater than 0");
				System.out.print("Enter the starting value: ");
				bottomValue = input.nextInt();
				System.out.print("Enter the ending value: ");
				topValue = input.nextInt();
			}
			while(bottomValue > topValue) {
				System.out.println("Ending value must be greater than starting value");
				System.out.print("Enter the starting value: ");
				bottomValue = input.nextInt();
				System.out.print("Enter the ending value: ");
				topValue = input.nextInt();
			}
			while(bottomValue < 0 || topValue < 0){
					System.out.println("Your inputs must be greater than 0");
					System.out.print("Enter the starting value: ");
					bottomValue = input.nextInt();
					System.out.print("Enter the ending value: ");
					topValue = input.nextInt();
				}
			//OPTIONS
			System.out.printf("Welcome to our Number Finder Program.\r\n");
			System.out.printf("1. Prime Numbers between %d and %d \r\n", bottomValue, topValue);
			System.out.printf("2. Perfect Numbers between %d and %d \r\n", bottomValue, topValue); 
			System.out.printf("3. Fibonacci Numbers between %d and %d \r\n", bottomValue, topValue);
			System.out.printf("4. Woodall Numbers between %d and %d \r\n", bottomValue, topValue);
			System.out.printf("5. Tau Numbers between %d and %d \r\n", bottomValue, topValue);
			System.out.printf("6. Smith Numbers between %d and %d \r\n", bottomValue, topValue);
			System.out.printf("Please enter your menu choice (0 for exit):");
			
			int choose = input.nextInt();
			//giving the options to user 
			switch(choose) {
				case 1:
					System.out.printf("1. Prime Numbers between %d and %d \r\n", bottomValue, topValue);
					//using the method which is created for prime numbers
					Prime_Number(bottomValue, topValue);
					break;
										
				case 2:
					System.out.printf("2. Perfect Numbers between %d and %d \r\n", bottomValue, topValue);
					//using the method which is created for perfect numbers
					Perfect_Number(bottomValue, topValue);
					break;
								
				case 3: 
					System.out.printf("3. Fibonacci Numbers between %d and %d \r\n", bottomValue, topValue);
					//using the method which is created for fibonacci numbers
					Fibonacci_Number(bottomValue, topValue);
					break;
				
				case 4:
					System.out.printf("4. Woodall Numbers between %d and %d \r\n", bottomValue, topValue);
					//using the method which is created for woodall numbers
					Woodall_Number(bottomValue, topValue);
					break;
					
				case 5:
					System.out.printf("5. Tau Numbers between %d and %d \r\n", bottomValue, topValue);
					//using the method which is created for tau numbers 
					Tau_Number(bottomValue, topValue);
					break;
															
				case 6:
					System.out.printf("6. Smith Numbers between %d and %d \r\n", bottomValue, topValue);
					//using the method which is created for smith numbers
					Smith_Number(bottomValue, topValue);
					break;
				//to exit from our program
				case 0:
					System.out.println("Bye!");
					System.exit(1);
			}
			
			System.out.println();
			//to ask whether the user wants to rerun or not 
			System.out.print("Do you want to find new numbers (Y/N): ");
			wannaContinue = input.next();
			if(!wannaContinue.equalsIgnoreCase("y") || !wannaContinue.equalsIgnoreCase("n")) {
				while(!wannaContinue.equalsIgnoreCase("y")) {
					if(wannaContinue.equalsIgnoreCase("n")) {
						System.out.println("Okay then take care yourself, bye!");
						break;
					}
					System.out.println("Check your answer, it must be yes(Y) or no(N).");
					System.out.print("Do you want to find new numbers (Y/N): ");
					wannaContinue = input.next();
						
					}
			}
		}
		while(wannaContinue.equalsIgnoreCase("y"));
	}
	
	//CREATING A METHOD FOR PRIME NUMBERS
	public static void Prime_Number(int bottomValue, int topValue) {
		int flag = 0;
		//start from starting integer
		for(int n = bottomValue; n<=topValue; n++) {
			int count = 0;
			for(int i = 1; i<=topValue; i++)
				if(n % i == 0) {
					count++;
					if(count > 2)
						break;
				}
			if(count == 2){
				flag++;
				System.out.print(n + " ");
			}
		}
		//to check whether there are this kind of numbers or not
		if(flag == 0)
			System.out.println("there is no prime number");
	}
	//CREATING A METHOD FOR PERFECT NUMBERS
	public static void Perfect_Number(int bottomValue, int topValue) {
		int flag = 0;
		//start from starting integer
		for(int  n = bottomValue; n<=topValue; n++) {
			int sum = 0;
			for(int i = 1; i<n; i++) {
				if(n % i == 0) 
					sum += i;
			}
			if(n == sum)
				if(n != 0) {	
					flag++;
					System.out.print(n + " ");
				}
		}
		//to check whether there are this kind of numbers or not
		if(flag == 0)
			System.out.println("there is no perfect number");
	}
	//CREATING A METHOD FOR FIBONACCI NUMBERS
	public static void Fibonacci_Number(int bottomValue, int topValue){
		int flag = 0;
		int a = 0, b = 0;
		int c = 1;
		//start from starting integer
		for (int n = 0; c <= topValue + a; n++) {
			a = b;
			b = c;
			c = a + b;
			if(bottomValue <= a && a <= topValue) {
				flag++;
				System.out.print(a + " ");
			}
		}
		//to check whether there are this kind of numbers or not
		if(flag == 0)
			System.out.println("there is no fibonacci number");
	}
	//CREATING A METHOD FOR WOODALL NUMBERS
	public static void Woodall_Number(int bottomValue, int topValue) {
		int flag = 0;
		int woodall = 0;
		//start from starting integer
		for(int n = 1; n<=topValue; n++) {
			woodall = (int)( Math.pow(2, n) * n - 1 );
			if(bottomValue<=woodall && woodall<= topValue) {
				flag++;
				System.out.print(woodall + " ");
			}
		}
		//to check whether there are this kind of numbers or not
		if(flag == 0)
			System.out.println("there is no woodall number");
	}
	//CREATING A METHOD FOR TAU NUMBERS
	public static void Tau_Number(int bottomValue, int topValue) {
		int flag = 0;
		//start from starting integer
		for(int n = bottomValue; n<=topValue; n++) {
			int count = 0;
			for(int i = 1; i<=n; i++) {
				if(n % i == 0) {
					count++;
				}
			}
			if(n % count == 0) {
				flag++;
				System.out.print(n + " ");
			}
		}
		//to check whether there are this kind of numbers or not
		if(flag == 0)
			System.out.println("there is no tau number");
	
	}
	//CREATING A METHOD FOR SMITH NUMBERS
	public static void Smith_Number(int bottomValue, int topValue) {
		int flag = 0;
		if(bottomValue == 0)
			bottomValue = 1;
		//start from starting integer
		for(int n=bottomValue; n<= topValue; n++) {
			
			int number = n, numberTemp = n;
			int sumOfPrime = 0,  sumOfDigits = 0;
			while(numberTemp>0) {
				sumOfDigits+=(numberTemp)%10;
				numberTemp = numberTemp / 10;
			}
			//finds prime numbers and add their each digits
			for(int i = 2; i <= number && n!=i;) {
				if(number%i==0) {
					int prime=i;
					while(prime>0) {
						sumOfPrime+=(prime)%10;
						prime = prime / 10;
					}
					number = number / i;
				}	
				if(number%i!=0)
					i++;
			}

			if(sumOfDigits == sumOfPrime) {
				flag++;
				System.out.print(n + " ");
			}
		}
		//to check whether there are this kind of numbers or not
		if(flag == 0)
			System.out.println("there is no smith number");
	}
}