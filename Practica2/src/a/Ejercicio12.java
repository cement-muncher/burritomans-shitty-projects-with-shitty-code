package a;
import java.util.*;

public class Ejercicio12 {
	public static void main (String args[]) {
		Scanner scanner=new Scanner(System.in);
		int a=0;
		for (int i=0;i<7;i++) a+=scanner.nextInt();
		System.out.print(a);
		scanner.close();
	}
}
