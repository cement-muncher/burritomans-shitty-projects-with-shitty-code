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
			case "2":session.createUser();
				break;
			case "3":System.exit(0);
				break;
		}
	}
	//Lo mismo pero cuando se está logeado
	private static void logged() {
		Labyrinth labyrinth=new Labyrinth();
		System.out.print(Config.loggedMenu);
		input=scanner.next();
		switch (input) {
			case "1":
					scanner.nextLine();
					labyrinth.loadLabyrinth(scanner.nextLine());
					break;
			case "2":
					labyrinth.printLabyrinth();
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
				System.out.print(Config.goodbye+"\n");
			}
				break;
			case "7":{
				System.out.print(Config.goodbye+"\n");
				System.exit(0);
			}
		}
	}
}
