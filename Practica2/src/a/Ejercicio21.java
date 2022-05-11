package a;
import java.util.*;
public class Ejercicio21 {
		public static void main(String args[]) {
			Scanner scanner=new Scanner(System.in);
			int a,b,c;
			while (true) {
				a=scanner.nextInt();
				b=scanner.nextInt();
				c=scanner.nextInt();
				if (!(+b>c||c+b>a||a+b>c)) {
					System.out.print("Los numeros pasados no pueden formar un triangulo\n");
					continue;
				}
				if (a==b&&a==b&&a==c) {
					System.out.print("El triangulo es equilatero\n");
				} else if (a==b||a==c||b==c) {
					System.out.print("El triangulo es isosceles\n");
				} else {
					System.out.print("El triangulo es escaleno\n");
				}
				System.out.print("Quieres seguir (S/N)");
				scanner.nextLine();
				if (scanner.nextLine().matches("N|n")) break;
				
			}
			scanner.close();
		}
}