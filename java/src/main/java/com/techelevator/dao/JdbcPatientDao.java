package com.techelevator.dao;


import com.techelevator.model.Doctor;
import com.techelevator.model.Patient;
import com.techelevator.model.UserType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPatientDao implements PatientDao{

    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;
    public JdbcPatientDao(JdbcTemplate jdbcTemplate, UserDao userDao){
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
    }
    private final String getFullPatient = "SELECT patient_id, user_type_id, first_name, last_name, phone, street_address, city, state_name, zip, email FROM patient";

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(getFullPatient);
        while(results.next()){
            patients.add(mapRowToPatient(results));
        }
        return patients;
    }

    @Override
    public Patient getPatientById(Long patientId) {
        Patient patient = new Patient();
        SqlRowSet results = jdbcTemplate.queryForRowSet(getFullPatient +" WHERE patient_id = ?;", patientId);
        if(results.next()){
            patient = mapRowToPatient(results);
        } else {
            System.out.println("Patient not found. Please try again.");
        }
        return patient;
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
        String sql = "INSERT INTO patient (user_type_id, first_name, last_name, phone, street_address, city, state_name, zip, email) VALUES (?,?,?,?,?,?,?,?,?) RETURNING patient_id";
        Long patientId = null;
        try {
           patientId = jdbcTemplate.queryForObject(sql,Long.class,newPatient.getUserTypeId(), newPatient.getFirstName(), newPatient.getLastName(),
                   newPatient.getPhone(),newPatient.getStreetAddress(), newPatient.getCity(), newPatient.getStateName(), newPatient.getZip(), newPatient.getEmail());
            patientCreated =true;
        }
        catch(Exception e) {
            System.out.println("Error. Please try again.");
        }
        return patientCreated;
    }

    @Override
    public Patient findPatientByUsername(String username) {
        Patient patient = new Patient();
        UserType userType = userDao.findUserTypeByUsername(username);

        if(!userType.getIsDoctor()){
            String sql = "select * from patient as p join user_type as ut on ut.user_type_id = p.user_type_id where p.user_type_id = ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userType.getUserTypeId());
            if(results.next()){
                patient = mapRowToPatient(results);
            }
        }
        return patient;
    }

    private Patient mapRowToPatient(SqlRowSet row){
        Patient patient = new Patient();
        patient.setPatientId(row.getLong("patient_id"));
        patient.setUserTypeId(row.getLong("user_type_id"));
        patient.setFirstName(row.getString("first_name"));
        patient.setLastName(row.getString("last_name"));
        patient.setPhone(row.getString("phone"));
        patient.setStreetAddress(row.getString("street_address"));
        patient.setStateName(row.getString("state_name"));
        patient.setZip(row.getString("zip"));
        patient.setEmail(row.getString("email"));
        return patient;
    }


}
