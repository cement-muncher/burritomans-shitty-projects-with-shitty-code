import java.util.Scanner;

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
		String[] array=new String[20];
		int counter=0;
		do {
			array[counter++]=terminos.substring(0,terminos.indexOf(","));
			terminos=terminos.substring(terminos.indexOf(",")+1);
		} while (terminos.indexOf(",")>=0);
		counter=0;
		for (String a: texto1) {
			for (String b: array) {
				if (a==b) {
					for (int i=0;i<a.length();i++) {
						d+="*";
					}
				}
				
			}
		}
		return d;
	}
}
