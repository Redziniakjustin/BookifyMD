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

    //localhost:8080/appointments?officeId=<officeId>
/*    @RequestMapping(method = RequestMethod.GET)
    public List<Appointment> getAppointmentsByOfficeId(@RequestParam(name = "officeId") Long officeId){
        return appointmentDao.findAppointmentsByOfficeId(officeId);
    }*/

    //GET APPOINTMENT BY APPOINTMENT ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Appointment getAppointmentByUserId(@PathVariable Long id){               //id here is appointmentId
        return appointmentDao.getAppointmentById(id);
    }

    //GET APPOINTMENTS BY DOCTOR ID
    //localhost:8080/appointments?doctorId=<doctorId>
    //localhost:8080/appointments/doctors/{id}
    @RequestMapping(value = "/doctors/{id}" , method = RequestMethod.GET)
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable Long id){      //id here is doctorID
        return appointmentDao.findAllByDoctorId(id);
    }

    //GET APPOINTMENTS BY PATIENT ID
    @RequestMapping(value = "/patients/{id}" , method = RequestMethod.GET)
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Long id){      //id here is patientID
        return appointmentDao.findAllByPatientId(id);
    }




    //front end --> json with {doctorId, officeId...}
    //which endpoint to use for the newly created appointment
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "" , method = RequestMethod.POST)
    public boolean createAppointment(@Valid @RequestBody Appointment appointment){
       Appointment newAppointment = new Appointment();
       return appointmentDao.create(appointment);
    }

}
