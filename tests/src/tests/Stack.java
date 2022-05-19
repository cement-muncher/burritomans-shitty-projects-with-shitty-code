package tests;


public class Stack <E>{
	private LinkedList<E> stack;
	Stack(E objeto) {
		this.stack=new LinkedList<E>();
		stack.add(objeto, 0);
	}
	Stack() {
		this.stack=new LinkedList<E>();
	}
	public void push(E objeto) {
		stack.add(objeto,stack.n);
	}
	public E peek( ) {
		return stack.getObjeto(stack.n);
	}
	public E pop() {
		E a=stack.getObjeto(stack.n);
		stack.remove(stack.n);
		return a;
	}
}
