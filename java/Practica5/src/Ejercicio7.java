import java.util.Scanner;
import java.util.ArrayList;
public class Ejercicio7 {
	public static void main(String args[]) {
		Scanner a=new Scanner(System.in);
		String c=a.nextLine();
		String d=a.nextLine();
		System.out.print(reemplazarPalabras(c,d));
		a.close();
	}
	private static String reemplazarPalabras(String texto,String terminos) {
		String d="";
		String[] texto1=texto.split(" ");
		boolean  e=false;
		ArrayList<String> array=new ArrayList<String>();
		for (String c:terminos.split(",") ) {
			array.add(c);
		}
		for (String a: texto1) {
			for (String b: array) {
				if (a.matches(b)) {
					e=true;
				}
			}
			if (e) {
				for (int i=0;i<a.length();i++) {
					d+="*";
				}
			} else {
				for (char f: a.toCharArray())
				d+=f;
			}
			d+=" ";
			e=false;
		}
		return d;
	}
}
