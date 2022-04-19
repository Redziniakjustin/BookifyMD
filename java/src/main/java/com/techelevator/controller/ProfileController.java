package com.techelevator.controller;

import com.techelevator.dao.AvailabilityDao;
import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.PatientDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
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
    @RequestMapping(value = "/patients/{id}")
    public Patient getPatientProfileByUserId(@PathVariable Long id){
        return patientDao.findPatientByUserId(id);

    }

    //localhost:8080/profiles/patients/{id}
    //GET DOCTOR PROFILE
    @RequestMapping (value = "/doctors/{id}")
    public Doctor getDoctorProfileByUserId(@PathVariable Long id){      //id here is userId

        return doctorDao.findDoctorByUserId(id);

    }

    //localhost:8080/profiles/{id}
    //GET is_doctor by userId
    @RequestMapping (value = "/{id}")
    public UserType getIsDoctor(@PathVariable Long id){      //id here is userId

        return userDao.findUserTypeByUserid(id);

    }

}
