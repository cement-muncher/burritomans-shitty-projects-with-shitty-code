package practica4;

/*Cada m�todo recibe respectivamente un valor que representa 
 * el lado de una matriz cuadrada de tama�o N; deben rellenar 
 * el corespondiente array seg�n los patrones del gr�fico adjunto. 
 * Devuelven respectivamente la matriz generada.
 */
import java.util.Scanner;

public class Ejercicio12 {
	public static void main(String args[]) {
		Scanner a=new Scanner(System.in);
		int b=a.nextInt();
		String c=secuenciaNaturalA(b);
		System.out.print(c+"\n");
		c=secuenciaNaturalB(b);
		System.out.print(c+"\n");
		c=secuenciaNaturalC(b);
		System.out.print(c+"\n");
		c=secuenciaNaturalD(b);
		System.out.print(c+"\n");
		a.close();
	}
	public static String secuenciaNaturalA(int a) {
		String string="";
		Integer b;
		for (int i=0;i<a;i++) {
			for (int j=0;j<a;j++) {
				b=i+(a*j)+1;
				string=string.concat(paddingString(b.toString()));
			}
			string=string.concat("\n");
		}
		return string;
	}
	
	public static String secuenciaNaturalB(int a) {
		String string="";
		Integer b;
		for (int i=0;i<a;i++) {
			for (int j=0;j<a;j++) {
				b=(j%2==1)?((1+j)*a)-i:j*a+i+1;
				string=string.concat(paddingString(b.toString()));
			}
			string=string.concat("\n");
		}
		return string;
	}
	
	public static String secuenciaNaturalC(int a) {
		int[][] array=new int[a][a];
		String string="";
		Integer b=0;
		int counter=0;
		for (int i=0;i<a;i++) {
			for (int j=0;j<i+1;j++) {
				array[a-1-i+j][j]=++counter;
			}
		}
		int counter2=0;
		for (int i=0;i<a-1;i++) {
			for (int j=i+1;j<a;j++) {
				array[counter2++][j]=++counter;
			}
			counter2=0;
		}
		for (int i=0;i<a;i++) {
			for (int j=0;j<a;j++) {
				b=array[i][j];
				string=string.concat(paddingString(b.toString()));
			}
			string=string.concat("\n");
		}
			return string;
	}
	public static String secuenciaNaturalD(int a) {
		int[][] array=new int[a][a];
		String string="";
		Integer b;
		int c=0;
		for (int i=0;i<a;i++) {
			for (int j=i;j<a-i;j++) {
				array[j][i]=++c;
			}
			for (int j=i+1;j<a-i;j++) {
				array[a-i-1][j]=++c;
			}
			for (int j=a-i-2;j>i;j--) {
				array[j][a-i-1]=++c;
			}
			for (int j=a-i-1;j>i;j--) {
				array[i][j]=++c;
			}
			if (c==a*a) break;
	}
		for (int i=0;i<a;i++) {
			
			for (int j=0;j<a;j++) {
				b=array[i][j];
				string=string.concat(paddingString(b.toString()));
			}
			string=string.concat("\n");
		}
		return string;
	}

	public static String paddingString(String string2) {
		String string="";
		for (int k=0;k<10-string2.toString().length();k++) {
			string=string.concat(" ");
		}
		string=string.concat(string2.toString());
		return string;
	}
}
