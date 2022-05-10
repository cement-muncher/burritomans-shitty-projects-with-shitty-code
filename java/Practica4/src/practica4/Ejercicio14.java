package practica4;

import java.util.*;
public class Ejercicio14 {
	static public void main(String args[]) {
		Scanner a=new Scanner(System.in);
		String string=a.nextLine();
		int[] b= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		char c;
		for (int i=0;i<string.length();i++) {
			c=string.toUpperCase().charAt(i);
			b[(char) c-65]++;
		}
		for (int i=0;i<26;i++) {
			System.out.printf("%c ",i+65);
			System.out.print(b[i]+"\n");
		}
		a.close();
	}
}
