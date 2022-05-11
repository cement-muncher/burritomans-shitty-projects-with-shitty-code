package a;
import java.util.*;
public class Ejercicio16 {
		public static void main(String args[]) {
			Scanner scanner=new Scanner(System.in);
			double dpfpn;
			int decimales;
			while (true) {
				dpfpn=scanner.nextDouble();
				System.out.print("Numero leido:" +dpfpn+"\nDecimales:");
				decimales=scanner.nextInt();
				dpfpn=dpfpn*Math.pow(10, decimales);
				dpfpn=Math.rint(dpfpn)/Math.pow(10, decimales);
				break;
			}
			System.out.print("Valor mostrado:"+ dpfpn);
			scanner.close();
		}
}