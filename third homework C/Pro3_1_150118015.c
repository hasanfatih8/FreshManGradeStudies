#include <stdio.h>
//declaring the bunnyEars2 function
void bunnyEars2(int n, int counter);

// main function
int main() {

	int bunny;
	printf("Please enter the number of lines (n=): ");
	//to take the input from user
	scanf("%d",&bunny);
	static int counter = 0;
	bunnyEars2(bunny, counter);
	return 0;
}

void bunnyEars2(int n, int counter) {
	static int sum = 0;
	if(counter <= n) {

		if(n >= 0) {

			if(counter == 0) {
				printf("bunnyEars2(%d)-> %d \n", counter, sum);
				bunnyEars2(n, counter+1);
			} else {
				//if the counter is odd then add 3
				if(counter % 2 == 0) {
					sum += 3;
					printf("bunnyEars2(%d)-> %d \n", counter, sum);
					bunnyEars2(n, counter+1);
				} else {
					//if the counter is odd then add 3
					sum += 2;
					printf("bunnyEars2(%d)-> %d \n", counter, sum);
					bunnyEars2(n, counter+1);
				}
			}
		}
	}

}
