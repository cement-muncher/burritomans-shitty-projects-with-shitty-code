
public class Ejercicio7 {
		private Object[] arrayElementos;
		private int numElementos;
		private static final int TAMAÑO_INICIAL = 4;

		// Métodos  
		/** 
		 * Inicializa el array de elementos de la lista.  
		 */
		public Ejercicio7 (){
		arrayElementos = new Object[TAMAÑO_INICIAL];
		numElementos = 0;
		}
		 
		/**
		 * @return número de elementos actual en la lista.
		 */
		
		public void offer(Object elemento) {
			if (numElementos == 0) {
				arrayElementos[0] = elemento;
				numElementos++;
			}
			else {
				comprobarLlenado();
				arrayElementos[numElementos] = elemento;
				numElementos++;
			}
		}
		public int size() {
			return numElementos;
		}
		private void comprobarLlenado() {
			// El array interno está casi lleno, se duplica el espacio. 
			if (numElementos + 1 == arrayElementos.length) {
			      Object[] arrayAmpliado = new Object[arrayElementos.length*2];
			    System.arraycopy(arrayElementos, 0, 
	                                  arrayAmpliado, 0, numElementos);
				arrayElementos = arrayAmpliado;
			}
		}
		
		public Object peek() {
				return arrayElementos[numElementos];
		}
		
		public Object poll() {
			Object returnable=arrayElementos[0];
			if (numElementos==1) {
				return returnable;
			}
			for (int i=0;i<numElementos;i++) {
				arrayElementos[i]=arrayElementos[i+1];
			}
			return returnable;
		}
		public void clear() {
			if (numElementos==1) {
				return;
			}
			for (int i=0;i<numElementos;i++) {
				arrayElementos[i]=null;
			}
		}
		
		boolean contains(Object a) {
			for (int i=0;i<numElementos;i++) {
				if (arrayElementos[i].equals(a)) {
					return true;
				}
			}
			return false;
		}
		public boolean isEmpty() {
			if (numElementos==0) {
				return true;
			}
			return false;
		}
}
