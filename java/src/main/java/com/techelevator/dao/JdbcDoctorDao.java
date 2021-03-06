package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.UserType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDoctorDao implements DoctorDao{

    private final String getFullDoctor = "SELECT doctor_id, user_type_id, first_name, last_name, phone, email, cost_hourly FROM doctor;";

    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;

    public JdbcDoctorDao(JdbcTemplate jdbcTemplate, UserDao userDao){
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
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

    @Override
    public Doctor findDoctorByUsername(String username) {
        UserType userType = userDao.findUserTypeByUsername(username);
        Doctor doctor = new Doctor();
        if(userType.getIsDoctor()){
            //get doctor profile
            String sql = "select * from doctor as d join user_type as ut on ut.user_type_id = d.user_type_id where d.user_type_id = ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userType.getUserTypeId());
            if(results.next()){
                doctor = mapRowToDoctor(results);
            }
        }
        return doctor;
    }

    @Override
    public Doctor findDoctorByUserId(Long userId) {

        Doctor doctor = new Doctor();

        String sql = "select * from doctor as d join user_type as ut on ut.user_type_id = d.user_type_id where ut.user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if(results.next()){
            doctor = mapRowToDoctor(results);
        }

        return doctor;
    }

    private Doctor mapRowToDoctor(SqlRowSet row){
        Doctor doctor = new Doctor();
        doctor.setDoctorId(row.getLong("doctor_id"));
        doctor.setUserTypeId(row.getLong("user_type_id"));
        doctor.setFirstName(row.getString("first_name"));
        doctor.setLastName(row.getString("last_name"));
        doctor.setPhone(row.getString("phone"));
        doctor.setEmail(row.getString("email"));
        doctor.setCostHourly(row.getLong("cost_hourly"));
        doctor.setOfficeId(getOfficeIdByDoctorId(doctor.getDoctorId()));
        return doctor;
    }

    private Long getOfficeIdByDoctorId(Long doctorId){
        String sql = "SELECT office_id FROM doctor_office WHERE doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        Long officeId = null;
        if(results.next()){
            officeId = mapRowToOfficeId(results);
        }
        return officeId;
    }

    private Long mapRowToOfficeId(SqlRowSet row){
        Doctor doctor = new Doctor();
        doctor.setOfficeId(row.getLong("office_id"));
        return doctor.getOfficeId();
    }

}
