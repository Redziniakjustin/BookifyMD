package com.techelevator.dao;

import com.techelevator.model.Doctor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDoctorDao implements DoctorDao{

    private final String getFullDoctor = "SELECT doctor_id, user_id, first_name, last_name, phone, email, cost_hourly FROM doctor;";

    private JdbcTemplate jdbcTemplate;

    public JdbcDoctorDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(getFullDoctor);
        while(results.next()){
            doctors.add(mapRowToDoctor(results));
        }
        return doctors;
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

    @Override
    public boolean create(Long userId, String firstName, String lastName, String phone, String email, int costHourly) {
        return false;
    }

    private Doctor mapRowToDoctor(SqlRowSet row){
        Doctor doctor = new Doctor();
        doctor.setDoctorId(row.getLong("doctor_id"));
        doctor.setUserId(row.getLong("user_id"));
        doctor.setFirstName(row.getString("first_name"));
        doctor.setLastName(row.getString("last_name"));
        doctor.setPhone(row.getString("email"));
        doctor.setCostHourly(row.getInt("cost_hourly"));
        return doctor;
    }

}
