import java.util.*;

public class Ejercicio5_TBD {
	static ArrayList<Integer> lista1=new ArrayList<Integer>();
	static ArrayList<Integer> lista2=new ArrayList<Integer>();
	private static ArrayList<Integer> union() {
		ArrayList<Integer> returnList=lista1;
		returnList.addAll(lista2);
		returnList.removeAll()
		return returnList;
		
		
	}
	private static ArrayList<Integer> interseccion() {
		
	}
	public static void main(String Args[]) {
		lista1.add(1);
		lista1.add(2);
		lista1.add(3);
		lista2.add(3);
		lista2.add(4);
		ArrayList<Integer> lista=union();
		for (Integer a: lista) System.out.print(a+"\n");
		lista=interseccion();
		System.out.print("\n");
		for (Integer a: lista) System.out.print(a+"\n");
	}
}
