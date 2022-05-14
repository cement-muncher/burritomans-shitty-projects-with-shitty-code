
/*
 * Carlos Corbalan Andreu
 * 14/05/2022: Fichero creado
 * 
 * 
 */
package aplicacion;
import java.io.*;
import java.util.Date;
public class Log {
	//Crea dos loggers, uno para info de la aplicacion otro para debugging
	private static FileWriter aplicationLog;
	private static FileWriter debugLog;
	//Inicializa los dos objetos
	public static void initLog() {
		Date logMoment=new Date();
		try {
			aplicationLog=new FileWriter("log/aplication.log",true );
			debugLog=new FileWriter("log/debug.log",true );
			debugLog.append(logMoment.toString()+" Aplication booted up\n");
			aplicationLog.append(logMoment.toString()+" Aplication booted up\n");
		} catch (IOException E) {
			System.err.print(E);
		} 
		
	}
	
	public static void debugLog(String debugMessage, Object troubleMaker) {
		Date logMoment=new Date();
		try { 
			debugLog.append(logMoment.toString()+": " + debugMessage + "\t --> "
		+troubleMaker.getClass().getName()+"\n" 	);
		} catch (IOException E) {
			System.err.print(E);
		}
	}
	
	public static void closeLog() {
		Date logMoment=new Date();
		try {
			debugLog.append(logMoment.toString()+"Aplication shut down"+
			"\n---------------------------------------\n");
			aplicationLog.append(logMoment.toString()+"Aplication shut down"+
			"\n---------------------------------------");
			aplicationLog.close();
			debugLog.close();
		} catch (IOException E) {
			System.err.print(E);
		} 
	}
	
}
