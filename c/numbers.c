#include <stdlib.h>
#include <stdio.h>
#include <regex.h>
#include <sys/types.h>
#include <string.h>

enum {
	HEXADECIMAL,
	BINARY,
	OCTAL
};
size_t format (char *data, int *type);
size_t size_calculator(int format, char *data);
void print_number(size_t size,char *data, int format);
int main (int args,char *argv[]) {
	if (args != 2) return 1;
	int *type;
	size_t size=format(argv[1],type)
	if (size==0) return 1;
	print_number(size,argv[1],*type);
	return 0;
}
//Se asegura que los numeros pasados corresponden al formateo adecuado
size_t format (char *data,int *type) {
	regex_t preg;
	char *regex[3]={"^0x[0-9A-F]{1,}$", "^[01]{1,}b$","^0[0-7]{1,}$"};
	for (int i=0;i<3;i++) {
		regcomp(&preg,regex[i],REG_EXTENDED);
		if (0==regexec(&preg,data,0,NULL,0)) {
			size_t result=size_calculator(i,data);
			regfree(&preg);
			*type=i;
			return result;
		} else if (i==3) {
			regfree(&preg);
			return 0;
		} else {
			regfree(&preg);
		}
	}
}
//Calacula el tamaño del numero dentro de la string
size_t size_calculator(int flag, char *data) {
	if (flag==HEXADECIMAL) {
		float t_b_calculated=strlen(data);
		t_b_calculated=(t_b_calculated-2)/2;
		return t_b_calculated - (int) t_b_calculated ==0?
			 (size_t) t_b_calculated:
			 (size_t) (t_b_calculated+1);
	} else if (flag==BINARY) {
		float t_b_calculated=strlen(data);
		t_b_calculated=(t_b_calculated-1)/8;
		return t_b_calculated - (int) t_b_calculated ==0?
			(size_t) t_b_calculated:
			(size_t) (t_b_calculated+1);
	} else if (flag==OCTAL) {
		float t_b_calculated=strlen(data);
		t_b_calculated=(t_b_calculated-1)/3;
		return t_b_calculated - (int) t_b_calculated ==0?
			 (size_t) t_b_calculated:
			 (size_t) (t_b_calculated+1);
	}
}	
//Funcion que resuelve los nuemeros a otros sistemas
void print_number(size_t size,char *data,int format) {
}
