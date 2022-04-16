package com.techelevator.controller;

import com.techelevator.dao.AvailabilityDao;
import com.techelevator.dao.DoctorDao;
import com.techelevator.model.Availability;
import com.techelevator.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/doctors")
public class DoctorController {

    private DoctorDao doctorDao;
    private AvailabilityDao availabilityDao;

    public DoctorController(DoctorDao doctorDao, AvailabilityDao availabilityDao){

       this.doctorDao = doctorDao;
       this.availabilityDao = availabilityDao;
    }

    //GET ALL DOCTORS IN THE API
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Doctor> listAllDoctors(Principal principal){
        return doctorDao.findAll();
    }


    //GET AVAILABILITY BY DOCTOR ID
    //localhost:8080/doctors/id/availabilities
    @RequestMapping(value = "/{id}/availability", method = RequestMethod.GET)
    public List<Availability> getAvailabilityByDoctorId(@PathVariable Long id){     //id here is doctorId
        return availabilityDao.findAvailabilityByDoctorId(id);
    }

    //POST NEW DOCTOR
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value ="", method = RequestMethod.POST)
    //need to pass in an office_id which the doctor selects from a dropdown

    public boolean addDoctor(@Valid @RequestBody Doctor doctor) {
       boolean success = false;
       Long doctorId = null;
        try {
            doctorId = doctorDao.create(doctor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            success = doctorDao.updateIsDoctor(doctor.getUserTypeId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            doctorDao.addToDoctorOffice(doctorId, doctor.getOfficeId());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


        return success;
    }



    //TODO ADD DOCTOR TO OFFICE AFTER INITIAL OFFICE ADDED
    //


    //ADD DOCTOR'S INITIAL AVAILABILITY TO DOCTOR_OFFICE_AVAILABILITY
    //localhost:8080/doctors/availability/
    @RequestMapping(value = "/availability", method = RequestMethod.POST)
    public boolean addNewAvailability (@Valid @RequestBody Availability newAvailability){
        boolean isSuccessful = false;
        try {
            isSuccessful = availabilityDao.create(newAvailability);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return isSuccessful;
    }

    //TODO UPDATE DOCTOR PROFILE

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/availability/{availId}", method = RequestMethod.PUT)
    public boolean updateAvailability(@Valid @RequestBody Availability updateAvailability,@PathVariable Long availId) {
        boolean isSuccessful = false;
        try {
            availabilityDao.update(updateAvailability, availId);
            isSuccessful = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isSuccessful;
    }


    // ADD DEFAULT TIME WHEN ADDING

}
