#include <stdio.h> 
//a function to sum of digits the number taken from user
int digSum(int n) 
{ 
    if (n == 0) 
        return 0; 
    return (n % 9 == 0) ? 9 : (n % 9); 
} 
  
//a function to calculate sum
int timesNumberSum(int n, int x) 
{ 
    int sum = x*digSum(n); 
    return digSum(sum); 
} 

//a function to printing the number properly
void printProperly(int n, int times)
{
	if(times >= 1)
	{
		printf("%d", n);
		printProperly(n, times-1);
	}
}

// main function
int main() 
{ 
    int n, x;
    printf("Please enter a number (n=) : ");
    //to take the number from user
	scanf("%d", &n); 
	//to take the how many times will be repetiting the number
	printf("Please enter repetition factor (k=) : ");
	scanf("%d", &x);
	
	printf("Super digit of number "); //printing the output
	printProperly(n, x);
    printf(" is : %d", timesNumberSum(n, x)); 
    return 0; 
} 
