package com.techelevator.controller;

import com.techelevator.dao.AvailabilityDao;
import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.PatientDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Availability;
import com.techelevator.model.Doctor;
import com.techelevator.model.Patient;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/profiles")


public class ProfileController {

    private UserDao userDao;
    private DoctorDao doctorDao;
    private PatientDao patientDao;

    public ProfileController(UserDao userDao, DoctorDao doctorDao, PatientDao patientDao){
        this.userDao = userDao;
        this.doctorDao = doctorDao;
        this.patientDao = patientDao;
    }




    //GET PATIENT PROFILE

    //localhost:8080/profiles/patients/{id}
    @RequestMapping(value = "/patients/{username}")
    public Patient getPatientProfile(@PathVariable Long id){
        User user = userDao.getUserById(id);
        return patientDao.findPatientByUsername(user.getUsername());

    }

    //localhost:8080/profiles/patients/{id}
    //GET DOCTOR PROFILE
    @RequestMapping (value = "/doctors/{id}")
    public Doctor getDoctorProfile(@PathVariable Long id){      //id here is userId
        User user = userDao.getUserById(id);
        return doctorDao.findDoctorByUsername(user.getUsername());


    }









}
