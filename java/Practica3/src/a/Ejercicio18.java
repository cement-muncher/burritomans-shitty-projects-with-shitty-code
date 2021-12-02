package a;
import java.util.*;
public class Ejercicio18 {
	static Scanner scanner=new Scanner(System.in);
	static public void main(String args[]) {
		String i=esTriangulo();
		if (!i.matches("ERROR")) {
			System.out.printf("%s",i);  
		} else System.out.print("Los numeros dados no forman un triangulo");
	}
	static String esTriangulo() {
		int a,b,c;
		a=scanner.nextInt();
		b=scanner.nextInt();
		c=scanner.nextInt();
		if (!(a+b>c&&c+b>a&&a+c>b)) {
				return "ERROR";
		}
		if (a==b&&a==b&&a==c) {
			return "El triangulo es equilatero\n";
		} else if (a==b||a==c||b==c) {
			return "El triangulo es isosceles\n";
		} else {
			return "El triangulo es escaleno\n";
		}
	}
}
