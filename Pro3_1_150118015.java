
public class Pro3_1_150118015 {

	public static void main(String[] args) {
		/*This program will find the smallest number whose sum of cubes
		 of digits is equal to the number*/
		//HASAN FATÝH BAÞAR - 150115018
		
		int number, mod, SumOfCubes, temp2, temp;
		number = 1;
		SumOfCubes = 0;
		mod = 0;
		temp = 1;
		temp2 = 1;
		
		while(temp2!=SumOfCubes) { /*loop of increasing the number one by*/
			number++;			   /*one until finding the smallest number*/
			temp = number;
			temp2 = number;
			SumOfCubes = 0;
			while(number>0) { //loop of finding the sum of cubes
				mod = number % 10;
				SumOfCubes = (int) (SumOfCubes + Math.pow(mod,3));
				number = number / 10;	
			}
			number = temp;
		}
		//printing the number which is mentioned in the first comment
		System.out.println("The smallest number (excluding 1) whose sum of cubes of digits are equal to that number is " + temp);	
	}
}