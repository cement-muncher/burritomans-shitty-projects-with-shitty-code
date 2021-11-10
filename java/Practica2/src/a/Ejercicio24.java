package a;
import java.util.*;
public class Ejercicio24 {
		public static void main(String args[]) {
			Scanner scanner=new Scanner(System.in);
			System.out.print("Piensa un numero del 1 al 10\n");
			String a=scanner.nextLine();
			int b=(int) (Math.random()*10);
			System.out.print("El numero es " + b);
			if (Integer.parseInt(a)==b) System.out.print("Enhorabuena");
			scanner.close();
		}
}