package com.techelevator.controller;


import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.OfficeDao;
import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<Office> listAllOffices(){
        return officeDao.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Office getOfficeByOfficeId(@PathVariable Long id){
        return officeDao.getOfficeById(id);
    }
    //TODO get office by status (which offices are on delay)
    //TODO get office hours by office ID


    // http://localhost:8080/offices/3/doctors
    @RequestMapping(value = "/{id}/doctors")
    public List<Doctor> getAllDoctorsByOfficeId(@PathVariable Long id){
        return officeDao.findDoctorsByOfficeId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="", method = RequestMethod.POST)
    public boolean addOffice(@Valid @RequestBody Office office){
        boolean success = false;
        try{
            officeDao.create(office);
            success = true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return success;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public boolean updateOffice(@Valid @RequestBody Office office, @PathVariable Long id){
        boolean success = false;
        try{
            officeDao.update(office, id);
            success = true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return success;
    }

//    @ResponseStatus(HttpStatus.ACCEPTED)
//    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
//    public boolean updateDelayStatus(@Valid @PathVariable Long id, @RequestParam boolean delayStatus){
//        boolean success = false;
//        try{
//            officeDao.updateStatus(id, delayStatus);
//            success = true;
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        return success;
//    }



}
