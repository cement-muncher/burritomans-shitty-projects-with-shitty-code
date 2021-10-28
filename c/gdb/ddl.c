#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdarg.h>
#include <stdlib.h>
#include <sys/types.h>
#include "type_defs.h"
//Prototipos de las estructuras
extern struct metadata_t metadata;
extern void get_string(const char *string,char *input,size_t size);
int create_table(void);
void init_table(table_t *table);
int get_free(void);
int field_adder(table_t *table,int number);
int rename_field(table_t *table) {
void delete_table(table_t *table) {
//Utilizada para crear tablas
int create_table(void) {
	int result;
	result=get_free();
	if (result==-1) {
		dprintf(2,"There is no more room for a table");
		return -1;
	}
	db_metadata.tables[result]=malloc(sizeof(table_t));
	table_t *table=db_metadata.tables[result];
	init_table(table);
	int i=0,j=0;
	do {
		j=field_adder(table,i);
		if (!j && i==0) {
			char response;
		       	printf("Do you wish to quit the table creation wizard?(y/n)");
			scanf("%c%*c",&response);
			if (response=='y') return 2;
		}
		i++;
	} while(j);
	table->field_num=i;
	db_metadata.num_tables+=1;
	db_metadata.free_slots=0x1<<result;
	table->position=db_metadata.num_tables;
}
//Utilizada para obtener los miembros del array vacios
int get_free(void) {
        char checker=1;
        for (int i=0;i<SIZE;i++) {
                checker=db_metadata.free_slots&0x1<<i;
                if (!checker) return i;

        }
        return -1;
}
//Inicializa todos los valores de la tabla
void init_table(table_t *table) {
	get_string("The new table's name",table->name,STRING_SIZE);
	table->field_num=0;
	table->entry_num=0;
	for (int i=0;i<SIZE;i++) {
		table->field_name[i]='\0';
		table->data[i]=NULL;
	}
	
}
//Añade campos a la tabla
int field_adder(table_t *table,int number) {
	int return_value=-1;
	printf("Select the data type: STRING (0), LONG (2) , DOUBLE (4) \nIf you wish to quit type: QUIT (6)\n");
	int character;
        while (1) {
		scanf("%d%*c",&character);
		switch (character) {
			case (0):
				table->fields[number]=STRING;
	                        get_string("Field's name",table->field_name[number],STRING_SIZE);
				table->field_size[number]=STRING_SIZE;
				return_value=1;
				break;
			case(2):
				table->fields[number]=LONG;
        	                get_string("Field's name",table->field_name[number],STRING_SIZE);
				table->field_size[number]=LONG_S;
				return_value=1;
				break;
			case(4):
				table->fields[number]=DOUBLE;
        	                get_string("Field's name",table->field_name[number],STRING_SIZE);
				table->field_size[number]=DOUBLE_S;
				return_value=1;
				break;
			case(6):
				table->field[number]='\0';
				return_value=0;
				break;
			default:
				printf("Select the data type: STRING, LONG, DOUBLE\nIf you wish to quit type: QUIT\n");
                }
		if (return_value!=-1) break;
        }
	return return_value;
}
//Cambia el nombre de un campo
int rename_field(table_t *table) {
	char string[STRING_SIZE];
	get_string("Name of the field to rename",string,STRING_SIZE);
	for (int i=0;i<table->field_num;i++) {
		if (strcmp(table->field_name[i],string)) {
			get_string("Name to be renamed to:",string,STRING_SIZE);
			strcpy(table->field_name[i],string);
			return 1;
		}
	}
	return 0;
}
//Borra una tabla
void delete_table(table_t *table) {
	for (int i=0;i<SIZE;i++) free(data[i]);
	free(metadata_db.tables[position]);
	metadata_db.free_slots^(0x1<<table->position);
}	

