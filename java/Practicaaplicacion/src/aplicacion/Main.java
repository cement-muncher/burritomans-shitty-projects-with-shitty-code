package aplicacion;
import java.util.*;

public class Main {
	public static Scanner scanner=new Scanner(System.in);
	private static String input;
	private static Session session=new Session();
	public static void main (String args[]) {
		while (true) {
			if (session.getterLogged()==true) {
				
				
			} else {
				Main.unlogged();
			}
		}
	}
	private static void unlogged() {
		System.out.print(Config.unLoggedMenu);
		input=scanner.next();
		System.out.print(input+"\n");
		switch (input) {
			case "1":
					session.login();
				break;
			case "2":System.out.print("a");
				break;
			case "3":System.out.print("b");
		}
	}
}
