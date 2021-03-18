#include <stdio.h>
//printing underscore '_' recursively
void printUnder(int space) {
    if (space == 0)
        return;
    printf("_");
    printUnder(space - 1);
}

//printing '1' recursively
void printOne(int pat) {
    if (pat <= 0)
        return;
    printf("1");
    printOne(pat - 1);
}
// printing the pyramid recursively
void Pyramid2_2(int n, int num) {
    if (n == 0)
        return;
	if(num % 2 == 0){
		printUnder(n + num/2);
	} else{
		printUnder(n + num/2);
	}
	printOne(num - n +1);
	if(num % 2 == 0){
		printUnder(n +  num/2);
	} else{
		printUnder(n + num/2);
	}
    printf("\n");
    Pyramid2_2(n - 1, num + 1);
}

// printing the pyramid recursively
void Pyramid2(int n, int num) {
    if (n == 0)
        return;
    printUnder(n - 1);
   	printOne(num - n+1);
    printUnder(n - 1);
    printUnder(n - 1);
    printOne(num - n + 1);
    printUnder(n - 1);
    printf("\n");
    Pyramid2(n - 1, num+1);
}

// printing the pyramid recursively
void Pyramid3(int n, int num) {
    if (n == 0)
        return;
    printUnder(n - 1);
    printOne(num - n+1);
    printUnder(n - 1);
    printUnder(n - 1);
    printOne(num - n + 1);
    printUnder(n - 1);
    printUnder(n - 1);
    printOne(num - n + 1);
    printUnder(n - 1);
    printUnder(n - 1);
    printOne(num - n + 1);
    printUnder(n - 1);
    printf("\n");
    Pyramid3(n - 1, num+1);
}
// printing the first triangle recursively
void Triangle(int n, int num) {
    if (n == 0)
        return;
    printUnder(n - 1);
    printOne(num - n+1);
    printUnder(n - 1);
    printf("\n");
    Triangle(n - 1, num+1);
}

//main function
int main()
{
	int iterationNum;
	printf("Enter the iteration number (0,1,2,3,4): ");
	
	//to take the input from user
	scanf("%d", &iterationNum);
	
	//switch case for 5 cases (1,2,3,4)
	switch (iterationNum)
	{
		case 0: 
		{
			int n = 32;
    		Triangle(n, n);
   			return 0;
			break;
		}
		case 1: 
		{
			int n = 16;
    		Pyramid2_2(n, n);
    		int m = 16;
    		Pyramid2(m, m);
    		return 0;
			break;
		}
		case 2:
		{
			int n = 8;
		    Pyramid2_2(n, n);
		    int m = 8;
		    Pyramid2(m, m);
		    Pyramid2(m, m);
		    Pyramid3(n, n);
		    return 0;			
			break;			
		}
		case 3:
		{
			int n = 32;
    		Triangle(n, n);
   			return 0;
			break;			
		}
		case 4:
		{
			int n = 16;
    		Pyramid2_2(n, n);
    		int m = 16;
    		Pyramid2(m, m);
    		return 0;
			break;
		}
		default : 
		{
			printf("Invalid input");
			break;
		}
			
	} 
}
