package practica4;

import java.util.*;

public class Ejercicio4 {
	static public void main(String args[]) {
		if (vectoresIntIguales()) {
			System.out.print("Son iguales\n");
		} else { 
			System.out.print("No son iguales\n");
		}
		
	}
	static private boolean vectoresIntIguales() {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer> array1=new ArrayList<Integer>();
		ArrayList<Integer> array2=new ArrayList<Integer>();
		int a;
		System.out.print("Escriba enteros, para terminar excriba una string que no pueda ser representada como un entero\n");
		while (true) {
			try {
				a=scanner.nextInt();
				array1.add(a);
			} catch (Exception e) {
				break;
			}
		}
		scanner.nextLine();
		System.out.print("Escriba enteros, para terminar excriba una string que no pueda ser representada como un entero\n");
		while (true) {
			try {
				a=scanner.nextInt();
				array2.add(a);
			} catch (Exception e) {
				break;
			}
		}
		scanner.close();
		if (array1.size()==array2.size()) {
			for (int i=0;i<array1.size();i++) {
				if (array1.get(i)!=array2.get(i)) return false;
			}
			return true;
		}
		return false;
	}
}
