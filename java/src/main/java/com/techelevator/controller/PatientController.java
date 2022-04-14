package com.techelevator.controller;

import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.PatientDao;
import com.techelevator.model.Doctor;
import com.techelevator.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Patient getPatientByPatientId(@PathVariable Long id, Principal principal){
        return patientDao.getPatientById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addPatient (@Valid @RequestBody Patient patient){
        return patientDao.create(patient);
    }


}
