package username;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class SqlServerConnection {
	 Connection  connection=null;
	 private static String connectionUrl = "jdbc:sqlserver://localhost:1433;" + 
			 "databaseName=Lambton_Car_pool;user=sa;password=123456";
       public static Connection dbConnector()
       {
    	  
    	   try {
    		   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		   Connection conn= DriverManager.getConnection(connectionUrl);
    		   JOptionPane.showMessageDialog(null, "Connection sucessfull");
    		   return conn;
    	   }catch (Exception e)
    	   {
    		   JOptionPane.showMessageDialog(null, e);
    		   return null;
    		   
    	   }
       }
       
}
