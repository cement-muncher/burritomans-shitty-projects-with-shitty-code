
public class Ejercicio4 {
	public void removeAll(ListaDinamica datosABorrar) {
		Nodo node=primero;
		while (datosABorrar.siguiente!=NULL) {
			if (node.dato=datosABorrar.dato) {
				primero=node.siguiente;
			} else {
				while (node.siguiente.dato!=datosABorrar.dato) {
					node=node.siguiente;
				}
				node.siguiente=node.siguiente.siguiente;
				node=primero;
			}
		}
	}
}
