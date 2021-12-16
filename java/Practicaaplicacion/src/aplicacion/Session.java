package aplicacion;
import java.util.*;
public class Session {
	User user;
	public static boolean logged=false;
	public User login() {
		Scanner scanner=new Scanner(System.in);
		String userToBeLogged="";
		String passwordToBeLogged=""; 
		while (true) {
			userToBeLogged=scanner.nextLine();
			if (!(userToBeLogged.matches("^[A-Za-z0-9]{0,15}$"))) {
				System.out.print("Nombre de usuario "+userToBeLogged+" no es valido\n");
				continue;
			}
			break;
		}
		while (true) {
			passwordToBeLogged=scanner.nextLine();
			if (passwordToBeLogged.matches("^[A-Za-z0-9\\+\\-\\*\\?!\\^/\\$%]{8,15}$")) {				if (checkPassword(passwordToBeLogged,userToBeLogged)) {
					break;
				} else {
					scanner.close();
					logged=false;
					return user=new User(null);
				}
			}
		}
		logged=true;
		scanner.close();
		return user=new User(userToBeLogged);
	}
	private static boolean checkPassword (String password,String user) {
		return true;
	}
}
