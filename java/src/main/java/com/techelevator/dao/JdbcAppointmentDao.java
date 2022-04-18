package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.Availability;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcAppointmentDao implements AppointmentDao{

    JdbcTemplate jdbcTemplate;
    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

/*    @Override
    public List<Appointment> findAll() {
        return null;
    }*/

    @Override
    public List<Appointment> findAllByPatientId(Long patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT a.appointment_id, a.doctor_id, a.patient_id, a.office_id, a.avail_id, doa.start_time, doa.end_time, a.appointment_date, a.appointment_status, a.description \n" +
                "FROM appointment as a JOIN doctor_office_availability as doa ON a.avail_id = doa.avail_id WHERE a.patient_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        while(results.next()){
            appointments.add(mapRowToAppointmentWithTimeSlot(results));
        }
        return appointments;
    }

    @Override
    public List<Appointment> findAllByDoctorId(Long doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT a.appointment_id, a.doctor_id, a.patient_id, a.office_id, a.avail_id, doa.start_time, doa.end_time, a.appointment_date, a.appointment_status, a.description \n" +
                "FROM appointment as a JOIN doctor_office_availability as doa ON a.avail_id = doa.avail_id WHERE doa.doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while(results.next()){
            appointments.add(mapRowToAppointmentWithTimeSlot(results));
        }
        return appointments;
    }

    @Override
    public Appointment getAppointmentById(Long appointmentId) {
        return null;
    }

    @Override
    public List<Appointment> findAppointmentsByOfficeId(Long officeId) {
        return null;
    }

    @Override
    public boolean create(Appointment newAppointment) {
            boolean isSuccessful = false;
            Long appId = null;
            String sql = "INSERT INTO appointment( doctor_id, patient_id, office_id, avail_id, appointment_date, appointment_status, description) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING appointment_id;";
            try {
                appId = jdbcTemplate.queryForObject(sql, Long.class, newAppointment.getDoctorId(), newAppointment.getPatientId(), newAppointment.getOfficeId(),
                        newAppointment.getAvailId(), newAppointment.getAppointmentDate(), newAppointment.getAppointmentStatus(), newAppointment.getDescription());
                if (appId != null){
                    isSuccessful = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return isSuccessful;
        }

    @Override
    public boolean updateAppointmentStatus(Appointment appointment, Long appointmentId) {
        boolean isUpdated = false;
        String sql = "UPDATE appointment SET appointment_status =? WHERE appointment_id=?;";
        try{
            jdbcTemplate.update(sql,appointment.getAppointmentStatus(), appointmentId);
            isUpdated = true;
        }catch(Exception e){
            System.out.println("Sorry there was an error. Please try again.");
        }
        return isUpdated ;
    }

    private Appointment mapRowToAppointment(SqlRowSet row) {
        Appointment appointment= new Appointment();
        appointment.setAppointmentId(row.getLong("appointment_id"));
        appointment.setDoctorId(row.getLong("doctor_id"));
        appointment.setPatientId(row.getLong("patient_id"));
        appointment.setOfficeId(row.getLong("office_id"));
        appointment.setAvailId(row.getLong("avail_id"));
        appointment.setAppointmentDate(row.getDate("appointment_date"));
        appointment.setAppointmentStatus(row.getString("appointment_status"));
        appointment.setDescription(row.getString("description"));
        return appointment;
    }

    private Appointment mapRowToAppointmentWithTimeSlot(SqlRowSet row) {
        Appointment appointment= new Appointment();
        appointment.setAppointmentId(row.getLong("appointment_id"));
        appointment.setDoctorId(row.getLong("doctor_id"));
        appointment.setPatientId(row.getLong("patient_id"));
        appointment.setOfficeId(row.getLong("office_id"));
        appointment.setAvailId(row.getLong("avail_id"));
        appointment.setStartTime(row.getTime("start_time"));
        appointment.setEndTime(row.getTime("end_time"));
        appointment.setAppointmentDate(row.getDate("appointment_date"));
        appointment.setAppointmentStatus(row.getString("appointment_status"));
        appointment.setDescription(row.getString("description"));
        return appointment;
    }
}
