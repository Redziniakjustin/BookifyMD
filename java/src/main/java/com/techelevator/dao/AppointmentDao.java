package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.Patient;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentDao {

    List<Appointment> findAll();

    Appointment getAppointmentById(Long appointmentId);

    Appointment findByPatientId(Long patientId);

    Appointment findByDoctorId(Long doctorId);

    List<Appointment> findAppointmentsByOfficeId(Long officeId);

    boolean create(Long doctorId, Long patientId, Long officeId, LocalDate appointmentDate, String appointmentStatus, String description);


    int findIdByPatientId(Long patientId);
    int findIdByDoctorId(Long doctorId);




}
