package com.techelevator.model;

import java.sql.Time;

public class Office {

    private Long officeId;
    private String officeName;
    private String streetAddress;
    private String city;
    private String stateName;
    private String zip;
    private String phone;
    private String email;
    private Time officeHoursStart;
    private Time officeHoursEnd;
    private boolean delayStatus;


    // GETTERS
    public Long getOfficeId() {
        return officeId;
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
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public Time getOfficeHoursStart() {
        return officeHoursStart;
    }
    public Time getOfficeHoursEnd() {
        return officeHoursEnd;
    }
    public boolean isDelayStatus() {
        return delayStatus;
    }

    // SETTERS
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
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
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setOfficeHoursStart(Time officeHoursStart) {
        this.officeHoursStart = officeHoursStart;
    }
    public void setOfficeHoursEnd(Time officeHoursEnd) {
        this.officeHoursEnd = officeHoursEnd;
    }
    public void setDelayStatus(boolean delayStatus) {
        this.delayStatus = delayStatus;
    }

    //CONSTRUCTOR
    public Office(){};


}
