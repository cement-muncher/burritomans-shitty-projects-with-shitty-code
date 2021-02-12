#include <stdio.h>
#include <stdlib.h>
typedef struct nodo {
	int valor;
	struct nodo *ptr;
} nodo;
int pop(nodo **node);
void print(nodo *node);
void push (int valor,nodo **node);
int main (void) {
	nodo *last_node=NULL;
	push(10,&last_node);
	push(20,&last_node);	
	print(last_node);
	pop(&last_node);
	print(last_node);
}
void print(nodo *node) {
	if (node==NULL) printf("El stack esta vacio\n");
	while (node!=NULL) {
		printf("%d\n",node->valor);
		node=node->ptr;
	}
}
void push (int valor,nodo **node) {
	nodo *new_last_node;
	if (*node==NULL){
		new_last_node=malloc(sizeof(nodo));
		new_last_node->ptr=NULL;
		new_last_node->valor=valor;
		*node=new_last_node;
		return;
	}
	new_last_node=malloc(sizeof(nodo));
	new_last_node->ptr=*node;
	new_last_node->valor=valor;
	*node=new_last_node;

}
int pop(nodo **node) {
	if (node==NULL) {
		printf("stack is empty\n");
	} else {
		nodo *p1=*node;
		nodo *p2=p1->ptr;
		free(*node);
		*node=p2;
		
	}
}
