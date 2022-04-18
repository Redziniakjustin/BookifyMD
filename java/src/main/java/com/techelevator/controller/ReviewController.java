package com.techelevator.controller;


import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.OfficeDao;

import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import com.techelevator.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/reviews")

public class ReviewController {

    ReviewDao reviewDao;

    public ReviewController(ReviewDao reviewDao){
        this.reviewDao = reviewDao;
    }


    //GET ALL REVIEWS BY OFFICE
    //localhost:8080/reviews/officeId

    //GET ALL REVIEWS BY DOCTOR
    //localhost:8080/reviews/doctorId

    //GET ALL REVIEWS BY PATIENT


    //CREATE REVIEWS

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean postNewReview (@Valid @RequestBody Review review){
        boolean isSuccessful = false;

        //run the create method
        isSuccessful = reviewDao.create(review);
        return isSuccessful;
    }

    //UPDATE REVIEWS BY


}
