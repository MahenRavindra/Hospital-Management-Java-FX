package Code.dao.custom;

import Code.dao.CrudDAO;
import Code.entity.Doctor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DoctorDao extends CrudDAO<Doctor,String> {

    public ArrayList<Doctor> searchDoctors(String text) throws SQLException, ClassNotFoundException;
}
