//Importa java.util e indica el paquete
package aplication;
import java.util.*;

public class Main {
	//Crea el scanner que será utilizado por todo el programa 
	public static Scanner scanner=new Scanner(System.in);
	//Input bufer
	private static String input;
	//Crea una instancia de sesión
	private static Session session=new Session();
	//Máquina de estado, logeado o no logeado 
	public static void main (String args[]) {
		while (true) {
			if (session.getterLogged()==true) {
				Main.logged();
			} else {
				Main.unlogged();
			}
		}
	}
	//La función que se encarga del menu cuando no se está logeado
	private static void unlogged() {
		System.out.print(Config.unLoggedMenu);
		input=scanner.next();
		switch (input) {
			case "1":
				//Llama al metodo login para pasar al estado logged
					session.login();
				break;
			case "2":System.out.print("a");
				break;
			case "3":System.exit(0);
				break;
		}
	}
	//Lo mismo pero cuando se está logeado
	private static void logged() {
		System.out.print(Config.loggedMenu);
		input=scanner.next();
		switch (input) {
			case "1":
					session.login();
				break;
			case "2":System.out.print("Proximamente\n");
				break;
			case "3":System.out.print("Proximamente\n");	
				break;
			case "4":System.out.print("Proximamente\n");
				break;
			case "5":session.user.printInfo();
				break;
			case "6":{
				//Llama al metodo que pone logged a false, deslogeando al user
				session.setterLogged(false);
				System.out.print(Config.goodbye);
			}
				break;
			case "7":{
				System.out.print(Config.goodbye);
				System.exit(0);
			}
		}
	}
}
