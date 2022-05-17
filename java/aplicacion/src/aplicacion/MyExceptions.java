/*
 * Carlos Corbalan Andreu
 * 16/05/2022: Fichero creado
 * 
 * 
 */
package aplicacion;

import java.io.Serializable;

//Para errores de IOOperations.init()
class LoggerException extends Exception implements Serializable {
	private static final long serialVersionUID = 1L;
	LoggerException (String message) {
		super(message);
	}
	LoggerException (String message, Throwable cause) {
		super(message,cause);
	}
	LoggerException (Throwable cause) {
		super(cause);
	}
}

	//Para errores de DB.java	
class DBConnectionException extends Exception implements Serializable {
		private static final long serialVersionUID = 1L;
		DBConnectionException (String message) {
			super(message);
		}
		DBConnectionException (String message, Throwable cause) {
			super(message,cause);
		}
		DBConnectionException (Throwable cause) {
			super(cause);
		}
	
}
	//Para errores de la carga del laberinto
class LabyrinthLoadException extends Exception implements Serializable {
		private static final long serialVersionUID = 1L;
		LabyrinthLoadException (String message) {
			super(message);
		}
		LabyrinthLoadException (String message, Throwable cause) {
			super(message,cause);
		}
		LabyrinthLoadException (Throwable cause) {
			super(cause);
		}
		
	}
	//Para errores de la resolucion de laberintos
class LabyrinthResolutionException extends Exception implements Serializable {
		private static final long serialVersionUID = 1L;
		LabyrinthResolutionException (String message) {
			super(message);
		}
		LabyrinthResolutionException (String message, Throwable cause) {
			super(message,cause);
		}
		LabyrinthResolutionException (Throwable cause) {
			super(cause);
		}
		
}

