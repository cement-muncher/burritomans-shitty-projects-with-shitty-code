package aplicacion;
import java.sql.*;
public class SQLWrapper {
	static private Connection connection=null;
	SQLWrapper () {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception E) {
			
		}
		if (connection==null) {
			try {
			
				connection = DriverManager.getConnection("jdbc:mysql://172.28.73.238:3306/labyrinth?user=root&password=toor");
			} catch (SQLException E) {
				Log.debugLog("SQLException", E);
			}
		}
	}
	public String[] SQLGetString(String arrayFields[]) {
		ResultSet resultset;
		String[] returnable=new String[arrayFields.length];
		String selectSql = "SELECT ";
		for (String string :arrayFields) {
			 selectSql+=string+",";
		}
		selectSql=" FROM USERS;";
		System.out.print(selectSql);
		try {
			Statement statement=connection.createStatement();
        	resultset = statement.executeQuery(selectSql);
        	resultset.next();
        	int i=0;
        	for (String buffer: returnable) {
        		buffer=resultset.getNString(arrayFields[i++]);
        	}
		} catch (SQLException E) {
			Log.debugLog("SQLException", E);
		}
		return returnable;
	}
}
