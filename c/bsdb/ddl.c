#include <stdio.h>
#include <assert.h>
#include <unistd.h>
#include <string.h>
#include <stdarg.h>
#include <stdlib.h>
#include <sys/types.h>
#include "type_defs.h"
//Definiciones de constantes
#define TABLES 1
#define RELATIONS 0
//Prototipos de las estructuras
extern struct metadata_t metadata;
//Definiciones de utils.c
extern int get_string(const char *string,char *input,size_t size);
extern char get_char(void);
//Prototipos de creaccion de tablas
int create_table(void);
int init_table(table_t *table);
long get_free(int value);
int field_adder(table_t *table,int number);
int rename_field(table_t *table);
int check_table_name(table_t *tables,const char *string,int number);
//Utilizada para crear tablas
int create_table(void) {
	long result;
	result=get_free(TABLES);
	if (result==-1) {
		dprintf(2,"There is no more room for a table\n");
		return -1;
	}
	db_metadata.tables[result]=malloc(sizeof(table_t));
	table_t *table=db_metadata.tables[result];
	if (!init_table(table)) {
		free(table);
		return 0;
	}	
	int i=0;
	i=field_adder(table,0);
	if (i==0) {
		free(table);
		return 0;
	}
	table->field_num=i;
	db_metadata.num_tables+=1;
	db_metadata.free_slots_tables=0x1<<result;
	table->position=0x1<<result;
	return 1;
}
//Utilizada para obtener los miembros del array vacios
long get_free(int value) {
        char checker=1;
	if (TABLES) {
		long *freeslots=&db_metadata.free_slots_tables;
        	for (int i=0;i<SIZE;i++) {
                	checker=*freeslots&0x1<<i;
               		 if (!checker) return i;
		}
	} else if (!RELATIONS) {
		long *freeslots=&db_metadata.free_slots_relations;
        	for (int i=0;i<SIZE;i++) {
	                checker=*freeslots&0x1<<i;
        	        if (!checker) return i;
		}

	} else {
		return -1;
        }
        return -1;
}
//Inicializa todos los valores de la tabla
int init_table(table_t *table) {
	char string[STRING_SIZE];
	if (!get_string("The new table's name (QUIT to exit)",string,STRING_SIZE)||strcmp("QUIT",string)==0){
		printf("Are you sure you want to quit (y/n):");
		char quit;
		quit=get_char();
		if (quit=='y')	return 0;
	}
	strcpy(table->name,string);
	table->field_num=0;
	table->entry_num=0;
	for (int i=0;i<SIZE;i++) {
		table->field_name[i][0]='\0';
		table->data[i]=NULL;
	}
	return 1;
	
}
//Añade campos a la tabla
int field_adder(table_t *table,int number) {
	int return_value=0+number, breakable=0;
	char character;
        while (1) {
		printf("Select the data type: STRING (0), LONG (2) , DOUBLE (4) \nIf you wish to quit type: QUIT (6)\n");
		character=get_char();
		switch (character) {
			case (48):
				table->fields[return_value]=STRING;
	                        if (!get_string("String field's name",table->field_name[return_value],STRING_SIZE)) break;
				if (!check_table_name(table,table->field_name[return_value],return_value)) break;
				table->field_size[number]=STRING_SIZE;
				return_value++;
				break;
			case(50):
				table->fields[return_value]=LONG;
        	                if (!get_string("Long field's name",table->field_name[return_value],STRING_SIZE)) break;
				if (!check_table_name(table,table->field_name[return_value],return_value)) break;
				table->field_size[number]=LONG_S;
				return_value++;
				break;
			case(52):
				table->fields[return_value]=DOUBLE;
        	                if (!get_string("Double field's name",table->field_name[return_value],STRING_SIZE)) break;
				if (!check_table_name(table,table->field_name[return_value],return_value)) break;
				table->field_size[number]=DOUBLE_S;
				return_value++;
				break;
			case(54):
				table->fields[return_value]='\0';
				breakable=1;
				printf("Are you sure you want to quit? (y/n)\n");
				if (0==return_value) printf("You have written no fields, continuing will erase the table\n");
				character=get_char();
				if (character==121) return return_value;
				break;
                }
		if (breakable) break;
	}
	return return_value;
}
//Asegura que no existen dos campos con el mismo nombre
int check_table_name(table_t *table,const char *string,int number) {
	for (int i=number;0<number;i--) {
		if (strcmp(table->field_name[i],string)==0) {
			printf("The field identifier has already been used\n");
			return 0;
		}
		if (table->fields[i]=='\0') break;
	}
	return 1;
}
//Cambia el nombre de un campo
int rename_field(table_t *table) {
	char string[STRING_SIZE];
	get_string("Name of the field to rename",string,STRING_SIZE);
	for (int i=0;i<table->field_num;i++) {
		if (strcmp(table->field_name[i],string)) {
			get_string("Name to be renamed to ",string,STRING_SIZE);
			strcpy(table->field_name[i],string);
			return 1;
		}
	}
	return 0;
}
//Comienzo de las funciones relacionadas con relaciones (valga la redundancia)
//Prororipacion de las funciones
int create_relation(table_t *origin, table_t *destination);
int init_relation(relation_t *relation);
int link_tables (table_t *origin, table_t *destination);
int create_relation(table_t *origin, table_t *destination) {
	long result;
	result=get_free(RELATIONS);
	if (result==-1) {
		dprintf(2,"No more space for another relation\n");
		return -1;
	}
	db_metadata.relationships[result]=malloc(sizeof(relation_t));
	relation_t *relation=db_metadata.relationships[result];
	result=init_relation(relation);
	if (!result) {
		free(relation);
		return 0;
	}
	relation->tables[0]=origin;
	relation->tables[1]=destination;
	int i=1;
	do {
		link_tables(origin,destination);
	} while(!i);

}
int init_relation(relation_t *relation) {
	char string[STRING_SIZE];
	get_string("Name the relationship (QUIT to exit)",string,STRING_SIZE);
	if (strcmp(string,"QUIT")) {
		printf("Are you sure you want to quit the relationship creation wizard?(y/n)");
		char quit;
		quit= (char) getchar();
		if (quit=='q') return 0;
	}
	return 1;
}
int link_tables (table_t *origin, table_t *destination) {
	char string[STRING_SIZE];
	int origin_data_size=0, destination_data_size=0;
	int i=0,j=0, type;
	get_string("Choose the field to be linked", string, STRING_SIZE);
	for (;i<origin->field_num;i++) {
		if (strcmp(string,origin->field_name[i])==0) {
			switch (origin->fields[i]) {
				case(STRING):origin->fields[i]=STRING_P;
					origin->field_size[i]=STRING_P_S;
					type=STRING;
					break;
				case(LONG):origin->fields[i]=LONG_P;
					origin->field_size[i]=LONG_P_S;
					type=LONG;
					break;
				case(DOUBLE):origin->fields[i]=DOUBLE_P;
					origin->field_size[i]=DOUBLE_P_S;
					type=DOUBLE;
					break;
			}
			break;
		}
		origin_data_size+=origin->field_size[i];
	}
	get_string("Choose the field to be linked to", string, STRING_SIZE);
	for (;j<origin->field_num;j++) {
		if (strcmp(string,destination->field_name[i])==0) {
			switch (destination->fields[j]) {
				case(STRING):destination->fields[j]=STRING_P;
					destination->field_size[j]=STRING_P_S;
					if (type!=STRING) return 0;
					break;
				case(LONG):destination->fields[j]=LONG_P;
					destination->field_size[j]=LONG_P_S;
					if (type!=STRING) return 0;
					break;
				case(DOUBLE):destination->fields[j]=DOUBLE_P;
					destination->field_size[j]=DOUBLE_P_S;
					if (type!=DOUBLE) return 0;
					break;
			}
		break;
		}
	destination_data_size+=destination->field_size[j];
	}
	int breakable=0;
	while (1) {
		int relation;
		printf("Choose which type of relation it is: 1-1 (0) 1-N (1) N-M (2)");
		relation=getchar();
		switch (relation) {
			case(ONE_ONE):printf("a\n");
				      breakable=1;
				      break;
			case(ONE_N):printf("b\n");
				    breakable=1;
				    break;
			case(N_M):printf("c\n");
				  breakable=1;
				  break;
		}
	}
	if (breakable) return 1;				
}



