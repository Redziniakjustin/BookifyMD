package com.techelevator.model;

import java.time.LocalDate;

public class Review {

    private Long reviewId;
    private Long appointmentId;
    private LocalDate reviewDate;
    private String reviewDesc;
    private int reviewRating;

    // GETTERS
    public Long getReviewId() {
        return reviewId;
    }
    public Long getAppointmentId() {
        return appointmentId;
    }
    public LocalDate getReviewDate() {
        return reviewDate;
    }
    public String getReviewDesc() {
        return reviewDesc;
    }
    public int getReviewRating() {
        return reviewRating;
    }

    // SETTERS
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }
    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }
    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }
    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }

    //CONSTRUCTOR
    public Review(){};


}
