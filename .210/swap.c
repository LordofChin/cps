/* swap3.c -- using pointers to make swapping work
   From C Primer Plus, LISTING 9.15 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void interchange(int * u, int * v);

int main(void)
{
	srand(time(NULL));
    int a[rand() % (40 - 10) - 1];
	
	for(int i = 0; i < sizeof(a)/4; i++) 
		{
		*(a+i) = rand() % 1000;
		}

	//iterate over array

    for (int i = 0; i < (sizeof(a)/sizeof(int)); i++) 
	{

	//bubble sort

	for(int j = 0; j < (sizeof(a)/sizeof(int))-1; j++)
		{
		if ( *(a+i) < *(a+j)) {interchange((a+i), (a+j));}
		}
	}

/*
	//quick sort
	struct Node {
		int data;
		int * left;
		int * right;
	}
*/
	//print array iteratively

	for(int i = 0; i < sizeof(a)/4; i++) 
		{
		printf("%d ", *(a+i));
		}
	printf("\n");
    return 0;
}

void interchange(int * u, int * v)
{
    int temp;
    temp = *u;   /* temp gets value that u points to */
    *u = *v;
    *v = temp;
}
