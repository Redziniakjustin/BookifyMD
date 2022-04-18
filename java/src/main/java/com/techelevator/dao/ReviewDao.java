package com.techelevator.dao;

import com.techelevator.model.Patient;
import com.techelevator.model.Review;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ReviewDao {

    List<Review> findAll();

    Review getReviewById(Long reviewId);

    Review findReviewByOfficeId (Long officeId);

    int findReviewIdByOfficeId (Long officeId);

    int findReviewIdByPatientId (Long patientId);

    boolean create(Review newReview);

    boolean update(Review review);


    //other methods
    Long findDoctorIdByName(String firstName, String lastName);
    Long findPatientIdByName(String firstName, String lastName);
    Long findOfficeIdByName(String officeName);
}
