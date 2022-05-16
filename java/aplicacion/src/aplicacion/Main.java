package aplicacion;
/*
 * Carlos Corbalan Andreu
 * 14/05/2022: Fichero creado
 * 
 * 
 */
import java.util.*;
public class Main {
	
	public static void main(String args[]) {
		try {
			Log.initLog();
		
		} catch (LoggerException E) {
			
		}
		IOoperations.readFile("a", 0, 0);
		try {
			Log.closeLog();
		} catch (LoggerException E) {
			
			
		}
	}
}
