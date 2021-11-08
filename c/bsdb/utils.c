#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <stdarg.h>
#include <sys/types.h>
#include <regex.h>
#include "type_defs.h"
#include <assert.h>

int get_string(const char *constant,char *input,size_t size);
char get_char(void);
//Utilizada para obtener un string de tamaño dinamico bytes de largo
int get_string(const char *constant,char *input,size_t size) {
        char string[size];
        char character;
        int n_chars;
	while (1) { 
		n_chars=0;
                printf("%s (%ld):",constant,size-1);
		while (1) {
			character=getchar();
			if ( character=='\n'||character=='\0'||character==EOF
					||character==' '){
				string[n_chars]='\0';
				break;
			} else if ( n_chars+1==size) {
				string[n_chars]='\0';
				break;
			}
			fflush(stdin);
			string[n_chars]=character;
			n_chars++;
		}
                printf("The recieved string is: %s\nDo you wish to continue?(y/n)\n",string);  
		character=get_char();
                if (character=='y') {
                        strcpy(input,string);
                        return 1;
                } else if (character=='n') {
			return 0;
		}
        }
}       
//Utilizada para leer un solo caracter
char get_char(void) {
	int character=getchar(),other_char;
	printf("%c\n",character);
	while ((other_char=getchar())!='\n'&& other_char!=EOF) continue;
	return (char) character;
}
		
