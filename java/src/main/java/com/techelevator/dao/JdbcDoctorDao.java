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

    private final String getFullDoctor = "SELECT doctor_id, user_type_id, first_name, last_name, phone, email, cost_hourly FROM doctor;";

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
    public Long create(Doctor newDoctor) {
       boolean doctorCreated = false;

       //create doctor SQL
        String sql = "INSERT INTO doctor (user_type_id, first_name, last_name, phone, email, cost_hourly) VALUES (?,?,?,?,?,?) RETURNING doctor_id";
        Long doctorId = null;
        try {
            doctorId = jdbcTemplate.queryForObject(sql,Long.class,newDoctor.getUserTypeId(), newDoctor.getFirstName(), newDoctor.getLastName(), newDoctor.getPhone(), newDoctor.getEmail(), newDoctor.getCostHourly());
            doctorCreated =true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
       return doctorId;
    }

    @Override
    public boolean updateIsDoctor(Long userTypeId) {
        boolean doctorUpdated = false;
       String sql = "UPDATE user_type SET is_doctor = 'true' WHERE user_type_id = ?;";
       try{
           jdbcTemplate.update(sql, userTypeId);
        doctorUpdated = true;
       } catch (Exception e){
           System.out.println(e.getMessage());
       }
        return doctorUpdated;
    }

    @Override
    public boolean addToDoctorOffice(Long doctorId, Long officeId) {
        boolean isSuccessful = false;
        String sql = "INSERT INTO doctor_office(doctor_id, office_id) VALUES (?,?) RETURNING doctor_office_id;";
        Long doctorOfficeId = null;
        try {
            doctorOfficeId = jdbcTemplate.queryForObject(sql, Long.class, doctorId, officeId );
            if(doctorOfficeId != null){
                isSuccessful = true;
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return isSuccessful;
    }



    private Doctor mapRowToDoctor(SqlRowSet row){
        Doctor doctor = new Doctor();
        doctor.setDoctorId(row.getLong("doctor_id"));
        doctor.setUserTypeId(row.getLong("user_type_id"));
        doctor.setFirstName(row.getString("first_name"));
        doctor.setLastName(row.getString("last_name"));
        doctor.setPhone(row.getString("email"));
        doctor.setCostHourly(row.getLong("cost_hourly"));
        return doctor;
    }

}
