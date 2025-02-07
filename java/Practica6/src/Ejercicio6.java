/* Un programador inteligente sabe 
 * que si no esta roto mejor no tocarlo
 * (Al menos durante produccion)
 */

public class Ejercicio6 {
		private Object[] arrayElementos;
		private int numElementos;
		private static final int TAMA�O_INICIAL = 4;

		// M�todos  
		/** 
		 * Inicializa el array de elementos de la lista.  
		 */
		public Ejercicio6 (){
		arrayElementos = new Object[TAMA�O_INICIAL];
		numElementos = 0;
		}
		 
		/**
		 * @return n�mero de elementos actual en la lista.
		 */
		
		public void push(Object elemento) {
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

		private void comprobarLlenado() {
			// El array interno est� casi lleno, se duplica el espacio. 
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
		
		public Object pop() {
			Object returnable=arrayElementos[numElementos-1];
			if (numElementos==1) {
				arrayElementos[0]=null;
				return returnable;
			}
			arrayElementos[--numElementos]=null;
			return returnable;
		}

}
