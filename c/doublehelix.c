/*
 *Doble helice 
 *Creado por Carlos Corbalan Andreu (corbalan.carlos420@gmail.com)
 *13/10/2021
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main (void) {
	//Crea un pointer de arrays donde guardar las lineas que conforman la doble helice
	char *array[10];
	while (1){
		//Aloca la memoria para las lineas 
		for (int i=0;i<10;i++) {
			array[i]=malloc(30);
		}
		//Crea las lineas
		for (int j=0;j<10;j++) {
			for (int i=0;i<10;i++) {
				//Elige los caracteres que formaran la linea
				if (i==j) strcat(array[j],"////");
					else if (i+j==9)
				strcat(array[j],"\\\\");
					else
				strcat(array[j]," ");
				if (i==9) strcat(array[j],"\n");
			}
			if (j!=5) printf("%s",array[j]);
		}
		//Garbage Collector
		for (int i=0;i<10;i++) {
			array[i]='\0';
			free(array[i]);
		}
	}
}
