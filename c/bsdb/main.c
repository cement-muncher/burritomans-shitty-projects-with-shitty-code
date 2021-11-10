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
int main (void) {
	create_table();
	printf("Num Tables:%d\nNum relations:%d\n",db_metadata.num_tables,db_metadata.num_relations);
	printf("Name of the table:%s\nNum of fields:%d\n",db_metadata.tables[0]->name,db_metadata.tables[0]->field_num);
}
