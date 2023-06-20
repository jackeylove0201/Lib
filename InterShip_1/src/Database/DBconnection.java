package Database;

import java.sql.*;
import java.sql.DriverManager;
public class DBconnection {
	public static final String HOSTNAME = "DESKTOP-IV5V35S\\SQLEXPRESS01";

    public static final String PORT = "1433";

    public static final String DBNAME = "Library";

    public static final String USERNAME = "sa";

    public static final String PASSWORD = "123456";

    /**
     *
     * Get connection to MSSQL Server
     *
     * @return Connection
     *
     */
    public static Connection getConnection() {

        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
                + "databaseName=" + DBNAME+ ";encrypt=true;trustServerCertificate=true;";

        try {
       

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            return DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);

        } // Handle any errors that may have occurred.
        catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace(System.out);

        }

        return null;
    }
    /**
     *
     * @param c
     */
    public static void closeConnection(Connection c ){
           try {
              if (c!=null){
                    c.close();
        }
           }catch (Exception e) {
                e.printStackTrace();
                }
        
    }

}
