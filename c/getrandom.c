#include <stdio.h>
#include <stdlib.h>
int getrandom(void) {
	FILE *a=fopen("/dev/urandom","r");
	srandom(fgetc(a));
	return random();
}
