package com.techelevator.dao;


import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOfficeDao implements OfficeDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcOfficeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String getFullOffice = "SELECT office_id, office_name, street_address, city, " +
            "state_name, zip, phone, email, office_hours_start, office_hours_end, delay_status FROM office";

    @Override
    public List<Office> findAll() {
        List<Office> offices = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(getFullOffice + ";");

        while(results.next()){
            offices.add(mapRowToOffice(results));
        }
        return offices;

    }

    @Override
    public Office getOfficeById(Long officeId) {
        Office office = new Office();
        SqlRowSet results = jdbcTemplate.queryForRowSet(getFullOffice + " WHERE office_id = ?;", officeId);
        if(results.next()){
            office = mapRowToOffice(results);
        } else {
            //TODO fix me exception
            System.out.println("Office NOT FOUND");
        }
        return office;
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
      String sql = "INSERT INTO office ( office_name, street_address, city, state_name, zip, phone, email, office_hours_start, office_hours_end, delay_status) VALUES (?,?,?,?,?,?,?,?,?,?) RETURNING office_id;";
      Long officeId = null;
      try{
        officeId = jdbcTemplate.queryForObject(sql, Long.class, newOffice.getOfficeName(), newOffice.getStreetAddress(),
                newOffice.getCity(), newOffice.getStateName(), newOffice.getZip(),
                newOffice.getPhone(), newOffice.getEmail(), newOffice.getOfficeHoursStart(), newOffice.getOfficeHoursEnd(), newOffice.isDelayStatus());
        officeCreated = true;
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
      return officeCreated;
    }

    @Override
    public boolean update(Office office, Long officeId) {
        boolean isUpdated = false;

        String sql = "UPDATE office SET  office_name=?, street_address=?, city=?, " +
                "state_name=?, zip=?, phone=?, email=?, office_hours_start =?, office_hours_end =?, delay_status=? WHERE office_id =?;";
        try{
            jdbcTemplate.update(sql, office.getOfficeName(), office.getStreetAddress(), office.getCity(),
                    office.getStateName(), office.getZip(), office.getPhone(), office.getEmail(),
                    office.getOfficeHoursStart(), office.getOfficeHoursEnd(), office.isDelayStatus(), officeId);
            isUpdated = true;
        }catch (Exception e){
                System.out.println(e.getMessage());
        }

        return isUpdated;
    }


    @Override
    public boolean updateStatus(Long officeId, boolean delayStatus) {
        boolean isStatusUpdated = false;
        String sql = "UPDATE office SET delay_status = ? WHERE office_id = ?;";
        try{
            jdbcTemplate.update(sql, delayStatus, officeId);
            isStatusUpdated = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return isStatusUpdated;
    }

    private Office mapRowToOffice(SqlRowSet row){
        Office office = new Office();
        office.setOfficeId(row.getLong("office_id"));
        office.setOfficeName(row.getString("office_name"));
        office.setStreetAddress(row.getString("street_address"));
        office.setCity(row.getString("city"));
        office.setStateName(row.getString("state_name"));
        office.setZip(row.getString("zip"));
        office.setPhone(row.getString("phone"));
        office.setEmail(row.getString("email"));
        office.setOfficeHoursStart(row.getTime("office_hours_start"));
        office.setOfficeHoursEnd(row.getTime("office_hours_end"));
        office.setDelayStatus(row.getBoolean("delay_status"));
        return office;
    }
}
