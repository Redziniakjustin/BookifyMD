package com.techelevator.dao;


import com.techelevator.model.Doctor;
import com.techelevator.model.Review;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao{

    public JdbcTemplate jdbcTemplate;

    public JdbcReviewDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> findAll() {
        return null;
    }

    @Override
    public Review getReviewById(Long reviewId) {
        return null;
    }

    @Override
    public Review findReviewByOfficeId(Long officeId) {
        return null;
    }

    @Override
    public int findReviewIdByOfficeId(Long officeId) {
        return 0;
    }

    @Override
    public int findReviewIdByPatientId(Long patientId) {
        return 0;
    }

    private Long findDoctorIdByName(String firstName, String lastName){
        String sql = "SELECT d.doctor_id FROM doctor as d WHERE d.first_name = ? AND d.last_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, firstName, lastName);
        Long doctorId = null;
        if(results.next()){
            doctorId = mapRowToDoctorId(results);
        }
        return doctorId;
    }

    public Long mapRowToDoctorId(SqlRowSet row) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(row.getLong("doctor_id"));
        return doctor.getDoctorId();

    }


}
