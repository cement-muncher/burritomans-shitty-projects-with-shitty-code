package a;
import java.util.*;
public class Ejercicio14 {
		public static void main(String args[]) {
			Scanner scanner=new Scanner(System.in);
			int i=0,counter=0,total=0;
			while ((i=scanner.nextInt())>0) {
				total+=i;
				counter++;
			}
			System.out.print(total/counter);
			scanner.close();
		}
}