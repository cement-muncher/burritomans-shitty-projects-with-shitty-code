package practica4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio10 {
	static public void main(String args[]) {
		int a=buscarSecuenciasInt();
		System.out.print("El vector contiene "+a+" miembros de la segunda string");
	}
	static private int buscarSecuenciasInt() {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> array1=new ArrayList<Integer>();
		ArrayList<Integer> array2=new ArrayList<Integer>();
		int a,c,d;
		a=0;
		System.out.print("Escriba enteros, para terminar excriba una string que no pueda ser representada como un entero\n");
		while (true) {
			try {
				a=scanner.nextInt();
				array1.add(a);
			} catch (Exception e) {
				break;
			}
		}
		scanner.nextLine();
		System.out.print("Escriba enteros, para terminar excriba una string que no pueda ser representada como un entero\n");
		while (true) {
			try {
				a=scanner.nextInt();
				array2.add(a);
			} catch (Exception e) {
				break;
			}
		}
		c=0;
		d=0;
		for (int i=0;i<array1.size();i++) {
			if (array1.get(i)==array2.get(c++)) {
				d=(c>d)?c:d;
			} else {
				c=0;
			}
			if (c==array2.size()) break;
		}
		scanner.close();
		return d;
	}
}


