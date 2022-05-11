package a;
import java.util.*;
public class Ejercicio18 {
		public static void main(String args[]) {
			int number;
			Scanner scanner=new Scanner(System.in);
			while (true) {
				number=scanner.nextInt();
				if (number>-1) break;
			}
			if (number==0) System.out.print(1);
			for (int i=number-1;i>1;i--) {
				number*=i;
			}
			System.out.print(number);
			scanner.close();
		}
}
