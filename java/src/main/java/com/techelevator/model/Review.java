package com.techelevator.model;

import java.time.LocalDate;

public class Review {

    private int reviewId;
    private int patientId;
    private int officeId;
    private int doctorId;
    private LocalDate reviewDate;
    private String reviewDesc;
    private int reviewRating;

    // GETTERS
    public int getReviewId() {
        return reviewId;
    }
    public int getPatientId() {
        return patientId;
    }
    public int getOfficeId() {
        return officeId;
    }
    public int getDoctorId() {
        return doctorId;
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
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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
