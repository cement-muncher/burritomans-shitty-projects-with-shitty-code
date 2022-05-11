package a;

import java.util.*;

public class Ejercicio14 {
	public static void main(String args[]) {
		String a;
		Scanner scanner=new Scanner(System.in);
		a=rombo(scanner.nextInt());
		System.out.print(a);
		scanner.close();
	}
	static String rombo(int number) {
		String a="";
		for (int i=0;i<number;i++) {
			if (i<number/2) {
				for (int j=number;j>i;j--) a=a.concat(" ");
				a=a.concat("*");
				for (int k=0;k<i;k++) {
					a=a.concat("**");
				}
				a=a.concat("\n");
			} else {
				for (int j=(i+1);j>0;j--) {
					a=a.concat(" ");
				}
				a=a.concat("*");
				for (int j=i+1;j<number;j++) {
					if (i+1!=number) a=a.concat("**");
				}
				a=a.concat("\n");
			}
		}
		return a;
	}
}
