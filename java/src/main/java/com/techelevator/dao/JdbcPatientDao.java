package com.techelevator.dao;


import com.techelevator.model.Doctor;
import com.techelevator.model.Patient;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcPatientDao implements PatientDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcPatientDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }



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

    @Override
    public boolean create(Patient newPatient) {
        boolean patientCreated = false;

        //create pt SQL
        String sql = "INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email) VALUES (?,?,?,?,?,?,?,?,?) RETURNING patient_id";
        Long patientId = null;
        try {
           patientId = jdbcTemplate.queryForObject(sql,Long.class,newPatient.getUserId(), newPatient.getFirstName(), newPatient.getLastName(),
                   newPatient.getPhone(),newPatient.getStreetAddress(), newPatient.getCity(), newPatient.getStateName(), newPatient.getZip(), newPatient.getEmail());
            patientCreated =true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return patientCreated;
    }
}
