package a;
import java.util.*;

public class Ejercicio11 {
	public static void main (String args[]) {
		Scanner scanner=new Scanner(System.in);
		float ci,r,n;
		ci=scanner.nextFloat();
		r=scanner.nextFloat();
		n=scanner.nextFloat();
		System.out.print(ci*Math.pow((1+r/100), n));
		scanner.close();
	}
}