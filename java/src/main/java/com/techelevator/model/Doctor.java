package com.techelevator.model;

public class Doctor {
    private Long doctorId;
    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private int costHourly;

    //GETTERS
    public Long getDoctorId() {
        return doctorId;
    }
    public Long getUserId() {
        return userId;
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
    public String getEmail() {
        return email;
    }
    public int getCostHourly() {
        return costHourly;
    }

    //SETTERS
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
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
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCostHourly(int costHourly) {
        this.costHourly = costHourly;
    }

    //CONSTRUCTOR
    public Doctor(){};

}
