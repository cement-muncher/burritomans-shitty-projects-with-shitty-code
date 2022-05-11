package practica4;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String args[]) {
		int a=compararVectoresChar();
		if  (a<0) {
			System.out.print("La primera cadena es menor\n");
		} else if (a==0) {
			System.out.print("Las dos cadenas son iguales\n");
		} else { 
			System.out.print("La segunda cadena es mayor\n");
		}
	}
	private static int compararVectoresChar() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Escriba una string\n");
		String a=scanner.nextLine();
		System.out.print("Escriba una string\n");
		String b=scanner.nextLine();
		scanner.close();
		System.out.print(b.compareTo(a)+"\n");
		return a.compareTo(b);
	}
}
