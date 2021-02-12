#include <stdio.h>
#include <stdlib.h>
typedef struct nodo {
	int valor;
	struct nodo *ptr;
}nodo;
void meter (int a,nodo **node);
int extraer (nodo **node);
int main (void) {
	nodo *elemento=NULL;
	printf("%d\n",extraer(&elemento));
	printf("%d\n",extraer(&elemento));
	printf("%d\n",extraer(&elemento));
}
void meter (int a,nodo **node) {
	nodo *p=*node,*p1;
	if (p==NULL) {
		p=malloc(sizeof(nodo));
		p->valor=a;
		p->ptr=NULL;
		*node=p;
		return;
	}
	while (p!=NULL) {
		p1=p;
		p=p->ptr;
	}
	p=malloc(sizeof(nodo));
	p1->ptr=p;
	p->valor=a;
	p->ptr=NULL;
}
int extraer (nodo **node) {
	if (*node==NULL) {
		printf("FIFO empty!");
		return -1;
	}
	nodo *p=*node;
	*node=p->ptr;
	int a=p->valor;
	free(p);
	return(a);
}
