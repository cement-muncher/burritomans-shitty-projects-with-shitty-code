package practica4;
import java.util.*;
public class Ejercicio3 {
	static public void main(String args[]) {
		frecuenciaNumero();
	}
	static private void frecuenciaNumero() {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> array=new ArrayList<Integer>();
		int a,c;
		a=0;
		System.out.print("Escriba enteros, para terminar excriba una string que no pueda ser representada como un entero\n");
		while (true) {
			try {
				a=scanner.nextInt();
				array.add(a);
			} catch (Exception e) {
				break;
			}
		}
		scanner.nextLine();
		System.out.print("Escriba el numero a buscar: ");
		while (true) {
			try {
				a=scanner.nextInt();
				break;
			} catch (Exception e) {
				continue;
			}
		}
		c=0;
		for (int i=0;i<array.size();i++) {
			if (array.get(i)==a) c++;
		}
		System.out.print("El numero "+a+" ha aparecido "+c+" veces\n");
		scanner.close();
	}
	
}
