package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.OfficeDao;
import com.techelevator.model.Appointment;
import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/appointments")

public class AppointmentController {

    private AppointmentDao appointmentDao;

    public AppointmentController(AppointmentDao appointmentDao){
        this.appointmentDao = appointmentDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Appointment> getAppointmentsByOfficeId(@RequestParam Long officeId){
        return appointmentDao.findAppointmentsByOfficeId(officeId);
    }

    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Appointment getAppointmentByUserId(@RequestParam Long userId, Principal principal){
        return appointmentDao.getAppointmentById(userId);
    }


    //front end --> json with {doctorId, officeId...}
    //which endpoint to use for the newly created appointment
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "" , method = RequestMethod.POST)
    public boolean createAppointment(@Valid @RequestBody Appointment appointment){
       Appointment newAppointment = new Appointment();
       return appointmentDao.create(appointment.getDoctorId(), appointment.getPatientId(), appointment.getOfficeId(),
               appointment.getAppointmentDate(), appointment.getAppointmentStatus(), appointment.getDescription());
    }

}
