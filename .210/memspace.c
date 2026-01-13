# include <stdio.h>

int main() {
	int a[] = {10,20,30,40,50};
	int * pc = a;
	
	printf("%d\n",*a);
	printf("%d\n",a[0]);
	printf("%d\n", *(a+1));
	printf("%d\n", *a +1);
	printf("%p\n", a + 2);
	printf("%d\n", *(a+5));
	printf("%d\n", ~-3);
	printf("%d\n", 01 & 12);
	
	
	for(int i = 0; i < 2; pc++, i++) {
		printf("%10d%10d%15p\n",i,*pc,pc);
	}
}
