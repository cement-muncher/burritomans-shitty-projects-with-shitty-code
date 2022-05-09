package practica4;

import java.util.Scanner;

public class Ejercicio11 {
	public static void main(String args[]) {
		Scanner a=new Scanner(System.in);
		char b=a.nextLine().toUpperCase().charAt(0);
		System.out.print(c((int) b));
		a.close();
	}
	
	private static String c(int b) {
		b-=64;
		switch (b) {
			case 1: return A();
			case 2: return B();
			case 3: return C();
			case 4: return D();
		}
		return "algo ha fallao";
	}
	private static String A() {
		return "A    \r\n"
				+ "  A A   \r\n"
				+ " A   A  \r\n"
				+ "A     A\r\n"
				+ "AAAAAAA \r\n"
				+ "A     A \r\n"
				+ "A     A";
	}
	private static String B() {
		return "BBBBBB \n"+ 
				"B     B \n"+
				"B     B \n"+
				"BBBBBB  \n"+
				"B     B \n"+
				"B     B \n"+
				"BBBBBB "; 
	}
	private static String C() {
		return " CCCCC  \r\n"
				+ "C     C \r\n"
				+ "C       \r\n"
				+ "C       \r\n"
				+ "C       \r\n"
				+ "C     C \r\n"
				+ " CCCCC";
	}
	private static String D() {
		return "DDDDDD  \r\n"
				+ "D     D \r\n"
				+ "D     D \r\n"
				+ "D     D \r\n"
				+ "D     D \r\n"
				+ "D     D \r\n"
				+ "DDDDDD  ";
	}
}
