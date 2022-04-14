package com.techelevator.controller;

import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.PatientDao;
import com.techelevator.model.Doctor;
import com.techelevator.model.Patient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.security.Principal;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/patients")
public class PatientController {

    private PatientDao patientDao;

    public PatientController ( PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    //return patient object given patient id
    //LEARN ABOUT PRICIPAL
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Patient getPatientByPatientId(@PathVariable Long id, Principal principal){
        return patientDao.getPatientById(id);
    }


}
