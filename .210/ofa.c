# include <limits.h>
# include <stdio.h>
# include <stdbool.h>

bool add_overflow(int a, int b, int *out) {
	if (b>0)
		{if(a>INT_MAX-b) return false;}
	else if (b<0)
		{if(a<INT_MIN-b) return false;}
	*out = a + b;
	return true;
}

int main (){
	printf("Enter a below:\n");
	int a = 0;
	scanf("%d", &a);
	printf("Enter b below\n");
	int b = 0;
	scanf("%d", &b);
	
	int x = 0;
	if(!__builtin_add_overflow(a,b,&x)) {
		printf("%d + %d = %d\n",a,b,x);
	} else {printf("Overflow detected\n");}
	
}
