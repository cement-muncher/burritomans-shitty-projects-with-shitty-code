package tests;

public class LinkedList<E> {
	private Nodo nodo;
	public int n=0;
	LinkedList() {
		this.nodo=new Nodo(null);
	}
	public void add(E a,int b) {
		if (b==n) {
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
		if (n==a) {
			nodo.anterior.siguiente=null;
			nodo.anterior=nodo;
			return;
		} else if (a==0) {
			if (n==1) {
				this.eraseAll();
			} else {
				this.getNodo(a).siguiente.anterior=null;
				n--;
			}
			return;
		}
		Nodo b=this.getNodo(a);
		b.siguiente.anterior=b.anterior;
		b.anterior.siguiente=b.siguiente;
		n--;
	}
	public E getObjeto(int a) {
		return getNodo(a).objeto;
	}
	private Nodo getNodo(int a) {
		Nodo buffer=nodo;
		int b=n-a-1
				;
		for (int i=0;i<b;i++ ) {
			buffer=buffer.anterior;
		}
		return buffer;
	}
	public void eraseAll() {
		nodo=getNodo(0);
		nodo.siguiente=null;
		nodo.objeto=null;
		n=1;
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
