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
		Date date=new Date();
		Log.initLog();
		Scanner a=new Scanner(System.in);
		try {
			a.nextInt();
		} catch (Throwable E) {
			Log.debugLog("Uh Oh",E);
		}
		Log.closeLog();
	}
}
