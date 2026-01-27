# include <stdio.h>

int main()
{ 
int A[201] = {67};
int e = 6;
int f = 7;
A[200] = e - f + A[100];

printf("%d", A[200]);

return 0;
}
