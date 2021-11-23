package a;
import java.util.*;
public class Ejercicio19 {
	static Scanner scanner=new Scanner(System.in);
	static public void main (String args[]) {
		int a=contarCaracteresPalabras();
		System.out.print("Elige que quieres ver: 1 para caracteres, 2 para palabras, 3 para lineas.\n"
				+ "(Puedes juntar multiples para ver varios a la vez)\n");
		int b,c=0;
		while (true) {
			b=scanner.nextInt();
			if (Integer.toString(b).matches("[123]{1,3}")) {
				break;
			}
		}
		for (char i:Integer.toString(b).toCharArray()) {
			switch (i) {
				case '1':c=c|1;
					break;
				case '2':c= c|2;
					break;
				case '3':c=c|4;
					break;
			}
		}
		interpretarCodigo(a,c);
		scanner.close();
	}
	static int contarCaracteresPalabras() {
		String cadena="";
		while (true) { 
			cadena=cadena.concat(scanner.nextLine()+'\n');
			if (cadena.endsWith("QUIT\n")) {
				cadena=cadena.substring(0,cadena.length()-5);
				break;
			}
		}
		/*Se guarda de la siguiente manera:
		 * Los bits 0-6  se utilizan para contar el numero de lineas
		 * Los bits 7-15 se utilizan para contar el numero de palabras
		 * Los bits 16-31 se utilizan para contar el numero de caracteres
		 */
		int lineas=0;
		int palabras=0;
		int  caracteres=0;
		String palabra="";
		for (char i:cadena.toCharArray()) {
			if (palabra.matches("[A-Za-z0-9]{1,}")&&(i=='\n'||i=='\t'||i==' ')) {
				palabras++;
				palabra="";
				caracteres++;
				if (i=='\n') lineas++;
				continue;
			}
			palabra+=i;
			if (i=='\n') lineas++;
			caracteres++;
		}
		int result=(lineas<<25)+(palabras<<16)+caracteres;
		return result;
		
	}
	static void interpretarCodigo(int codigo,int flags) {
		if ((flags&1)==1) {
			System.out.print("El numero de caracteres son:"+Integer.toUnsignedString((codigo&0xFFFF))+"\n");
		} 
		if ((flags&2)==2) {
			System.out.print("El numero de palabras son:"+Integer.toUnsignedString((codigo&0x1FF0000)>>16)+"\n");
		}
		if ((flags&4)==4) {
			System.out.print("El numero de lineas son:"+Integer.toUnsignedString((codigo&0xFE000000)>>25)+"\n");
		}
	}
}
