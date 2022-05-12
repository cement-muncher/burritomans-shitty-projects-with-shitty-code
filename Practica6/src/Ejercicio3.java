
public class Ejercicio3 {
	public void add(int indice, Object dato) {
		Nodo node=new Nodo(dato);
		Nodo temporalNode=primero;
		if (indice==0) {
			primero.siguiente=node;
			return;
		}
		for (int i=0;i<indice;i++) {
			temporalNode=temporalNode.siguiente;
		}
		node.siguiente=temporalNode;
	}
}
