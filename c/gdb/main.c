//Include los headers
#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <stdarg.h>
#include <unistd.h>
#include <string.h>
#include <assert.h>
#include "type_defs.h"
#include "utils.h"
//Define las funciones aplicables 
int create(void);
long create_new_table(void);
int main (void) {

}
//Crea una nueva tabla
int create(void) {
	int result;
	get_free()=result;
	if (result) {
		dprintf(2,"Not enough space to allocate the new table");
		return -1;
	}
	
}
