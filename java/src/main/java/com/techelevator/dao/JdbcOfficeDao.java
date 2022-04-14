package com.techelevator.dao;


import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcOfficeDao implements OfficeDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcOfficeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Office> findAll() {
        return null;
    }

    @Override
    public Office getOfficeById(Long officeId) {
        return null;
    }

    @Override
    public Office findByOfficeName(String officeName) {
        return null;
    }

    @Override
    public List<Doctor> findDoctorsByOfficeId(Long officeId) {
        return null;
    }

    @Override
    public int findIdByOfficeName(String officeName) {
        return 0;
    }

    @Override
    public boolean create(Office newOffice) {
        boolean officeCreated = false;
      String sql = "INSERT INTO office ( office_name, street_address, city, state_name, zip, phone, email, office_hours, delay_status) VALUES (?,?,?,?,?,?,?,?,?) RETURNING office_id;";
      Long officeId = null;
      try{
        officeId = jdbcTemplate.queryForObject(sql, Long.class, newOffice.getOfficeName(), newOffice.getStreetAddress(), newOffice.getCity(),
                  newOffice.getStateName(), newOffice.getZip(), newOffice.getPhone(), newOffice.getEmail(), newOffice.getOfficeHours(), newOffice.isDelayStatus());
        officeCreated = true;
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
      return officeCreated;
    }

    @Override
    public boolean updateStatus(Long officeId, boolean delayStatus) {
        return false;
    }
}
