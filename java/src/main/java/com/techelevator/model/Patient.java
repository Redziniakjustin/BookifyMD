package com.techelevator.model;

public class Patient {

    private Long patientId;
    private Long userTypeId;
    private String firstName;
    private String lastName;
    private String phone;
    private String streetAddress;
    private String city;
    private String stateName;
    private String zip;
    private String email;


    // GETTERS
    public Long getPatientId() {
        return patientId;
    }
    public Long getUserTypeId() {
        return userTypeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
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

    //SETTERS
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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

    //CONSTRUCTOR
    public Patient (){};

}
