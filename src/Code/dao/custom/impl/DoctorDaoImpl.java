package Code.dao.custom.impl;

import Code.dao.CrudUtil;
import Code.dao.custom.DoctorDao;
import Code.entity.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorDaoImpl implements DoctorDao {
    @Override
    public boolean save(Doctor doctor) throws SQLException, ClassNotFoundException {
        return CrudUtil.excute("INSERT INTO Doctor VALUES (?,?,?,?)"
                ,doctor.getDid(),doctor.getName(),doctor.getAddress(),doctor.getContact());
    }

    @Override
    public boolean update(Doctor doctor) throws SQLException, ClassNotFoundException {
        return CrudUtil.excute("UPDATE Doctor SET name=?,address=?,contact=? WHERE dId=?",
                doctor.getName(),doctor.getAddress(),doctor.getContact(), doctor.getDid() );
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.excute("DELETE FROM Doctor WHERE did=?",s);
    }

    @Override
    public Doctor get(String s) {
        return null;
    }

    @Override
    public ArrayList<Doctor> getAllDoctors() {
        return null;
    }

    @Override
    public ArrayList<Doctor> searchDoctors(String text) throws SQLException, ClassNotFoundException {
        String searchtext="%"+text+"%";

        ResultSet set=CrudUtil.excute("SELECT * FROM doctor WHERE name LIKE ? || address LIKE ? || contact LIKE ?"
                ,searchtext,searchtext,searchtext);

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
}
