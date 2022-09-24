package Code.dao.custom.impl;

import Code.dao.custom.PatientDao;
import Code.entity.Patient;

import java.sql.SQLException;
import java.util.ArrayList;

public class PatientDaoImpl implements PatientDao {
    @Override
    public boolean save(Patient patient) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Patient patient) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Patient get(String s) {
        return null;
    }

    @Override
    public ArrayList<Patient> getAllDoctors() {
        return null;
    }
}
