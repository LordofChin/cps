# include <stdio.h>
# include <math.h>

int arr [] = {1,7,10,10,10,15,20,30,50,120};

int main(void) {
	int sum = 0;
	float mu = 0;
	int n = 0;
	int xsum = 0;
	float svar = 0;
	float sstddev = 0;
	float var = 0;
	float stddev = 0;

	for(int i = 0; i < sizeof(arr)/4; i++) {
		sum += arr[i];
		n++;
	}
	
	printf("sum: %d\nn: %d\n",sum,n);
	
	mu = (float)sum/n;

	for (int i = 0; i < sizeof(arr)/4; i++) {
		xsum += pow((mu - (float)arr[i]), 2);
	}

	printf("mean: %f\nxsum: %d\n", mu, xsum);
	
	svar = (float)xsum/(n-1);
	sstddev = sqrt(svar);	
	var = (float)xsum/(n);
	stddev = sqrt(var);

	printf("sample variance: %f\nsample stddev: %f\npopulation variance: %f\npopulation stddev: %f\n",svar,sstddev,var,stddev);

	return 0;
}
