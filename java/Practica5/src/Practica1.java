
public class Practica1 {

	static public void main(String args[]) {
		invertirTexto("HOLA");
	}
	private static void invertirTexto(String a) {
		String b="";
		for (int i=a.length()-1;i>=0;i--) {
			b+=a.charAt(i);
		}
		System.out.print(b);
	}
}
