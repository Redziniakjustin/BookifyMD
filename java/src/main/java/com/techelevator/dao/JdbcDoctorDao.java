package com.techelevator.dao;

import com.techelevator.model.Doctor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

public class JdbcDoctorDao implements DoctorDao{
    @Override
    public List<Doctor> findAll() {
        return null;
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        return null;
    }

    @Override
    public Doctor findByLastName(String lastName) {
        return null;
    }

    @Override
    public int findIdByLastName(String lastName) {
        return 0;
    }
}
