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
		stack.add(objeto,stack.getLength());
	}
	public E peek( ) {
		return stack.getObjeto(stack.getLength());
	}
	public E pop() {
		E a=stack.getObjeto(stack.getLength());
		stack.remove(stack.getLength());
		return a;
	}
}
