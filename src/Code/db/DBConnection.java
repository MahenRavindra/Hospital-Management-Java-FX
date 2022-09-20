package Code.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static  DBConnection dbconnection;
    private Connection connection;
    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/healthCare","root","root"
        );
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
       return dbconnection==null? dbconnection=new DBConnection():dbconnection;
    }
    public Connection getcConnection(){
        return connection;
    }

}
