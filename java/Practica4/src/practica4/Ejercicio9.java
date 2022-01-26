package practica4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio9 {
	static public void main(String args[]) {
		Counter a=masFrecuenteInt();
		System.out.print("El numero mas frecuente es "+a.numero+" apareciendo un total de "+a.contador+" veces");
	}
	static private Counter masFrecuenteInt() {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Counter> array=new ArrayList<Counter>();
		int a,b;
		a=0;
		b=0;
		Ejercicio9 c=new Ejercicio9();
		Counter buffer=c.new Counter(); 
		System.out.print("Escriba enteros, para terminar excriba una string que no pueda ser representada como un entero\n");
		while (true) {
			try {
				a=scanner.nextInt();
				buffer.numero=a;
				for (int i=0;i<b;i++) {
					if (array.get(i).numero==buffer.numero) {
						buffer.contador=array.get(i).contador++;
						array.set(i, buffer);
					} else if (i+1==b) {
						array.add(buffer);
					}
					b++;
				}
				if (b==0) {
					array.add(buffer);
					b++;
				}
			} catch (Exception e) {
				break;
			}
		}
	a=0;
	for (int i=b-1;i>=0;i--) {
		if (array.get(i).contador>=a) {
			buffer.numero=array.get(i).numero;
			buffer.contador=array.get(i).contador;
			
		}
	}
	scanner.close();
	return buffer;
	}
	private class Counter{
		int numero=0;
		int contador=0;
	}
}
