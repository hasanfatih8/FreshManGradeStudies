#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <Math.h>
#define SIZE 10

//defining MetroStation structure
typedef struct MetroStation
{
	char name [20];
	double x;
	double y;
}MetroStation;

//defining MetroLine structure
typedef struct MetroLine 
{
	char color [20];
	struct MetroStation MetroStations [SIZE];
}MetroLine;

//defining MetroLine structure
typedef struct MetroSystem 
{
	char color [20];
	struct MetroLine MetroLines [SIZE];
}MetroSystem;
 
int equals( MetroStation s1,  MetroStation s2) //equals function - first method
{
	if(strcmp(s1.name, s2.name) == 0)
	{
		return 1;
	} else 
	{
		return 0;
	}
}

void addStation( MetroLine *ml,  MetroStation ms) //adding stations to lines
{
	int i;
	for(i = 0; i < SIZE; i++)
	{
		if(ml -> MetroStations[i].name[0] == 0)
		{
			ml -> MetroStations[i] = ms;
			break;
		}
	}
}

int hasStation(MetroLine ml, MetroStation ms)	//to check if the metro line has the metro station
{
	int i;
	for(i = 0; i < SIZE; i++)
	{
		int x = strcmp(ml.MetroStations[i].name, ms.name);
		if(x == 0)
		{
			return 1;
		} 
	}
	return 0;
}

MetroStation getFirstStop(MetroLine ml)	//to get first stop of a metroline
{
	struct MetroStation x = {'\0'};
	if(ml.MetroStations[0].name != 0)
	{
		return ml.MetroStations[0];
	}
	return x;
}

MetroStation getPreviousStop(struct MetroLine ml, struct MetroStation ms) //to get previous stop of the metroline 
{
	int i;
	struct MetroStation a = {'\0'};
	
	for(i = 0; i < SIZE; i++)
	{
		int x = strcmp(ml.MetroStations[i].name, ms.name);
		if(x == 0)													//return empty struct if it is first station
		{
			if(i != 0){
				return ml.MetroStations[i - 1];
			}	
		}
	}
	return a;
}


MetroStation getNextStop(struct MetroLine ml, struct MetroStation ms)	//to get next stop of the metroline 
{
	int i;
	struct MetroStation a = {'\0'};
	
	for(i = 0; i < SIZE; i++)
	{
		int x = strcmp(ml.MetroStations[i].name, ms.name);
		if(x == 0)													//return empty struct if it is last station
		{
			if(ml.MetroStations[i+1].name[0] != 0){
				return ml.MetroStations[i + 1];
			}	
		}
	}
	return a;
}


void addLine(struct MetroSystem *ms, struct MetroLine ml) // adding lines to Istanbul metro system
{
	int i;
	for(i = 0; i < SIZE; i++)
	{
		if(ms -> MetroLines[i].color[0] == 0)
		{
			ms -> MetroLines[i] = ml;
			break;
		}
	}
}

void printLine(struct MetroLine ml)			// printing lines which is in Istanbul metro system
{
	printf("Metroline %s: ", ml.color);
	int i;
	for(i = 0; ml.MetroStations[i].name[0] != 0; i++)
	{
			if(ml.MetroStations[i+1].name[0] != 0) 
			{
				printf("%s, ", ml.MetroStations[i].name);
			} else if (ml.MetroStations[i+1].name[0] == 0)
			{
				printf("%s. ", ml.MetroStations[i].name);
			}
	}
	printf("\n");
}

void printPath(struct MetroStation ms[SIZE]) // printing path properly
{
	int i;
	for(i = 0; ms[i].name[0] != 0; i++)
	{
			printf("%s\n", ms[i].name);
	}
	
}

double getDistanceTravelled(struct MetroStation ms[SIZE])	//calculating the distance travelled
{
	double sum = 0;
	int i;
	for(i = 1; ms[i].name[0] != 0; i++)													
	{									
		sum +=  sqrt(pow((ms[i].x - ms[i-1].x), 2) + pow((ms[i].y - ms[i-1].y), 2));		
	}
	return sum;
}

MetroStation findNearestStation(struct MetroSystem ms, double x, double y)	//finding the nearest station of given x and y values
{
	int i, j;
	struct MetroStation a = {'\0'};
	double min = 80000;
	
	for(i = 0; ms.MetroLines[i].color[0] != 0; i++)							
	{
		for(j = 0; ms.MetroLines[i].MetroStations[j].name[0] != 0; j++)
		{
			double target = sqrt(pow((x - ms.MetroLines[i].MetroStations[j].x), 2) + pow((y - ms.MetroLines[i].MetroStations[j].y), 2));
			if (target < min)
			{								
				min = target;
			}
		}
	}
	
	for(i = 0; ms.MetroLines[i].color[0] != 0; i++)							
	{
		for(j = 0; ms.MetroLines[i].MetroStations[j].name[0] != 0; j++)
		{
			double nearest = sqrt(pow((x - ms.MetroLines[i].MetroStations[j].x), 2) + pow((y - ms.MetroLines[i].MetroStations[j].y), 2));
			if(min == nearest)
			{
				return ms.MetroLines[i].MetroStations[j];
			}
		}
	}
	return a;
}

