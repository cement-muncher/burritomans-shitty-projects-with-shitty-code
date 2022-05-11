package a;

public class Ejercicio12 {
	public static void main(String args[]) {
		System.out.print(triangulo());
	
	}
	static String triangulo() {
		String a="";
		int number=6;
		for (int i=0;i<number;i++) {
			for (int j=number;j>i;j--) {
				a=a.concat(" ");
				
			}
			a=a.concat("*");
			for (int j=0;j<i;j++) {
				if (i!=0) {
					a=a.concat("**");
				} 
			}
			a=a.concat("\n");
		}
		return a;
	}
}
