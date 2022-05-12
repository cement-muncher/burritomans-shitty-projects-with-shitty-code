package practica4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio8 {
	static public void main(String args[]) {
		if (yaOrdenado()) {
			System.out.print("Esta ordenado");
		} else {
			System.out.print("No está ordenado");
		}
	}
	static private boolean yaOrdenado() {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> array=new ArrayList<Integer>();
		int a,b;
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
		scanner.close();
		if (array.get(1)==array.get(0)+1) {
			for (int i=0;i<array.size()-1;i++) {
				b=array.get(i);
				if (b+1!=array.get(i+1)) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}
}
