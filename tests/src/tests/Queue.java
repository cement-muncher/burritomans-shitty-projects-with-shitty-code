package tests;

public class Queue <E>{
	private LinkedList<E> queue;
	Queue(E objeto) {
		this.queue=new LinkedList<E>();
		queue.add(objeto, 0);
	}
	Queue() {
		this.queue=new LinkedList<E>();
	}
	public void add(E objeto) {
		queue.add(objeto,queue.n);
	}
	public E check( ) {
		return queue.getObjeto(0);
	}
	public E serve() {
		E a=queue.getObjeto(0);
		queue.remove(0);
		return a;
	}
	public void eraseAll() {
		queue.eraseAll();
	}
}

