//Importa los paquetes necesarios
package aplication;
import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
public class Session {
	//Crea un usuario
	User user;
	Scanner scanner=Main.scanner;
	//Pone logged a false 
	private static boolean logged=false;
	//Metodo para logear el usuario
	public void login() {
		scanner.nextLine();
		String userToBeLogged="";
		String passwordToBeLogged="";
		//Comprueba que se ha introducido un nombre de usuario valido
		while (true) {
			userToBeLogged=scanner.nextLine();
			if (!(userToBeLogged.matches("^[A-Za-z0-9]{1,15}$"))) {
				System.out.print("Nombre de usuario "+userToBeLogged+" no es valido\n");
				continue;
			}
			break;
		}
		//Comprueba que la contraseña es valida
		while (true) {
			passwordToBeLogged=scanner.nextLine();
			if (passwordToBeLogged.matches("^[A-Za-z0-9\\+\\-\\*\\?!\\^/\\$%]{8,15}$")) {				
				break;
			}
		}
		//Comprueba que la contraseña y el usuario correspondanq
		if (checkPassword(passwordToBeLogged,userToBeLogged)) {
			logged=true;
			//Asignamos el usuario logeado con exito como el objeto de usuario activo 
			user=new User(userToBeLogged);
		} else {
			System.out.print("El nombre de usuario y/o password son incorrectos\n");
			return;
		}
		return;
	}
	//El metodo que comprueba que la password y user sean correctos
	private static boolean checkPassword (String password,String user) {
		File loginData = new File("src/aplication/"+Config.filePath);
		//Compilamos el separador de campos
		Pattern p=Pattern.compile("\\t");
		try {
			//Comprobamos uno por uno que las contraseñas y usuarios concuerden
			Scanner loginScanner=new Scanner(loginData);
			while (loginScanner.hasNextLine()) {
				String input=loginScanner.nextLine();
				String []values=p.split(input);
				if (user.endsWith(values[0])&&password.endsWith(values[1])) {
					loginScanner.close();
					return true;
				}
			}
			loginScanner.close();
		} catch (Exception e) {
			System.err.print(e);
			System.exit(1);
		}
		return false;
	}
	//Setter y getter de la variable privada logged
	public void setterLogged(boolean result) {
		logged=result;
	}
	public boolean getterLogged() {
		return logged;
	}
}