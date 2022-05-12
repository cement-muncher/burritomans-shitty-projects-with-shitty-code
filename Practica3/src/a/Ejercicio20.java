package a;
import java.util.*;
public class Ejercicio20 {
	static public void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Escribe los caracteres (A-D) a imprimir en la siguiente linea\n->");
		String linea=scanner.nextLine();
		for (char i:linea.toCharArray()) {
			 bannerLetra(i);
		}
		scanner.close();
	}
	static void bannerLetra(char a) {
		switch (a) {
			case 'a'|'A':  System.out.print(
					  "  ##   \n"
					+ " #  #  \n"
					+ "#    # \n"
					+ "###### \n"
					+ "#    # \n"
					+ "#    # \n\n");
							break;
			case 'b'|'B': System.out.print(""
					+ "#####  \n"
					+ "#    # \n"
					+ "#####  \n"
					+ "#    # \n"
					+ "#    # \n"
					+ "#####  \n\n"
					);
							break;
			case 'c'|'C': System.out.print(
					  " ####  \n"
					+ "#    # \n"
					+ "#      \n"
					+ "#      \n"
					+ "#    # \n"
					+ " ####  \n\n");
							break;
			case 'd'|'D': System.out.print(
					  "#####  \n"
					+ "#    # \n"
					+ "#    # \n"
					+ "#    # \n"
					+ "#    # \n"
					+ "#####  \n\n"
					);
							break;
			}
	}
}
