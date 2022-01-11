package aplication;

public class Interface {
	public static String input( ) {
		String result="";
		String buffer="";
		Main.scanner.next();
		while (true) {
			buffer=Main.scanner.next();
			if (buffer!="\n") {
				result+=buffer;
			} else {
				break;
			}
		}
		return result;
	}
}
