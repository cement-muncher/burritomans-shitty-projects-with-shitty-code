
import java.util.Scanner;
public class Practica5 {
	public static void main(String args[]) {
		Scanner a=new Scanner(System.in);
		String c=a.nextLine();
		String e=pasarMayusculasSubCadena(c);
		System.out.print(e);
		a.close();
	}
	private static String pasarMayusculasSubCadena(String a)  {
		int b;
		int c;
		int e=0;
		String d="";
		do {
			b=a.indexOf("<mayus>");
			c=a.indexOf("</mayus>");
			d+=a.substring(0,b);
			d+=a.substring(b+7,c).toUpperCase();
			e=c+8;
			a=a.substring(e);
		} while (a.indexOf("</mayus>")>0 &&a.indexOf("<mayus>")>0);
		return d;
	}
}