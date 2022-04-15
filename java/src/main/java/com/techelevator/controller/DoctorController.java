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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Doctor> listAllDoctors(Principal principal){
        return doctorDao.findAll();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value ="", method = RequestMethod.POST)
    public boolean addDoctor(@Valid @RequestBody Doctor doctor) {
       boolean success = false;
        try {
            doctorDao.create(doctor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            success = doctorDao.updateIsDoctor(doctor.getUserTypeId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return success;
    }




}
