#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void clearInputBuffer();

int main(void) {
    puts("Number Converter");
    char userChoiceOriginal = ' ';
    char userChoiceDesired = ' ';
    int numberToConvert = 0;
    char* convertToBinary(int NTC);

    puts("Please choose the original number system, d for Decimal, o for Octal, h for Hex:");
    scanf("%c", &userChoiceOriginal);
    clearInputBuffer();
    
    switch(userChoiceOriginal){
        case 'd':   printf("Please enter decimal number: ");
                    scanf("%d", &numberToConvert);   
                    clearInputBuffer(); 
                    break;
        case 'o':   printf("Please enter octal number: ");
                    scanf("%o", &numberToConvert);   
                    clearInputBuffer(); 
                    break;
        case 'h':   printf("Please enter hexadecimal number: ");
                    scanf("%x", &numberToConvert);   
                    clearInputBuffer();     
                    break;
        default:    puts("Incorrect input. Bye!");  
                    break;               
    }
    
    //Ask for desired output system and then display accordingly
	//Minimum requirement: allow user to choose from decimal, octal, and hex system
	
    puts("Please choose the desired number system, d for Decimal, o for Octal, h for Hex:");
    scanf("%c", &userChoiceDesired);
    
    clearInputBuffer();

    switch(userChoiceDesired) {
	case 'd':   printf("%d\n",numberToConvert);
		    break;
	case 'o':   printf("%o\n",numberToConvert);
		    break;
	case 'h':   printf("%x\n",numberToConvert);
		    break;
	default:    printf("Incorrect input. Bye!\n");
		    break;
    }	
		
	//Challenge yourself (optional): output the binary of the number 
    printf("Number in binary is: %s\n",convertToBinary(numberToConvert));	
     

    return 1;
}

void clearInputBuffer(){
    char ch;
    while((ch = getchar()) != '\n');
}

char* convertToBinary(int NTC) {
    static char tempArr[64];
    int i = 0;

    if (NTC == 0) {
        strcpy(tempArr, "0");
        return tempArr;
    }

    while (NTC > 0) {
        tempArr[i++] = (NTC % 2) ? '1' : '0';
        NTC /= 2;
    }
    tempArr[i] = '\0';

    return tempArr;
}
