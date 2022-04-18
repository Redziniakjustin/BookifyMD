package com.techelevator.dao;

import com.techelevator.model.Availability;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAvailabilityDao implements AvailabilityDao {

    JdbcTemplate jdbcTemplate;
    public JdbcAvailabilityDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Availability> findAvailabilityByDoctorId(Long doctorId) {
        String sql = "SELECT avail_id, office_id, doctor_id, day_of_week, start_time, end_time, is_available, reason_of_unavailability " +
                "FROM doctor_office_availability WHERE doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        List<Availability> availabilities = new ArrayList<>();
        while(results.next()){
            availabilities.add(mapRowToAvailability(results));
        }
        return availabilities;
    }

    @Override
    public List<Availability> findAllAvailabilityByOfficeId(Long officeId) {
        List<Availability> availabilities = new ArrayList<>();
        String sql = "SELECT avail_id, office_id, doctor_id, day_of_week, start_time, end_time, is_available, reason_of_unavailability FROM doctor_office_availability" +
                " WHERE office_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        while(results.next()){
            availabilities.add(JdbcAvailabilityDao.mapRowToAvailability(results));
        }

        return availabilities;
    }

    @Override
    public List<Availability> findAvailabilityByIsAvailable(Long officeId) {
        List<Availability> availabilities = new ArrayList<>();
        String sql = "SELECT avail_id, office_id, doctor_id, day_of_week, start_time, end_time, is_available, reason_of_unavailability FROM doctor_office_availability" +
                " WHERE office_id = ? AND is_available = true;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        while(results.next()){
            availabilities.add(JdbcAvailabilityDao.mapRowToAvailability(results));
        }

        return availabilities;
    }

    @Override
    public boolean create(Availability newAvailability) {
        boolean isSuccessful = false;
        Long availId = null;
        String sql = "INSERT INTO doctor_office_availability(office_id, doctor_id, day_of_week, start_time, end_time, is_available, reason_of_unavailability) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING avail_id;";
        try{
            availId = jdbcTemplate.queryForObject(sql, Long.class, newAvailability.getOfficeId(), newAvailability.getDoctorId(),
                    newAvailability.getDayOfWeek(), newAvailability.getStartTime(), newAvailability.getEndTime(),
                    newAvailability.getIsAvailable(), newAvailability.getReasonOfUnavailability());
            if(availId != null){
                isSuccessful = true;
            }
        } catch (Exception e){
            System.out.println("Unable to create availability. Please try again.");
        }
        return isSuccessful;
    }

    @Override
    public boolean update(Availability availability, Long availId) {
        boolean isSuccessful = false;

        String sql = "UPDATE doctor_office_availability SET office_id=?, doctor_id=?, day_of_week=?, start_time=?, end_time=?, is_available=?, reason_of_unavailability=? " +
                "WHERE avail_id = ? RETURNING avail_id;";
        try{
            jdbcTemplate.queryForObject(sql, Long.class, availability.getOfficeId(), availability.getDoctorId(),
                    availability.getDayOfWeek(), availability.getStartTime(), availability.getEndTime(),
                    availability.getIsAvailable(), availability.getReasonOfUnavailability(), availId);

            isSuccessful = true;

        } catch (Exception e){
            System.out.println("Unable to update. Please try again.");
        }
        return isSuccessful;
    }

    @Override
    public boolean isAvailableFalse(Long availId) {
        boolean isSuccessful = false;
        String sql = "UPDATE doctor_office_availability SET is_available=false WHERE avail_id = ? RETURNING avail_id;";
        Long returnId = null;
        try{
            returnId = jdbcTemplate.queryForObject(sql, Long.class, availId);
            if(returnId != null){
                isSuccessful = true;
            }
        }
        catch (Exception e){
            System.out.println("Sorry there was an error. Please try again.");
        }
        return isSuccessful;
    }

    @Override
    public boolean updateAvailabilityByDoctorId(boolean isAvailable, Long doctorId, Long availId) {
        boolean isSuccessful = false;
        String sql = "UPDATE doctor_office_availability SET is_available=false WHERE avail_id = ? AND doctor_id = ? RETURNING avail_id;";
        Long returnId = null;
        try{
            returnId = jdbcTemplate.queryForObject(sql, Long.class, isAvailable, availId, doctorId);
            if(returnId != null){
                isSuccessful = true;
            }

        }catch (Exception e){
            System.out.println("Sorry there was an error. Please try again.");
        }
        return isAvailable;
    }

    public static Availability mapRowToAvailability(SqlRowSet row) {
        Availability availability = new Availability();
        availability.setAvailId(row.getLong("avail_id"));
        availability.setOfficeId(row.getLong("office_id"));
        availability.setDoctorId(row.getLong("doctor_id"));
        availability.setDayOfWeek(row.getString("day_of_week"));
        availability.setStartTime(row.getTime("start_time"));
        availability.setEndTime(row.getTime("end_time"));
        availability.setIsAvailable(row.getBoolean("is_available"));
        availability.setReasonOfUnavailability(row.getString("reason_of_unavailability"));

        return availability;
    }

}