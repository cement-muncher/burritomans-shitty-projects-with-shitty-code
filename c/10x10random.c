#include <stdio.h>
char random(int a, int b);
int main () {
	for (int i=1; i<11; i++) {
		for (int j=0;j<10;j++) {
			printf("%c",(65+random(i,j)));
		};
		printf("\n");
	};
};
char random (int a,int b) {
	int base = (a*b) ^ 0xFF;
	base & 0x8A;
	if ((base+1)%2) {
		base=a-b^base;
	} else {
		base=base%(a+1)^0xda;
	};
	return (base*a)%26;
};

