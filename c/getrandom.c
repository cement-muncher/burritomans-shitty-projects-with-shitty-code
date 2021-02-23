#include <stdio.h>
#include <stdlib.h>
/*A simple program to get random numbers, made for other programs where a RNG may be needed, thought to be used in Linux*/
int getrandom(void) {
	FILE *a=fopen("/dev/urandom","r");
	srandom(fgetc(a));
	return random();
}
