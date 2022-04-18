package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.Patient;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;


public interface PatientDao {

    List<Patient> findAll();

    Patient getPatientById(Long patientId);

    Patient findByLastName(String lastName);

    int findIdByLastName(String lastName);

    boolean create(Patient newPatient);

    Patient findPatientByUsername(String username);
}
