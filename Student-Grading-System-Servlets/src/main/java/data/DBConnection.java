package data;
import java.sql.*;
public class DBConnection {

    private static DBConnection instance;
    private static Connection connection;
    private String url = "jdbc:mysql://localhost:3306/school";
    private String username = "admin";
    private String password = "admin";

    private DBConnection() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public static Connection getConnection() throws SQLException{
        if (instance == null){
            instance = new DBConnection();
        }else if(connection.isClosed()){
            instance = new DBConnection();
        }
        return connection;
    }
}
