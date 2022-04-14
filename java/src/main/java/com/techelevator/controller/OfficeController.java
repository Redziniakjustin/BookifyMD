package com.techelevator.controller;


import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.OfficeDao;
import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/offices")

public class OfficeController {

    private OfficeDao officeDao;


    public OfficeController(OfficeDao officeDao){
        this.officeDao = officeDao;

    }


    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Office> listAllOffices(Principal principal){
        return officeDao.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Office getOfficeByOfficeId(@PathVariable Long id){
        return officeDao.getOfficeById(id);
    }

    // http://localhost:8080/offices/3/doctors
    @RequestMapping(value = "/{id}/doctors")
    public List<Doctor> getAllDoctorsByOfficeId(@PathVariable Long id){
        return officeDao.findDoctorsByOfficeId(id);
    }


    //update office info


}
