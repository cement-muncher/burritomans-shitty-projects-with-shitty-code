package a;
import java.util.*;
public class Ejercicio17 {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		int a=0;
		String b;
		char i[]= new char[1];
		while (true) {
			System.out.print("Escribe el lado del cuadrado\n");
			try {
				a=scanner.nextInt();
			} 
			catch(Exception e) {
				System.out.print("Por favor introduce un numero\n");
				scanner.next();
			}
			if (a>0) break;
		}
		while (true) {
			System.out.print("Escriba el caracter a mostrar\n");
			b=scanner.next();
			i=b.toCharArray();
			if (i[0]>32) break;
		}
		System.out.print(muestraCuadrado(a,i[0]));
		scanner.close();
	}
	static String muestraCuadrado(int size,char character) {
		String result="";
		for (int i=0;i<size;i++) {
			for (int j=0;j<size;j++) {
				if (j==0||j==size-1||i==0||i==size-1) {
					result+=character; 
				} else result+=' ';
			}
			result+='\n';
		}
		return result;
	}
}
