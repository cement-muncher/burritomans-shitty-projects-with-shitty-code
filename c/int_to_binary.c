#include <stdio.h>
#include <stdlib.h>

int main (void) {
	int a;
	scanf("%d",&a);
	for (int i=0;i<(sizeof(int)*8);i++) {
		if(i%8==0) printf("\n%3d ",32-i);
		((a<<i)&0x80000000)?printf("1"):printf("0");
	}
	printf("\n");
}
