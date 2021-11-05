package a;
import java.util.*;

public class Ejercicio7 {
	static public void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		int a=factorial(scanner.nextInt());
		System.out.print(a);
		scanner.close();
	}
	static int factorial(int number) {
		for (int i=number-1;i>1;i--) {
			number*=i;
		}
		return number;
	}
	
}
