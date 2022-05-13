import java.util.*;

public class Ejercicio5 {
	static ArrayList<Integer> lista1=new ArrayList<Integer>();
	static ArrayList<Integer> lista2=new ArrayList<Integer>();
	private static ArrayList<Integer> union() {
		ArrayList<Integer> lista3=lista1;
		lista3.addAll(lista2);
		lista3.removeAll(lista2);
		ArrayList<Integer> returnList=lista3;
		returnList.addAll(lista2);
		return returnList;
		
		
	}
	private static ArrayList<Integer> interseccion() {
		ArrayList<Integer> returnList=lista1;
		returnList.retainAll(lista2);
		return returnList;
	}
	public static void main(String Args[]) {
		lista1.add(1);
		lista1.add(2);
		lista1.add(3);
		lista2.add(3);
		lista2.add(4);
		ArrayList<Integer> lista=union();
		for (Integer a: lista) System.out.print(a+"\n");
		lista1.clear();
		lista2.clear();
		lista1.add(1);
		lista1.add(4);
		lista1.add(3);
		lista2.add(3);
		lista2.add(4);
		lista=interseccion();
		System.out.print("\n");
		for (Integer a: lista) System.out.print(a+"\n");
	}
}
