//Include los headers
#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <stdarg.h>
#include <unistd.h>
#include <string.h>
#include <assert.h>
#include "type_defs.h"
//Define db_metadata
struct metadata_t db_metadata={
	.free_slots=0,
	.num_tables=0,
};
//Importa las funciones aplicables 
extern int create_table(void);
int main (void) {
	create_table();

}
