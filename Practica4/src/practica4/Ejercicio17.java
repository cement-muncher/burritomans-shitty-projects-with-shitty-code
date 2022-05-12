package practica4;

public class Ejercicio17 {
	public static void main(String args[]) {
		int[] array= {1,2,3,4};
		System.out.print(baraja(array));
	}
	private static int baraja(int array[]) {
		int counter1=0;
		int[] array1=new int [array.length];
		for (int i=0;i<array.length-1;i++) {
			if (array[i]<array[i+1]) counter1++;
		}
		if (counter1==array.length-1) return 0;
		for (int i=0;i<array.length;i++) {
			counter1=0;
			for (int j=0;j<i;j++) {
				if (array[i]>=array1[j]) {
					counter1+=1;
				}
			}
			for (int j=array.length-1;j>counter1;j--) {
				array1[j]=array1[j-1];
			}
			array1[counter1]=array[i];
			for (int a:array1) {
				System.out.print(a+" ");
			}
			System.out.print("\n");
			
			
		}
		
		
		return 1;
	}

}
