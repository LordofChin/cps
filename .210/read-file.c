#include<stdio.h>
#include<stdlib.h>

int main() {
	char fileName[] = "simpleFile.txt";
	FILE *fp;
	double sum = 0.0, num = 0.0;
	int count = 0;
	
	fp = fopen(fileName, "r");
	if (!fp) {
		printf("file not found!\n");
	}
	while (fscanf(fp, "%lf", &num) ==1) {
		if (num != 0) {
		sum += num;
		count++;
		}
	}
	
	printf("Sum = %lf, count = %d\n", sum, count);
	printf("Average = %lf\n", sum/count);
	return 0;
}
