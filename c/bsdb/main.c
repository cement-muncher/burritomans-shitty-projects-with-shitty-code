//Include los headers
#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <stdarg.h>
#include <unistd.h>
#include <string.h>
#include <assert.h>
#include "type_defs.h"
struct metadata_t db_metadata={
	.free_slots_tables=0,
	.free_slots_relations=0,
	.num_relations=0,
	.num_tables=0,
};
//Importa las funciones aplicables 
extern int create_table();
extern int create_relation();
int main (void) {
	for (int i=0;SIZE>i;i++){
		db_metadata.tables[i]=NULL;
		db_metadata.relationships[i]=NULL;
	}
	create_table();
	create_table();
	create_relation(db_metadata.tables[0],db_metadata.tables[1]);	
	printf("Num Tables:%d\nNum relations:%d\n",db_metadata.num_tables,db_metadata.num_relations);
	printf("Name of the table:%s\nNum of fields:%d\n",db_metadata.tables[0]->name,db_metadata.tables[0]->field_num);
}
