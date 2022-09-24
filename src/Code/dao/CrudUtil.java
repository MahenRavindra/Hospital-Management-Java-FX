package Code.dao;

import Code.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    //create one methode to database access all methods
    public static <T> T excute(String sql ,Object...params) throws SQLException, ClassNotFoundException {
        //var args
        Connection connection= DBConnection.getInstance().getcConnection();
        PreparedStatement stm= connection.prepareStatement(sql);
        for(int i=0;i< params.length;i++){
            stm.setObject((i+1),params[i]);
        }
        if(sql.startsWith("SELECT")){
           return (T)stm.executeQuery();
        }
        return (T)(Boolean)(stm.executeUpdate()>0);

    }
}
