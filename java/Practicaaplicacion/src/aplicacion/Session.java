package aplicacion;
import java.util.*;
public class Session {
	User user;
	public boolean logged=false;
	public User login() {
		Scanner scanner=new Scanner(System.in);
		String userToBeLogged="";
		String passwordToBeLogged=""; 
		while (true) {
			userToBeLogged=scanner.nextLine();
			if (userToBeLogged.length()>=15) {
				continue;
			}
			break;
		}
		while (true) {
			passwordToBeLogged=scanner.nextLine();
			if (!(passwordToBeLogged.length()>=15)) {
				if (checkPassword(passwordToBeLogged)) {
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
	private static boolean checkPassword (String password) {
		return true;
	}
}
