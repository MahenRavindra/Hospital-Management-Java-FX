package Code.dao;
import Code.db.DBConnection;
import Code.entity.Doctor;
import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import java.util.ArrayList;
public class DatabaseAccess {
    //save doctor details
    public static boolean saveDoctor(Doctor doc) throws ClassNotFoundException, SQLException {
        PreparedStatement stm=DBConnection.getInstance().getcConnection().prepareStatement("INSERT INTO Doctor VALUES (?,?,?,?)");
        stm.setString(1, doc.getDid());
        stm.setString(2,doc.getName());
        stm.setString(3, doc.getAddress());
        stm.setString(4, doc.getContact());
        return stm.executeUpdate()>0;
    }
    //load doctor details to table
    public static ArrayList<Doctor> searchDoctor(String text)throws ClassNotFoundException, SQLException {

        String searchtext="%"+text+"%";
        PreparedStatement stm=DBConnection.getInstance().getcConnection().prepareStatement("SELECT * FROM doctor WHERE name LIKE ? || address LIKE ? || contact LIKE ?");
        stm.setString(1,searchtext);
        stm.setString(2,searchtext);
        stm.setString(3,searchtext);


        ResultSet set= stm.executeQuery();
        ArrayList<Doctor> list=new ArrayList<>();
        while(set.next()){
            list.add(new Doctor(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4)
            ));
        }
       return list;
    }

    public  boolean deleteDoctor(String id) throws ClassNotFoundException, SQLException {
        PreparedStatement stm=DBConnection.getInstance().getcConnection().prepareStatement("DELETE FROM Doctor WHERE did=?");
        stm.setString(1,id);
        return stm.executeUpdate()>0;
    }

    public static boolean updateDoctor(Doctor doc) throws ClassNotFoundException, SQLException {
        PreparedStatement stm=DBConnection.getInstance().getcConnection().prepareStatement("UPDATE Doctor SET name=?,address=?,contact=? WHERE dId=?");
        stm.setString(1, doc.getName());
        stm.setString(2,doc.getAddress());
        stm.setString(3, doc.getContact());
        stm.setString(4, doc.getDid());
        return stm.executeUpdate()>0;
    }

}
