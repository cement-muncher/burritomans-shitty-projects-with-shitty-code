#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <stdarg.h>
#include <sys/types.h>
#include "type_defs.h"
int get_string(const char *constant,char *input,size_t size);
char get_char(void);
//Utilizada para obtener un string de tamaño dinamico bytes de largo
int get_string(const char *constant,char *input,size_t size) {
        char string[size];
        char character;
        int n_chars;
        while (1) { 
                printf("%s (%ld):",constant,size-1);
                fgets(string,size,stdin);
                for (int i=0;i<size;i++) if (string[i]=='\n') string[i]='\0';
                printf("The recieved string is: %s\nDo you wish tso continue?(y/n)\n",string);  
		character=sget_char();
		
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
	while ((other_char=getchar())!='\n'&& other_char!=EOF) continue;
	return (char) character;
}
		
