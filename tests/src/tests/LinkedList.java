package tests;

public class LinkedList<E> {
	private Nodo nodo;
	public int n=0;
	LinkedList() {
		this.nodo=new Nodo(null);
	}
	public void add(E a,int b) {
		if (nodo.siguiente==null) {
			Nodo c=new Nodo(a);
			nodo.siguiente=c;
			c.anterior=nodo;
			nodo=nodo.siguiente;
			n++;
			return;
		}
		Nodo c=new Nodo(a);
		c.anterior=this.getNodo(b);
		c.siguiente=this.getNodo(b).siguiente;
		n++;
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
		int b=a-n+1;
		Nodo buffer=nodo;
		for (int i=b;i<0;i++) {
			
			buffer=buffer.anterior;
		}
		return buffer.objeto;
	}
	private Nodo getNodo(int a) {
		int b=a-n+1;
		Nodo buffer=nodo;
		for (int i=b;i<0;i++) {
			buffer=buffer.anterior;
		}
		return buffer;
	}
	public void eraseAll() {
		nodo=getNodo(0);
		nodo.siguiente=null;
		nodo.objeto=null;
		
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
