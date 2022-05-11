package practica4;

import java.util.*;
public class Ejercicio15 {
	private static int soyUnVago;
	public static void main(String args[]) {
		Scanner a=new Scanner(System.in);
		int b=a.nextInt();
		int[] c= {2,4,6,7,8,9,11,12,42};
		int length=c.length;
		search(c,b,length-1,length);
		System.out.print(soyUnVago);
		a.close();
	}
	private static void search(int array[], int n, int variable1,int length) {
		if (n==array[variable1]) {
			soyUnVago=variable1;
			return;
		} else if  (length==1) {
			return;
		}
		if (n>array[variable1/2]) {
			search(array,n,variable1+length/2,length/2);
		} else {
			search(array,n,length/2,length/2);
		}
		return;
	}
}
