package a;
import java.util.*;

public class Ejercicio10 {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		rombo(scanner.nextInt());
		scanner.close();
	}
	static void rombo(int number) {
		String a="*";
		int offset=number;
		for (int i=0;i<number;i++) {
			if (i<number/2) {
				for (int j=number;j>i;j--) System.out.print(" ");
				System.out.print(a+"\n");
				a=a.concat("**");
			} else {
				for (int j=(i+1);j>0;j--) System.out.print(" ");
				System.out.print(a+"\n");
				if ((offset-=2)<0) break;
				a=a.substring(0,offset);
			}
		}
	}
}
