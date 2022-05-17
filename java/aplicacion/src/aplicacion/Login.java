package aplicacion;

public class Login {
	
	public static void userLogin() {
		String username="admin";
		SQLWrapper wrapper=new SQLWrapper();
		String password="admin";
		String[] a={"username","password"};
		wrapper.SQLGetString(a);
		for (String b:a) {
			Log.aplicationLog(b);
		}
	}
}
