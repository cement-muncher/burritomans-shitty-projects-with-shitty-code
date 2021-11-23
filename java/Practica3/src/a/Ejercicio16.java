package a;
import java.util.*;
public class Ejercicio16 {
	public static void main (String args[]) {
		Scanner scanner=new Scanner(System.in);
		String cadena="";
		while (true) {
			cadena=cadena.concat(scanner.nextLine()+'\n');
			if (cadena.endsWith("QUIT\n")) {
				cadena=cadena.substring(0,cadena.length()-5);
				break;
			}
		}
		ArrayList<String> result=new ArrayList<String>();
		result=palabrasCuatroVocales(cadena);
		//result=palabrasCuatroLetras(cadena);
		for (int i=0;i<result.size();i++) {
			System.out.print(result.get(i)+'\n');
		}
		scanner.close();
	}
	static ArrayList<String> palabrasCuatroLetras(String cadena) {
		String buffer="";
		ArrayList<String> result=new ArrayList<String>();
		for (char i:cadena.toCharArray()) {
			if (buffer.matches("[A-Za-z0-9]{4,}")&&(i=='\n'||i=='\t'||i==' ')) {
				result.add(buffer);
				buffer="";
				
			}
			if (i=='\n'||i=='\t'||i==' ')  {
				buffer="";
				continue;
			}
			buffer=buffer+i;
		}
		return result;
	}
	/*
	 * Añadido solo por diversión
	 */
	static ArrayList<String> palabrasCuatroVocales(String cadena) {
		String buffer="";
		String upperCaseBuffer="";
		ArrayList<String> result=new ArrayList<String>();
		int vocales=0, numVocales=0;
		for (char i:cadena.toCharArray()) {
			if ((i=='\n'||i=='\t'||i==' ')&&numVocales>=4) {
				result.add(buffer);
				buffer="";
				vocales=0;
			}
			upperCaseBuffer=""+i;
			upperCaseBuffer=upperCaseBuffer.toUpperCase();
			switch (upperCaseBuffer) {
				case "A": if ((vocales&1)!=1) {
						vocales=vocales|1;
						numVocales+=1;
						}
						break;
				case "E": if ((vocales&2)!=2) {
					vocales=vocales|2;
					numVocales+=1;
					}
					break;
				case "I":if ((vocales&4)!=4) {
					vocales=vocales|4;
					numVocales+=1;
					} 
					break;
				case "O": if ((vocales&8)!=8) {
					vocales=vocales|8;
					numVocales+=1;
					}
					break;
				case "U":if ((vocales&16)!=16) {
					vocales=vocales|16;
					numVocales+=1;
					} 
					break;
			}
			if (i=='\n'||i=='\t'||i==' ') {
				buffer="";
				vocales=0;numVocales=0;
				numVocales=0;
				continue;
			}
			buffer=buffer+i;
		}
		return result;
	}
}
