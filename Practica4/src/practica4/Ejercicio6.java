package practica4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio6 {
	static public void main(String args[]) {
		int a=contarIntConsecutivos();
		System.out.print("Hay "+a+" seguidos");
	}
	static private int contarIntConsecutivos() {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> array=new ArrayList<Integer>();
		int a,b,c,d;
		a=0;
		System.out.print("Escriba enteros, para terminar excriba una string que no pueda ser representada como un entero\n");
		while (true) {
			try {
				a=scanner.nextInt();
				array.add(a);
			} catch (Exception e) {
				break;
			}
		}
		c=0;
		d=0;
		for (int i=0;i<array.size()-1;i++) {
			b=array.get(i);
			if (b+1==array.get(i+1)) {
				c=(c==0)?1:c;
				c++;
				d=(c>d)?c:d;
			} else {
				c=0;
			}
		}
		scanner.close();
		return d;
	}
}
