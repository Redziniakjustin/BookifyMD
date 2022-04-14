package com.techelevator.dao;


import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import com.techelevator.model.Patient;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

public interface OfficeDao {

    List<Office> findAll();

   Office getOfficeById(Long officeId);

    Office findByOfficeName(String officeName);

    List<Doctor> findDoctorsByOfficeId(Long officeId);

    int findIdByOfficeName(String officeName);

    boolean create(Long doctorId, Long availId, String officeName,
                   String streetAddress, String city, String stateName,
                   String zip, String email, String officeHours, boolean delayStatus);

    boolean updateStatus(Long officeId, boolean delayStatus);

}
