package a;
import java.util.*;

public class Ejercicio6 {
	static public void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		calcularMostrarTabla(scanner.nextInt());
		scanner.close();
	}
	static void calcularMostrarTabla(int number) {
		for (int i=0;i<16;i++) {
			System.out.print(i+": "+number*i+"\n");
		}
	}
}
