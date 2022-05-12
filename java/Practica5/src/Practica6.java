import java.util.*;
public class Practica6 {
	public static void main(String args[]) {
		Scanner a=new Scanner(System.in);
		String b=padRight(a.nextLine(),"*",20);
		System.out.print(b);
		a.close();
	}
	
	public static String padRight(String string2,String pad, int n) {
		String string="";
		for (int k=string2.length();k<n;k++) {
			string=string.concat(pad);
		}
		string=string2.concat(string.toString());
		return string;
	}
}
