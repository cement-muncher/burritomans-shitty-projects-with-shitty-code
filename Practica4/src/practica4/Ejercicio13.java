<<<<<<< HEAD:java/Practica4/src/practica4/Ejercicio13.java
package practica4;

public class Ejercicio13 {
	public static void main(String args[]) {
		int[][] array= {
				{ 2,5,7,1,4},
				{ 3,5,7,6,7},
				{ 4,8,3,9,3}
			};
		System.out.print(maxima3(array));

	}
	private static int maxima3(int array[][]) {
		int alto=method(array.length);
		int ancho=method(array[0].length);
		int max=Integer.MIN_VALUE;
		int value=0;
		for (int i=0;i<alto;i++) {
			for (int j=0;j<ancho;j++) {
				value=(	array[i][j]+array[i+1][j]+array[i+2][j]+
						array[i][j+1]+array[i+1][j+1]+array[i+2][j+1]+
						array[i][j+2]+array[i+1][j+2]+array[i+2][j+2]
					);
				if (value>max) {
					max=value;
				}
			}
		}
		
		
		
		return max;
	}
	
	private static int method(int a) {
			switch (a) {
				case 3:
					return 1;
				case 4:
					return 2;
				default:
					return a-2;
			}
	}
}
=======
package practica4;

public class Ejercicio13 {
	public static void main(String args[]) {
		int[][] array= {
				{ 2,5,7,1,4},
				{ 3,5,7,6,7},
				{ 4,8,3,9,3}
			};
		System.out.print(maxima3(array));

	}
	private static int maxima3(int array[][]) {
		int alto=method(array.length);
		int ancho=method(array[0].length);
		int max=Integer.MIN_VALUE;
		int value=0;
		for (int i=0;i<alto;i++) {
			for (int j=0;j<ancho;j++) {
				value=(	array[i][j]+array[i+1][j]+array[i+2][j]+
						array[i][j+1]+array[i+1][j+1]+array[i+2][j+1]+
						array[i][j+2]+array[i+1][j+2]+array[i+2][j+2]
					);
				if (value>max) {
					max=value;
				}
			}
		}
		
		
		
		return max;
	}
	
	private static int method(int a) {
			switch (a) {
				case 3:
					return 1;
				case 4:
					return 2;
				default:
					return a-2;
			}
	}
}
>>>>>>> 634b186ec6c7edf94e90b673ce85b49a81dd4efb:Practica4/src/practica4/Ejercicio13.java
