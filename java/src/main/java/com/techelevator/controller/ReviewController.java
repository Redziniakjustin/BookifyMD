package com.techelevator.controller;


import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.OfficeDao;

import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import com.techelevator.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.method.P;
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

    @RequestMapping(value = "/doctors/{doctorId}", method = RequestMethod.GET)
    public List<Review> getReviewsByDoctorId(@PathVariable Long doctorId){
        return reviewDao.findReviewsByDoctorId(doctorId);
    }

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
    ///reviews/{id} to reply to review
    //UPDATE REVIEWS BY reviewId
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value ="/{id}", method = RequestMethod.PUT)
    public boolean replyToReviewByDoctor(@Valid @RequestBody String doctorReply, @PathVariable Long id){
        boolean success = false;
        try{
            reviewDao.update(doctorReply, id);
            success = true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return success;
    }

}
