import java.util.*;

public class Practica2 {
	
	public static void main(String args[]) {
		Scanner a=new Scanner(System.in);
		System.out.print(parentesisCorrectos(a.nextLine()));
		
		a.close();
	}
	
	private static boolean parentesisCorrectos(String a) {
		int b=0;
		for (int i=0;i<a.length();i++) {
			if (a.charAt(i)=='(') b++;
			if (a.charAt(i)==')') b--;
		}
		if (b==0) return true;
		return false;
	}
}
