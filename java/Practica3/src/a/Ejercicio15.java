package a;
import java.util.*;

public class Ejercicio15 {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		String a=fibonacci(scanner.nextInt());
		System.out.print(a);
		scanner.close();
	}
	static String fibonacci(int num) {
		assert (num>0):"El numero es negativo";
		String a="";
		int value=0,value1=1;
		for (int i=0;i<num;i++) {
			value+=value1;
			value1=value-value1;
			a=a.concat(Integer.toString(value1)+" ");
		}
		return a;
	}
}
