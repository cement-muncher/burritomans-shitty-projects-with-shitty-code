package a;
import java.util.*;
public class Ejercicio20 {
		public static void main(String args[]) {
			String input="",number1="",number2="";
			char operation='\0';
			int int1,int2;
			boolean breakable=false;
			Scanner scanner=new Scanner(System.in);
			while (true ){
				while (true) {
					input=scanner.nextLine();
					if (input.matches("[0-9]{1,}(\\+|\\*|\\-)[0-9]{1,}")) break;
					if (input.matches("QUIT")) {
						breakable=true;
						break;
					}	
				}
				if (breakable) break;
				for (char i:input.toCharArray()) {
					if (i=='+'||i=='-'||i=='*') {
						operation=i;
					} else if (operation=='+'||operation=='-'||operation=='*') {
						number2=number2+i;
					} else {
						number1=number1+i;
					}
				}
				int1=Integer.parseInt(number1);
				int2=Integer.parseInt(number2);
				switch (operation) {
					case '+': System.out.printf("%d\n",int1+int2);
							break;
					case '-':System.out.printf("%d\n",int1-int2);
							break;
					case '*': System.out.printf("%d\n",int1*int2);
							break;
					
				}
				input="";
				number1="";
				number2="";
				operation='\0';
			}
			scanner.close();
		}
}