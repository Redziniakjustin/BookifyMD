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

    //List<Appointment> findAll();

    List<Appointment> findAllByPatientId(Long patientId);

    List<Appointment> findAllByDoctorId(Long doctorId);

    Appointment getAppointmentById(Long appointmentId);


    List<Appointment> findAppointmentsByOfficeId(Long officeId);

    boolean create(Appointment newAppointment);

    boolean updateAppointment(Appointment appointment, Long appointmentId);





}
