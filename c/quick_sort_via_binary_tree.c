#include <stdio.h>
#include <stdlib.h>
//Define la estructura para las listas enlazadas
typedef struct nodo {
	int valor;
	struct nodo *ptr;
} nodo;
//Define la estructura para el arbol binario
typedef struct b_t {
	int valor;
	struct b_t *b1;
	struct b_t *b2;
} b_t;

//Inicializa las funciones
void insertar(nodo **nodo,int i);
b_t * quick_sort(nodo **node);
void print_bt(b_t **tree);
void liberar(nodo *node);

int main () {
	nodo *primero=NULL;
	int a;
	//Obten input del usuario y ponlos como una lista enlazada
	for (int i=0;i<5;i++) {
		scanf("%d",&a);
		insertar(&primero,a);
	}
	//Crea un nodo binario raiz
	b_t *raiz=quick_sort(&primero);
	print_bt(&raiz);
}
//Imprime el arbol binario
void print_bt(b_t **tree) {
	b_t *nodo=*tree;
	if (nodo->b1!=NULL) print_bt(&nodo->b1);
	printf("%d\n",nodo->valor);
	if (nodo->b2!=NULL) print_bt(&nodo->b2);
}
//Inserta un entero en una lista enlazada
void insertar(nodo **nodo,int i) {
	struct nodo *a=*nodo;
	if (a==NULL) {
		a=malloc(sizeof(nodo));
		a->valor=i;
		a->ptr=NULL;
		*nodo=a;
		return;
	}
	while (a->ptr!=NULL) a=a->ptr;
	struct nodo *b=malloc(sizeof(nodo));
	b->ptr=NULL;
	b->valor=i;
	a->ptr=b;
}
//Libera la memoria utilizada por una lista enlazada
void liberar (nodo *node) {
	if (node!=NULL) {
		if (node->ptr=NULL) liberar(node->ptr);
		free(node);
	}
}


/*
 * La parte tocha, empieza creando dos listas enlazadas donde se guardaran los valores mayores y menores que el pivote
 * en caso que una lista este vacia devuelve NULL,asigna el valor del pivote a la rama, en caso de que la lista contenga 
 * un solo numero lo asigna a un nodo final del arbol,separa los numeros y por ultimo llama recursivamente a la funcion 
 * que devolverá un puntero a un nodo del arbol el cual será asignado al nodo padre
 */
 
b_t * quick_sort(nodo **node) {
	nodo *list1=NULL;
	nodo *list2=NULL;
	b_t *branch=malloc(sizeof(b_t));
	if (*node==NULL) {
		return NULL;
	}
	nodo *nodo_pivote=*node;
	int pivote=nodo_pivote->valor;
	branch->valor=pivote;
	if (nodo_pivote->ptr==NULL) {
		branch->valor=pivote;
		branch->b1=NULL;
		branch->b2=NULL;
		return branch;
	}
	nodo_pivote=nodo_pivote->ptr;
	while (nodo_pivote!=NULL) {
		if (nodo_pivote->valor<pivote) {
			insertar(&list1,nodo_pivote->valor);
		} else {
			insertar(&list2,nodo_pivote->valor);
		}
		nodo_pivote=nodo_pivote->ptr;
	}
	branch->b1=quick_sort(&list1);
	branch->b2=quick_sort(&list2);
	liberar(list1);
	liberar(list2);
	return branch;
}
