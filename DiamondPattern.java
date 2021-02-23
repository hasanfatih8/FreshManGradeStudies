import java.util.Scanner;

public class Pro3_2_150118015 {
	/*The main purpose of this program that we're executing now is creating a diamond pattern
	by a letter which is taken from user.*/
	//HASAN FATÝH BAÞAR - 150118015
	public static void main(String[] args) {
		int i, DiamondN, k, a, b;
		b = 1;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		DiamondN = input.nextInt(); /*taking an integer from user which determine the height of the diamond 
									by using the 2N+1 rule*/
		if(DiamondN<0) { //checking the number is positive
			System.out.println("ERROR");
			System.exit(1);
		}
		
		System.out.print("Enter a character: ");/*taking a letter from user which is used in the diamond*/
		String inputCharacter = input.next();
		
		if(Character.isDigit(inputCharacter.charAt(0)) || inputCharacter.length() > 1) { 
			System.out.println("ERROR");//checking the letter is letter, digit or word etc.
			System.exit(1);
		}
		//pyramid part of the diamond
		for(i=0 ; i<DiamondN ; i++) {
			for(a=DiamondN-1 ; i<a ; a--) 
				System.out.print(". ");
				
			for(k = 0 ; k <= 2*i; k++)
					System.out.print(inputCharacter.toUpperCase() + " ");
			for(a = DiamondN-1 ; i < a ; a--) 
				System.out.print(". ");
			System.out.println("");
		}
		//bottom part of the diamond
		for(i = DiamondN-1; i > 0; i--) {
			for(a = 0; a < b; a++)
				System.out.print(". ");
			b++;
			for(k = 1; k < 2*i; k++)
				System.out.print(inputCharacter.toUpperCase() + " ");
			for(a = 1 ; a < b ; a++) 
				System.out.print(". ");
			System.out.println("");
		}
	}
}
