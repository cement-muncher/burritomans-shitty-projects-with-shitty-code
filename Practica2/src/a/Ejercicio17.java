package a;
import java.util.*;
public class Ejercicio17 {
		public static void main(String args[]) {
			Scanner scanner=new Scanner(System.in);
			int size=scanner.nextInt();
			for (int i=0;i<size;i++) {
				for (int j=0;j<size;j++) {
					if (i==0||i+1==size||j==0||j+1==size) {
						System.out.print('#');
					} else {
						System.out.print(' ');
					}
				}
				System.out.print('\n');
			}
			scanner.close();
		}
}
