package a;
import java.util.*;

public class Ejercicio13 {
	static Scanner scanner=new Scanner(System.in);
	public static  void main (String args[]) {
		Ejercicio13 a=new Ejercicio13();
		a.evaluarDiscriminante();
	}
	void evaluarDiscriminante() {
		double x2,x,number,result1,result2;
		x2=scanner.nextInt();
		x=scanner.nextInt();
		number=scanner.nextInt();
		if (((x*x)-(4*x2*number))<0) {
			System.out.print("La ecuación no tiene soluciones reales");
			scanner.close();
			return;
		}
		result1=(((0-x)+(Math.sqrt((x*x)-(4*x2*number))))/(2*x2));
		result2=(((0-x)-(Math.sqrt((x*x)-(4*x2*number))))/(2*x2));
		System.out.print("Las soluciones son "+result1+" y "+result2);
	}
}
