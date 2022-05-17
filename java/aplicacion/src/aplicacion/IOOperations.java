/*
 * Carlos Corbalan Andreu
 * 14/05/2022: Fichero creado
 * 
 * 
 */
package aplicacion;
import java.io.*;
public class IOOperations {
	private static final String prefix="files/";
	public static String readCharFile(String file,int offset,int bottomLine) {
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
			return null;
		} catch (IOException E) {
			Log.debugLog("IO Error", E);
			return null;
		};
		for (char a: buffer) {
			returnValue+=a;
		}
		return returnValue;
	}
	
		public static void writeCharFile(String toBeWritten,String file) {
			try {
				FileWriter fileToBeWrittenTo=new FileWriter(prefix+file);
				fileToBeWrittenTo.append(toBeWritten);
				fileToBeWrittenTo.close();
				} catch (IOException E) {
					Log.debugLog("IO Error", E);
					return;
				};
			return;
		}
		public static void appendCharFile(String toBeWritten,String file) {
			try {
				FileWriter fileToBeWrittenTo=new FileWriter(prefix+file,true);
				fileToBeWrittenTo.append(toBeWritten);
				fileToBeWrittenTo.close();
				} catch (IOException E) {
					Log.debugLog("IO Error", E);
					return;
				};
			return;
		}
		
		class ObjectOperations<T>{
			private static final String prefix="files/";
			public T readObjectFile(String file,T objectToBeRead) {
				T returnable;
				try {
					FileInputStream readFile=new FileInputStream(prefix+file);
					ObjectInputStream input=new ObjectInputStream(readFile);
					if (input.readObject().getClass()!=objectToBeRead.getClass()) {
						input.close();
						return null;
					}
					returnable= (T) input.readObject();
					input.close();
				} catch (FileNotFoundException E) {
					Log.debugLog("File "+file+" is not in file/", E);
					return null;
				} catch (IOException E) {
					Log.debugLog("IOException", E);
					return null;
				} catch (ClassNotFoundException E) {
					Log.debugLog("ClassNotFound", E);
					return null;
				}
				return returnable;
			}
			public void writeObjectFile(String file,T objectToBeWritten) {
				try {
					FileOutputStream writtenFile=new FileOutputStream(prefix+file);
					ObjectOutputStream output=new ObjectOutputStream(writtenFile);
					output.writeObject(objectToBeWritten);
					output.close();
				} catch (FileNotFoundException E) {
					Log.debugLog("File "+file+" is not in file/", E);
					return;
				} catch (IOException E) {
					Log.debugLog("IOException", E);
					return;
				}
				return;
			}
		}
}

