package MySQlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static Connection con=null;
	
	public static Connection getConnection() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Administration", "root",
					"hp15p251nz");
		} catch (SQLException e) {
			System.out.println("URL error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver Not Found");
		}
		return con;
	}
	public static void main(String[] args) {
		try {
			Connection connection=DriverManager.getConnection("oracleserver.database.windows.net/mySampleDatabase","azureuser","Azure1234567");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
