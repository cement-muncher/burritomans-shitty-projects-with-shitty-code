package aplicacion;

public class Login {
	
	public static void userLogin() {
		String username="admin";
		SQLWrapper wrapper=new SQLWrapper();
		String password="admin";
		String[] a={"username","password"};
		String[] c=wrapper.SQLGetString(a);
			Log.aplicationLog(c[0]);
	}
}
