#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <stdarg.h>
#include <sys/types.h>
#include "type_defs.h"
//Utilizada para obtener un string de tamaño dinamico bytes de largo
void get_string(const char *constant,char *input,size_t size) {
        char string[size];
        char character;
        int n_chars;
        while (1) { 
                printf("%s (%ld):",constant,size-1);
                fgets(string,size,stdin);
                for (int i=0;i<size;i++) if (string[i]=='\n') string[i]='\0';
                printf("The recieved string is: %s\nDo you wish to continue?(y/n)\n",string);  
                scanf("%1c%*c",&character);
                if (character=='y') {
                        strcpy(input,string);
                        return;
                }
        }
}       
