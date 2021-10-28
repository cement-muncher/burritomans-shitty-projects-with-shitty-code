#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <stdargs.h>
#include <sys/types.h>
#include "type_defs.h"
//Utilizada para obtener los miembros del array vacios
int get_free(void) {
        char checker=1;
        for (int i=0;i<SIZE;i++) {
                checker=metadata.free_slots&0x1<<i;
                if (!checker) return i;
        
        }
        return -1;
}       
//Utilizada para obtener un string de tamaño dinamico bytes de largo
void get_string(char *input,size_t size) {
        char string[size];
        char character;
        int n_chars;
        while (1) { 
                printf("Write a %ld char long string, no spaces:",size-1);
                fgets(string,size,stdin);
                for (int i=0;i<size;i++) if (string[i]=='\n') string[i]='\0';
                printf("The recieved string is:%s\nDo you wish to continue?(y/n)\n",string);  
                scanf("%1c%*c",&character);
                if (character=='y') {
                        memcpy(input,string,size);
                        return;
                }
        }
}       
//Parser de tipos y sus nombres
void field_adder(table table_parsed,int number) {
	table_parsed->args[number]=malloc(sizeof(char));
	table_parsed->name_field[number]=malloc(sizeof(char)*STRING_SIZE);
	char string[6];
	int iftrue=0;
	while (1) {
		get_string(string,sizeof(string));
		switch (string) {
			string=="STRING":table_parsed->args[number]=STRING;
					 get_string(table_parsed->name_field[number],STRING_SIZE);
					 iftrue=1;
					 break;
			string=="LONG":table_parsed->args[number]=LONG;
				       get_string(table_parsed->name_field[number],STRING_SIZE);
				       iftrue=1;
				       break;
			string=="DOUBLE":table_parsed->args[number]=DOUBLE;
					 get_string(table_parsed->name_field[number],STRING_SIZE);
					 iftrue=1;
					 break;
		}
		if (iftrue) break;
	}
}