void getNeighboringStations(MetroSystem metroSys, MetroStation ms, MetroStation neigboringStations[SIZE])
{
    int i, j, k = 0;														//finding the neighbour station of each other
        for(i = 0; metroSys.MetroLines[i].color[0] != 0; i++)
		{
        	for(j = 0; metroSys.MetroLines[i].MetroStations[j].name[0] != 0; j++)
			{
                if(equals(ms, metroSys.MetroLines[i].MetroStations[j]) == 1)
				{
                    if(metroSys.MetroLines[i].MetroStations[j - 1].name[0] != 0 && metroSys.MetroLines[i].MetroStations[j + 1].name[0] != 0)
					{
                        neigboringStations[k] = metroSys.MetroLines[i].MetroStations[j - 1];
                        neigboringStations[k + 1] = metroSys.MetroLines[i].MetroStations[j + 1];
                        k += 2;
                    }else if(metroSys.MetroLines[i].MetroStations[j - 1].name[0] == 0 && metroSys.MetroLines[i].MetroStations[j + 1].name[0] != 0)
					{
        	        	neigboringStations[k] = metroSys.MetroLines[i].MetroStations[j + 1];
                        k++;
                    }else if(metroSys.MetroLines[i].MetroStations[j - 1].name[0] != 0 && metroSys.MetroLines[i].MetroStations[j + 1].name[0] == 0)
					{
                        neigboringStations[k] = metroSys.MetroLines[i].MetroStations[j - 1];
                        k++;
                	}
                }
        	}
        }
}

//
/*13th function*/
//

MetroSystem istanbul = {"istanbul", '\0'};

int main()
{
	int i;
	double myX=1, myY=2; 
	double goalX=62, goalY=45; 
	
	// define 3 metro lines, 9 metro stations, and an empty myPath
	MetroLine red={'\0'}, blue={'\0'}, green={'\0'};
	MetroStation s1, s2, s3, s4, s5, s6, s7, s8, s9;
	MetroStation myPath[SIZE]={'\0'};
	
	strcpy(red.color, "red"); 
	strcpy(blue.color, "blue");
	strcpy(green.color, "green");

	
	strcpy(s1.name, "Haydarpasa"); 		s1.x=0; 	s1.y=0;
	strcpy(s2.name, "Sogutlucesme"); 	s2.x=10; 	s2.y=5;
	strcpy(s3.name, "Goztepe"); 		s3.x=20; 	s3.y=10;
	strcpy(s4.name, "Kozyatagi"); 		s4.x=30; 	s4.y=35;
	strcpy(s5.name, "Bostanci"); 		s5.x=45; 	s5.y=20;
	strcpy(s6.name, "Kartal"); 			s6.x=55; 	s6.y=20;
	strcpy(s7.name, "Samandira"); 		s7.x=60; 	s7.y=40;
	strcpy(s8.name, "Icmeler"); 		s8.x=70; 	s8.y=15;
	
	//Add several metro stations to the given metro lines.
	addStation(&red, s1); addStation(&red, s2); addStation(&red, s3); addStation(&red, s4); addStation(&red, s5); addStation(&red, s8);
	
	addStation(&blue, s2); addStation(&blue, s3); addStation(&blue, s4); addStation(&blue, s6); addStation(&blue, s7);
	
	addStation(&green, s2); addStation(&green, s3); addStation(&green, s5); addStation(&green, s6); addStation(&green, s8);
	
	// Add red, blue, green metro lines to the Istanbul metro system.
	addLine(&istanbul, red);
	addLine(&istanbul, blue);
	addLine(&istanbul, green);
	
	// print the content of the red, blue, green metro lines
	printLine(red);
	printLine(blue);
	printLine(green);
		
	// find the nearest stations to the current and target locations
	MetroStation nearMe = findNearestStation(istanbul, myX, myY);
	MetroStation nearGoal = findNearestStation(istanbul, goalX, goalY);
	
	printf("\n");
	
	printf("The best path from %s to %s is:\n", nearMe.name, nearGoal.name);
	
	// if the nearest current and target stations are the same, then print a message and exit.	
	if(equals(nearMe, nearGoal)){
		printf("It is better to walk!\n");
		return 0;
	}
	
	//
	//AFTER THIS STATEMENT, THIS CODE IS NOT GOING TO EXECUTE CORRECTLY, BECAUSE I COULDNT'T WRITE THE LAST FUNCTION.
	//THAT'S WHY I TOOK NEXT LÝNES IN COMMENT.
	//BUT IF I AM NOT WRONG, THE OTHER 12 FUNCTIONS ARE WORKING CORRECTLY.
	//
	
	// Calculate and print the myPath with the minimum distance travelled from start to target stations.
/*	findPath(nearMe, nearGoal, myPath);
	
	if(strlen(myPath[0].name) == 0)
		printf("There is no path on the metro!\n");
	else{
		printPath(myPath);
	}
	
	return 0;*/
	
}
