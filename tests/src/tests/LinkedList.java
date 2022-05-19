package tests;

public class LinkedList<E> {
	private Nodo nodo;
	private static int counter=0;
	LinkedList() {
		this.nodo=new Nodo(null);
	}
	public void add(E a,int b) {
		if (nodo.objeto==null) {
			nodo.objeto=a;
			nodo.siguiente=null;
			counter++;
			return;
		}
		Nodo c=new Nodo(a);
		c.anterior=this.getNodo(b);
		c.siguiente=this.getNodo(b).siguiente;
		
		
		counter++;
	}
	public int getLength() {
		return counter;
	}
	public void remove(int a) {
		if (nodo.anterior==null) {
			return;
		}
		Nodo b=this.getNodo(a);
		b.anterior.siguiente=b.siguiente;
		b.siguiente.anterior=b.anterior;
		return;
	}
	public E getObjeto(int a) {
		int b=a-counter+1;
		System.out.print(b);
		Nodo buffer=this.nodo.anterior;
		for (int i=b;i<0;i++) {
			System.out.print(i);
			buffer=buffer.anterior;
		}
		return buffer.objeto;
	}
	private Nodo getNodo(int a) {
		int b=a-counter+1;
		Nodo buffer=this.nodo;
		for (int i=b;i<0;i++) {
			buffer=buffer.anterior;
		}
		return buffer;
	}
	private class Nodo {
		E objeto;
		Nodo siguiente;
		Nodo anterior;
		Nodo(E a) {
			this.objeto=a;
			this.siguiente =null;
			this.anterior=null;
		}
	}
}
