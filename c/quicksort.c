#include <stdio.h>
int funcion (int a[], int af[], int s, int e);
int main (void) {
	int array[5]={1,4,6,3,4}, arrayf[5];
	funcion(array,arrayf,0,4);
	for (int i=0;i<5;i++) {
		printf("%d ",arrayf[i]);
	}
	printf("\n");
}
int funcion (int a[], int af[], const int s, const int e) {
	printf("s:%d, e:%d\n ",s,e);
	for (int i=0;i<=e-s;i++) {
		printf("%d\n",a[i]);
	}
	if ((e-s)==-1) {
		return 1;
	} else if (e==s)  {
		af[s]=a[e-s];
		printf("af[%d]:%d\n",s,af[s]);
		return 1;
	} else if ((e-s)==1) {
		printf("a[0]: %d, a[1]: %d\n", a[0], a[1]);
		if (a[0]>a[1]) {
			af[e]=a[0];
			af[s]=a[1];
		} else {
			af[s]=a[0];
			af[e]=a[1];
		}
		return 1;
	} 
	int a1[10],a2[10], c1=0,c2=0, pivote=a[0];
	printf("pivote:%d\n",pivote);
	for (int i=1;i<=e-s;i++) {
		if (a[i]<pivote) {
			a1[c1++]=a[i];
			printf("a1:%d\n",a1[c1-1]);
		} else {
			a2[c2++]=a[i];
			printf("a2:%d\n",a2[c2-1]);
		}
	}
	af[c1+s]=pivote;
	printf("c1:%d c2:%d e:%d\n\n",c1,c2,e );
	funcion(a1,af,s,s+c1-1);
	funcion(a2,af,e-c2+1,e);
}
