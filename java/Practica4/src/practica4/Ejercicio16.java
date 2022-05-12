package practica4;

public class Ejercicio16 {
	public static void main(String args[]) {
		int[] array= {5,3,4,5};
		System.out.print(bubble(array));
	}
	private static int bubble(int array[]) {
		int buffer,counter1=0;
		for (int i=0;i<array.length-1;i++) {
			if (array[i]<array[i+1]) counter1++;
		}
		if (counter1==array.length-1) return 0;
		for (int j=0;j<array.length-1;j++) {
			for (int i=0; i<array.length-1;i++) {
				if (array[i]>array[1+i]) {
					buffer=array[i+1];
					array[1+i]=array[i];
					array[i]=buffer;
				}
			}
		}
		return 1;
	}
}
