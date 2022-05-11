package a;
import java.util.*;
public class Ejercicio22 {
		public static void main(String args[]) {
			int number,counter=3;
			Scanner scanner=new Scanner(System.in);
			while (true) {
				number=scanner.nextInt();
				if (number>0) break;
			}
			switch (number) {
				case 1: System.out.print("0\n");
						counter=0;
						break;
				case 2: System.out.println("2");
						counter=1;
						break;
				case 3: System.out.println("2\n3");
						counter=2;
						break;
				case 4: System.out.println("2\n3");
						counter=2;
						break;
				case 5: System.out.println("2\n3\n\5");
						counter=3;
						break;
				default: System.out.println("2\n3\n5");
			}
			for (int i=7;i<=number;i+=2) {
				if (i%5==0) continue;
				for (int j=3;j<=i;j+=2) {
					if (i/j==1&&i%j==0) {
						System.out.print(i+"\n");
						counter++;
						break;
					}
					if (i%j==0) break;
				/*	if (i/3==j) {
						System.out.print(i+"\n");
						counter++;
						break;
					}*/
				}
			}
			System.out.print(counter);
			scanner.close();
		}
}
			