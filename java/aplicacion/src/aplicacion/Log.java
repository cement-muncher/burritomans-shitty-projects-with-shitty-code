
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
	public static void initLog() throws LoggerException {
		Date logMoment=new Date();
		try {
			aplicationLog=new FileWriter("log/aplication.log",true );
		} catch (IOException E) {
			throw new LoggerException("Error abriendo log/aplication.log",E);
		} 
		try {
			debugLog=new FileWriter("log/debug.log",true );
		} catch (IOException E) {
			throw new LoggerException("Error abriendo log/debug.log",E);
		} 
		try {
		debugLog.append(logMoment.toString()+" Aplication booted up\n");
		aplicationLog.append(logMoment.toString()+" Aplication booted up\n");
		} catch (IOException E) {
			throw new LoggerException("Error escribiendo",E);
		}
	}
	
	public static void debugLog(String debugMessage, Exception troubleMaker) {
		Date logMoment=new Date();
		try { 
			debugLog.append(logMoment.toString()+": " + debugMessage + "\t --> "
		+ troubleMaker.getMessage()+"\n");
		} catch (IOException E) {
			System.err.print(E.getMessage());
		}
	}
	public static void aplicationLog(String debugMessage) {
		Date logMoment=new Date();
		try { 
			aplicationLog.append(logMoment.toString()+": " + debugMessage+"\n" 	);
			debugLog.append(logMoment.toString()+": " + debugMessage+"\n");
		} catch (IOException E) {
			System.err.print(E.getMessage());
		}
	}
	
	public static void closeLog() {
		Date logMoment=new Date();
		try {
			debugLog.append(logMoment.toString()+" Aplication shut down"+
			"\n---------------------------------------\n");
			debugLog.close();
		} catch (IOException E) {
			System.err.print(E.getMessage());
		}
		try {
			aplicationLog.append(logMoment.toString()+" Aplication shut down"+
					"\n---------------------------------------\n");
					aplicationLog.close();
		} catch (IOException E) {
			System.err.print(E.getMessage());
		} 
		
	}
	
}
