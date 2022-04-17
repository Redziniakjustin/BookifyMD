package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.Availability;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class JdbcAppointmentDao implements AppointmentDao{

    JdbcTemplate jdbcTemplate;
    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Appointment> findAll() {
        return null;
    }

    @Override
    public Appointment getAppointmentById(Long appointmentId) {
        return null;
    }

    @Override
    public Appointment findByPatientId(Long patientId) {
        return null;
    }

    @Override
    public Appointment findByDoctorId(Long doctorId) {
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
    public int findIdByPatientId(Long patientId) {
        return 0;
    }

    @Override
        public int findIdByDoctorId(Long doctorId) {
            return 0;
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
    }
