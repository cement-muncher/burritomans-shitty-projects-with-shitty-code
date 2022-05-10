
import java.util.Scanner;
public class Practica4 {
	public static void main(String args[]) {
		Scanner a=new Scanner(System.in);
		String c=a.nextLine();
		String d=a.nextLine();
		int b=obtenerNumeroVecesSubCadena2(c,d);
		System.out.print(b);
		a.close();
	}
	private static int obtenerNumeroVecesSubCadena2(String a, String b) {
		a=a.toUpperCase();
		b=b.toUpperCase();
		int d=0;
		while (true) {
			if (a.indexOf(b)<0) break; 
			if (a.indexOf(b)>0) d++;
			a=a.substring(a.indexOf(b)+1);
		}
		return d;
	}
}