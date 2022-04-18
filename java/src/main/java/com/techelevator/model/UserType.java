package com.techelevator.model;

public class UserType {

    private Long userTypeId;

    private Long userId;

    private boolean isDoctor;

    public Long getUserTypeId() {
        return userTypeId;
    }

    public boolean getIsDoctor() {
        return isDoctor;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }



    public void setIsDoctor(boolean doctor) {
        isDoctor = doctor;
    }
}
