package com.techelevator.dao;


import com.techelevator.model.Review;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

public class JdbcReviewDao implements ReviewDao{
    @Override
    public List<Review> findAll() {
        return null;
    }

    @Override
    public Review getReviewById(Long reviewId) {
        return null;
    }

    @Override
    public Review findReviewByOfficeId(Long officeId) {
        return null;
    }

    @Override
    public int findReviewIdByOfficeId(Long officeId) {
        return 0;
    }

    @Override
    public int findReviewIdByPatientId(Long patientId) {
        return 0;
    }
}
