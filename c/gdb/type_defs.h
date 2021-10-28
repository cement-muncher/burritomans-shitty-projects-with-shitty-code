#ifndef TYPES

#define TYPES
//Define los tipos
#define STRING 1
#define CHAR_P 2
#define LONG 3
#define LONG_P 4
#define DOUBLE 5
#define DOUBLE_P 6
//Define el tamaño de los tipos
#define CHAR_S sizeof(char)
#define CHAR_P_S sizeof(char *)
#define LONG_S sizeof(long)
#define LONG_P_S sizeof(long *)
#define DOUBLE_S sizeof(double)
#define DOUBLE_P_S sizeof(double *)
//Define el tamaño de los arrays basado en el tipo de free_slots;
#define SIZE 64
#define STRING_SIZE 25
typedef struct table {
	char name[STRING_SIZE]
	int arg_num;
	char *args[SIZE];
	void *data[SIZE];
	char name_field[SIZE][STRING_SIZE];
} table;
typedef struct relation {
	char name[STRING_SIZE];
	void *references[SIZE];
	void *references[SIZE];
	struct table *tables[2];
}
struct {
	long free_slots;
	char num_tables;
	struct table *tables[SIZE];	
	struct relation *relationships[SIZE];
} metadata = {
	.free_slots=0,
	.num_tables=0,
};
#endif
