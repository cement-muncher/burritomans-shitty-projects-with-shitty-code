package aplicacion;

/*
 * Carlos Corbalan Andreu
 * 14/05/2022: Fichero creado
 * 
 * 
 */

public class Main {
	
	public static void main(String args[]) {
		try {
			Log.initLog();
		
		} catch (LoggerException E) {
			System.err.print(E.getMessage());
		}
		Login b=new Login();
		Log.closeLog();

			
			
	}
	
}
