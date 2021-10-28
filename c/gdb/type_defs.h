#ifndef TYPES

#define TYPES
//Define los tipos
#define STRING 0
#define CHAR_P 1
#define LONG 2
#define LONG_P 3
#define DOUBLE 4
#define DOUBLE_P 5
//Define el tamaño de los tipos
#define CHAR_P_S sizeof(char *)
#define LONG_S sizeof(long)
#define LONG_P_S sizeof(long *)
#define DOUBLE_S sizeof(double)
#define DOUBLE_P_S sizeof(double *)
//Define el tamaño de los arrays basado en el tipo de free_slots;
#define SIZE 64
//Define el tamño de las strings
#define STRING_SIZE 25
typedef struct table {
	char name[STRING_SIZE];
	int entry_num;
	int field_num;
	size_t field_size[SIZE];
	char fields[SIZE];
	void *data[SIZE];
	char field_name[SIZE][STRING_SIZE];
	long position;
} table_t;
typedef struct relation {
	char name[STRING_SIZE];
	void *references[SIZE];
	void *referenced[SIZE];
	struct table *tables[2];
} relation_t;
struct metadata_t {
	long free_slots;
	char num_tables;
	struct table *tables[SIZE];	
	struct relation *relationships[SIZE];
};
extern struct metadata_t db_metadata;
#endif
