#include<stdio.h>			//HASAN FATÝH BAÞAR - 150118015
#include<string.h>

typedef struct { //defining and initilazing structure
	char songName[25];
	int duration;
	struct Song *chrono_next;			//
	struct Song *alpha_next;			// next pointers
	struct Song *duration_next;			// for linked list 
	struct Song *random_next;			//
} Song;

void insertNode(Song **chrono_head, Song *a) { //inserting nodes to linkled list 

	Song *temp = *chrono_head;			//temp song structure
	while(temp->chrono_next != NULL) {
		temp = temp->chrono_next;
	}
	temp->chrono_next = a;
	a->chrono_next = NULL;
}

Song* addSong(Song a) {		//adding song to the linked list
	Song *p = (Song*) malloc(sizeof(Song));
	if(p == NULL) {
		printf("cannot allocate memory.");
		exit(-1);
	}
	strcpy(p->songName,a.songName);
	p -> duration = a.duration;
	return p;

}

void printChrono(Song *ptr) {		//printing only chronological order
	int i = 1;
	printf("The list in chronological order:\n");
	Song *temp = ptr;
	while(temp != NULL) {
		printf("\t%d.%.25s\t%d:%d\n",i++,temp -> songName, (temp ->duration) / 60, (temp -> duration) % 60 );
		temp = temp->chrono_next;
	}
}
int secondsDuration(char *z) { // converting the string to int
	char *min = strtok(z,":");
	char *sec = strtok(NULL,"\n");
	int minute = atoi(min) * 60; // converting the string to int
	int second = atoi(sec); // converting the string to int

	return minute+second;

}
//main function
int main() {
	
	Song *chrono_head = NULL;										//ALLOCATING MEMORY FOR NODES
	chrono_head = (Song*)malloc(sizeof(Song));
	if(chrono_head == NULL) {
		printf("cannot allocate memory");
		return 0;
	}

	Song *alpha_head = NULL;
	alpha_head = (Song*)malloc(sizeof(Song));						//ALLOCATING MEMORY FOR NODES
	if(alpha_head == NULL) {
		printf("cannot allocate memory");
		return 0;
	}

	Song *duration_head = NULL;
	duration_head = (Song*)malloc(sizeof(Song));					//ALLOCATING MEMORY FOR NODES
	if(duration_head == NULL) {
		printf("cannot allocate memory");
		return 0;
	}

	Song *random_head = NULL;
	random_head = (Song*)malloc(sizeof(Song));						//ALLOCATING MEMORY FOR NODES
	if(random_head == NULL) {
		printf("cannot allocate memory");
		return 0;
	}

	char s[100];

	FILE *file = fopen("songs.txt", "r");  	//openin file in reading mode
	if(file == NULL) {
		printf("file couldnt open");		//control if file couldnt opened
		return 0;
	}

	fgets(s,100,file); //define the first head
	char *name = strtok(s, "\t"); //tokenize the first line for tab
	char *duration = strtok(NULL, "\n");



	if(name != NULL && duration != NULL) {
		strcpy((chrono_head) -> songName, name);
		(chrono_head)->duration =  secondsDuration(duration);
		(chrono_head)->chrono_next = NULL;
	} else {
		return 0;
	}

	//initiliaze the other part of the list
	while(fgets(s,100,file) != NULL) {
		char *name = strtok(s,"\t");
		char *duration = strtok(NULL,"\n");
		if(name != NULL && duration != NULL) {
			Song addNewSong;
			strcpy(addNewSong.songName,name);
			addNewSong.duration = secondsDuration(duration);
			Song *a =addSong(addNewSong);
			insertNode(&chrono_head,a);

		}
	}

	printChrono(chrono_head);

	int h;
	printf("Enter your choice: \n\t1 to insert a song into the list. \n\t2 to delete a song from the list. \n\t3 to print the songs in the list. \n\t4 to print the songs to an output file.\n\t5 to end.\n?\n");
	while (h != 5) {

		scanf("%d", &h);

		switch (h) {
			case 1:
				printf("1\n");
				break;
			case 2:
				printf("2");
				break;
			case 3:
				printChrono(chrono_head);
				break;
			case 4:
				printf("4");
				break;
			case 5:
				printf("5");
				break;

		}
	}



	return 0;
}
