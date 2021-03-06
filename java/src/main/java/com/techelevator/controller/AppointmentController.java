package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.AvailabilityDao;
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
    private AvailabilityDao availabilityDao;

    public AppointmentController(AppointmentDao appointmentDao, AvailabilityDao availabilityDao){
        this.appointmentDao = appointmentDao;
        this.availabilityDao = availabilityDao;
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
       Long availId = null;
       boolean isSuccessful = false;

       try{
           isSuccessful = appointmentDao.create(appointment);
           availId = appointment.getAvailId();
       } catch (Exception e){
           System.out.println(e.getMessage());
       }
       try{
           availabilityDao.isAvailableFalse(availId);
       } catch (Exception e){
           System.out.println(e.getMessage());
       }

       return isSuccessful;
    }

    // UPDATE APPOINTMENT STATUS
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/{id}/status", method = RequestMethod.PUT)
    public boolean updateAppointmentStatus(@Valid @RequestBody Appointment updateAppStatus, @PathVariable Long id){
        boolean success = false;
        try{
            appointmentDao.updateAppointmentStatus(updateAppStatus, id);
            success = true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return success;
    }


}
