#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>
int check (char a[]);
int main () {
	char a[15];
	int i=0;
	do {
		scanf("%s",a);
	} while (! check(a));
	float b = atof(a);	
	printf("%f\n",b);
};
int check (char a[]) {
	int i;
	if (!(a[0] == '+'| a[0] == '-')) {
		return 0;
	};
	if (isdigit(a[1]) == 0) {
		return 0;
	};
	if (a[2] != '.') {
		return 0;
	};
	for (i=3;i<strlen(a);i++) {
		if ( ! (isdigit(a[i]) |(i>=4 & a[i]=='e' ))) {
				return 0;
		};
		if (a[i] == 'e') {
			i++;
			break;
		};
	};
	if (a[i] == '-')
		i++;
	for (int c=i;c<strlen(a);c++) {
		if (isdigit(a[i]) == 0) {
			return 0;
		};
	};
};
