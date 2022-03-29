//Importa los paquetes necesarios
package aplication;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
	//Esto existe en caso de que un usuario no cuente con la información adicional
	private boolean additionalInfo;
	//La declaración de la información adicional
	String name;
	String fullName;
	String age;
	String nif;
	String email;
	String address;
	String birthDate;
	//Imprime la informacion adicional del usuario en concreto (O no en caso que additionalInfo este a false
	public void printInfo() {
		if (additionalInfo==false) return;
		System.out.print("Name:"+name+"\n");
		System.out.print("Full Name:"+fullName+"\n");
		System.out.print("Age:"+age+"\n");
		System.out.print("NIF:"+nif+"\n");
		System.out.print("Email:"+email+"\n");
		System.out.print("Address:"+address+"\n");
		System.out.print("Birth Date:"+birthDate+"\n");
	}
	
	//Constructor, toma como input el nombre del usuario del cual obtener la info adicional
	User(String input){
		//Fichero a parsear
		File loginData = new File("src/aplication/"+Config.usersFile);
		//Compilamos el regex del delimitador de campos
		Pattern p=Pattern.compile("\\t");
		try {
			Scanner loginScanner=new Scanner(loginData);
			/*Un bucle que compara el primer valor de cada uno  de las entradas con el nombre de usuario
			 * que ha recibido como input
			 */
			if (!loginScanner.hasNextLine()) {
				System.out.print("El usuario no cuenta con los campos de información adicional"
						+ "\nLa opción 5 no está disponible\n");
				additionalInfo=false;
			}
			while (loginScanner.hasNextLine()) {
				String line=loginScanner.nextLine();
				String []values=p.split(line);
				if (!values[0].matches(input)) {
					continue;
				}
				/*Comprueba que el usuario buscado tenga campos de info adicional, si no hay deniega el
				 * uso de la funcionalidad 5 desde el menu logeado 
				*/
				if (!line.matches("^(.{1,}\\t){5}.{1,}$")) {
					System.out.print("El usuario no cuenta con los campos de información adicional"
							+ "\nLa opción 5 no está disponible\n");
					additionalInfo=false;
					break;
				}
				//Guarda los valores del fichero a variables 
				if (input.matches(values[0])) {
					name=values[0];
					fullName=values[1];
					age=values[2];
					nif=values[3];
					email=values[4];
					address=values[5];
					birthDate=values[6];
					additionalInfo=true;
				}
			}
			loginScanner.close();
		} catch (Exception e) {
			System.err.print(e);
			System.exit(1);
		}
	}
	
}
