package a;
import java.util.*;

public class Ejercicio13 {
	public static void main (String args[]) {
		Scanner scanner=new Scanner(System.in);
		int a=Integer.MIN_VALUE;
		String buffer;
		do {
			buffer=scanner.nextLine();
			a=(Integer.parseInt(buffer)>a)?Integer.parseInt(buffer):a;
			System.out.println("Escriba \"s\" para seguir");
			buffer=scanner.nextLine();
			if (buffer.compareToIgnoreCase("S")==1) break;
		} while (true);
		System.out.print(a);
		scanner.close();
	}
}
