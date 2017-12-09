package connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public class SqlServerConnection1 {

private static String connectionUrl = "jdbc:sqlserver://localhost:1433;" + 
"databaseName=Lambton_Car_pool;user=sa;password=123456";


public static Connection getConnection() throws SQLException
{
	try 
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	}
	catch (ClassNotFoundException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return DriverManager.getConnection(connectionUrl);
}
	
	public static void main(String args[]) throws SQLException
	{
		
		Connection conn = getConnection();
		System.out.println(conn.isValid(500));
	}
} 