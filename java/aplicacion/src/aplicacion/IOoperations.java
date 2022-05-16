/*
 * Carlos Corbalan Andreu
 * 14/05/2022: Fichero creado
 * 
 * 
 */
package aplicacion;
import java.io.*;
public class IOoperations {
	private static final String prefix="files/";
	public static String readFile(String file,int offset,int bottomLine) {
		String returnValue="";
		char[] buffer=new char[bottomLine-offset];
		try {
		FileReader fileToBeRead=new FileReader(prefix+file);
		if (fileToBeRead.read(buffer,offset,bottomLine)==-1) {
			fileToBeRead.close();
			return null;	
		}
		fileToBeRead.close();
		} catch (FileNotFoundException E) {
				Log.debugLog("File "+file+" is not in file/", E);
		} catch (IOException E) {
			Log.debugLog("IO Error", E);
		};
		for (char a: buffer) {
			returnValue+=a;
		}
		return returnValue;
		
	}
}
