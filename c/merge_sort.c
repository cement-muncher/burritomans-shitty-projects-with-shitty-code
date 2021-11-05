#include <stdio.h>
int main (void) {
	int array[3]={3,41,7};
	funcion(array,0,2,3);
}
int funcion (int a[], int s, int e, int size) {
	if (size ==1) {
		return 1;
	} else if (size ==2) {
		if (a[s]>a[e]) {
			int bufer=a[s];
			a[s]=a[e];
			a[e]=bufer;
		}
		return 1;
	}
	int h=s+((e-s)/2);
	printf("s:%d,e:%d,size:%d,h:%d\n",s,e,size,h);
	funcion(a,s,h,h+1-s);
	funcion(a,h+1,e,e-h);
	funcion1(a,s,h,h+1,e);
}
int funcion1(int a[], int s1, int e1, int s2, int e2) {
	printf("s1:%d e1:%d s2:%d e2:%d\n",s1,e1,s2,e2);
	int a1[10],a2[10],c1=0,c2=0,c=s1;
	for (int i=s1;i<=e1;i++) {
		a1[c1++]=a[i];
		printf("a1[%d]:%d\n",c1-1,a1[c1-1]);
	}
	for (int i=s2;i<=e2;i++) {
		a2[c2++]=a[i];
		printf("a2[%d]:%d\n",c2-1,a2[c2-1]);
	}
	int f=0,g=0;
	while (( c1 != f) && ( c2 != g)) {
		if (a1[f]<a2[g]) {
			a[c++]=a1[f++];
		} else {
			a[c++]=a2[g++];
		}
	}
	printf("c:%d\n",c-s1);
	while (c1!=f) {
		a[c++]=a1[f++];
	}
	while (c2!=g) {
		a[c++]=a2[g++];
	}
	for (int i=0;i<3; i++) {
		printf("%d\n",a[i]);
	}
}
