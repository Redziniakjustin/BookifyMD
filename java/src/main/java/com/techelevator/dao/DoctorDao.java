package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

public interface DoctorDao {

    List<Doctor> findAll();

    Doctor getDoctorById(Long doctorId);

    Doctor findByLastName(String lastName);

    int findIdByLastName(String lastName);

    Long create(Doctor newDoctor);

    boolean updateIsDoctor(Long userTypeId);

    //add doctor_id and office_id to doctor_office table
    boolean addToDoctorOffice(Long doctorId, Long officeId);

    //UPDATE DOCTOR PROFILE



}



