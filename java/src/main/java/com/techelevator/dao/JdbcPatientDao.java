package com.techelevator.dao;


import com.techelevator.model.Patient;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcPatientDao implements PatientDao{
    @Override
    public List<Patient> findAll() {
        return null;
    }

    @Override
    public Patient getPatientById(Long patientId) {
        return null;
    }

    @Override
    public Patient findByLastName(String lastName) {
        return null;
    }

    @Override
    public int findIdByLastName(String lastName) {
        return 0;
    }
}
