#define FALSE 0
#define TRUE 1
#include <stdlib.h>
#include <stdio.h>
typedef struct nodo {
	char c;
	struct nodo *ptr;
} nodo;
void imprimir (nodo *a);
void funcion (nodo **a,char i);
void buscar(char c,nodo *a);
void eliminar(int b,nodo *a);
void insertar(int b,nodo *a, char c);


int main() {
	nodo *a=NULL;
	int b;
	scanf("%d",&b);
	char c;
	for (c='A';c<'M';c++){ 
		funcion(&a,c);
	}
	insertar(b,a,'Z');
	eliminar(0,a);
	imprimir(a);
	buscar('Z',a);
}
void buscar(char c,nodo *a) {
	int contador=1;
	while(a!=NULL) {
		if (a->c==c) printf("%c encontrado en la %d posicion\n",c,contador);
		contador++;
		a=a->ptr;
	}
	printf("Fin de la busqueda\n");
}
void eliminar(int b,nodo *a) {
	nodo *p1=a,*p2;
	if (b==0) {
		p2=p1->ptr;
		p1->c=p2->c;
		p1->ptr=p2->ptr;
		free(p2);
		return;
	}
	for (int i=0;i<b;i++) {
		p2=p1;
		p1=p1->ptr;
		if (p1==NULL) return;
	}
	p2->ptr=p1->ptr;
	free(p1);
}
void insertar(int b,nodo *a, char c) {
	nodo *p1=a;
	nodo *p2;
	int i=0;
	while(i<b) {
		p2=p1;
		p1=p1->ptr;
		i++;
		if (p1==NULL) return;
	};
	if (i==0) {
		nodo *p=malloc(sizeof(nodo));
		nodo *bufer=malloc(sizeof(nodo));
		bufer->ptr=a->ptr;
		bufer->c=a->c;
		a->ptr=p;
		a->c=c;
		p->c=bufer->c;
		p->ptr=bufer->ptr;
		free(bufer);
		return;
	}
	nodo *p=malloc(sizeof(nodo));
	p->ptr=p2->ptr;
	p->c=c;
	p2->ptr=p;
}

void imprimir (nodo *a) {
	while (a!=NULL)  {
		printf("%c 0x%x\n",a->c,a);
		a=a->ptr;
	}
}
void funcion (nodo **a,char i) {
	nodo *p1;
	p1=*a;
	if (p1==NULL) {
		p1=malloc(sizeof(nodo));
		p1->c=i;
		p1->ptr=NULL;
		*a=p1;
	} else {
		while (p1->ptr!=NULL) p1=p1->ptr;
		nodo *b=malloc(sizeof(nodo));
		b->c=i;
		b->ptr=NULL;
		p1->ptr=b;
	}
}
