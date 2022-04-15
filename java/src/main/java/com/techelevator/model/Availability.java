package com.techelevator.model;

import java.sql.Time;

public class Availability {

    //PRIVATE MEMBERS
    private Long availId;
    private Long officeId;
    private Long doctorId;
    private String dayOfWeek;
    private Time startTime;
    private Time endTime;
    private boolean isAvailable;
    private String reasonOfUnavailability;

    //GETTERS
    public Long getAvailId() {
        return availId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getReasonOfUnavailability() {
        return reasonOfUnavailability;
    }


    //SETTERS
    public void setAvailId(Long availId) {
        this.availId = availId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setReasonOfUnavailability(String reasonOfUnavailability) {
        this.reasonOfUnavailability = reasonOfUnavailability;
    }

    //CONSTRUCTORS
    public Availability(){};
}
