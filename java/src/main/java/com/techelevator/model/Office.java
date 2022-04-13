package com.techelevator.model;

public class Office {

    private int officeId;
    private int doctorId;
    private int availId;
    private String officeName;
    private String streetAddress;
    private String city;
    private String stateName;
    private String zip;
    private String email;
    private String officeHours;
    private boolean delayStatus;


    // GETTERS
    public int getOfficeId() {
        return officeId;
    }
    public int getDoctorId() {
        return doctorId;
    }
    public int getAvailId() {
        return availId;
    }
    public String getOfficeName() {
        return officeName;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public String getCity() {
        return city;
    }
    public String getStateName() {
        return stateName;
    }
    public String getZip() {
        return zip;
    }
    public String getEmail() {
        return email;
    }
    public String getOfficeHours() {
        return officeHours;
    }
    public boolean isDelayStatus() {
        return delayStatus;
    }

    // SETTERS
    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    public void setAvailId(int availId) {
        this.availId = availId;
    }
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
    public void setDelayStatus(boolean delayStatus) {
        this.delayStatus = delayStatus;
    }

    //CONSTRUCTOR
    public Office(){};


}
