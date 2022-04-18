package com.techelevator.model;

import java.time.LocalDate;
import java.util.Date;

public class Review {

    private Long reviewId;
    private String patientFirstName;
    private String patientLastName;
    private String officeName;
    private String doctorFirstName;
    private String doctorLastName;

    private Long doctorId;
    private Long patientId;
    private Long officeId;
    private Date appointmentDate;
    private Date reviewDate;
    private String reviewDesc;
    private Long reviewRating;
    private String doctorReply;

    // GETTERS

    public Long getDoctorId() {
        return doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }
    public Long getReviewId() {
        return reviewId;
    }
    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public Long getReviewRating() {
        return reviewRating;
    }

    public String getDoctorReply() {
        return doctorReply;
    }



    // SETTERS




    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }

    public void setReviewRating(Long reviewRating) {
        this.reviewRating = reviewRating;
    }

    public void setDoctorReply(String doctorReply) {
        this.doctorReply = doctorReply;
    }

    //CONSTRUCTOR
    public Review(){};


}
