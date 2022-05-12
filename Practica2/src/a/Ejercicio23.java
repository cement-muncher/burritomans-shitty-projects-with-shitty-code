package a;
import java.util.*;
public class Ejercicio23 {
		public static void main(String args[]) {
			Scanner scanner=new Scanner(System.in);
			int num=scanner.nextInt();
			String a="";
			int value=0,value1=1;
			for (int i=0;i<num;i++) {
				value+=value1;
				value1=value-value1;
				a=a.concat(Integer.toString(value1)+" ");
			}
			scanner.close();
			System.out.print(a);
		}
}