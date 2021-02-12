#include <stdio.h>
#include <stdlib.h>
typedef struct binary_tree {
	int valor;
	struct binary_tree *rama_1;
	struct binary_tree *rama_2;
} binary_tree;
void recorrer(binary_tree **raiz);
int main(void) {
	binary_tree *raiz=malloc(sizeof(binary_tree));
	raiz->rama_1=malloc(sizeof(binary_tree));
	raiz->rama_2=malloc(sizeof(binary_tree));
	raiz->valor=20;
	raiz->rama_1->valor=10;
	raiz->rama_1->rama_2=NULL;
	raiz->rama_1->rama_1=NULL;
	raiz->rama_2->rama_2=NULL;
	raiz->rama_2->rama_1=NULL;
	raiz->rama_2->valor=30;
	recorrer(&raiz);
}
void recorrer(binary_tree **raiz) {
	binary_tree *nodo=*raiz;
	if (nodo->rama_2!=NULL) recorrer(&nodo->rama_2);
	if (nodo->rama_1!=NULL) recorrer(&nodo->rama_1);
	printf("%d\n",nodo->valor);
}
