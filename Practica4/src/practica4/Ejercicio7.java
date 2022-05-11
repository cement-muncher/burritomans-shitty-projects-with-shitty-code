package practica4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String args[]) {
		int a=buscarInt();
		System.out.print("La primera ocurrencia se encuentra en la posición "+a+"\n");
	}
	public static int buscarInt() {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> array=new ArrayList<Integer>();
		int a;
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
		scanner.nextLine();
		System.out.print("Escriba un entero:");
		while (true) {
			try {
				a=scanner.nextInt();
				array.add(a);
				break;
			} catch (Exception e) {
				continue;
			}
		}
		scanner.close();
		return array.indexOf(a);
	}
}
