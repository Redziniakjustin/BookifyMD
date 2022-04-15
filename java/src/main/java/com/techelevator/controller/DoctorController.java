package com.techelevator.controller;

import com.techelevator.dao.DoctorDao;
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
    public DoctorController(DoctorDao doctorDao){
       this.doctorDao = doctorDao;
    }

    //GET ALL DOCTORS IN THE API
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Doctor> listAllDoctors(Principal principal){
        return doctorDao.findAll();
    }

    //GET AVAILABILITY BY DOCTOR ID

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

    

    //ADD DOCTOR TO OFFICE AFTER INITIAL OFFICE ADDED
    //


    //UPDATE DOCTOR PROFILE





    //UPDATE AVAILABILITY













}
