package com.techelevator.dao;

import com.techelevator.model.Appointment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcAppointmentDao implements AppointmentDao{
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
    public int findIdByPatientId(Long patientId) {
        return 0;
    }

    @Override
    public int findIdByDoctorId(Long doctorId) {
        return 0;
    }
}
