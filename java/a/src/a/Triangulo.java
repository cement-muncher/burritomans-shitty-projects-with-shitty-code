package a;

public class Triangulo {
	public static void main(String args[]) {
		String a="*";
		int number=6;
		for (int i=0;i<number;i++) {
			for (int j=number;j>i;j--) {
				System.out.print(" ");
			}
		System.out.print(a+"\n");
		a=a.concat("**");
		}
	}
}
