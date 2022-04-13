package com.techelevator.controller;

import com.techelevator.dao.DoctorDao;
import com.techelevator.model.Doctor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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






}
