package com.techelevator.model;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;


public class Appointment {

    private Long appointmentId;
    private Long doctorId;
    private Long patientId;
    private Long officeId;
    private Long availId;
    private Date appointmentDate;
    private String appointmentStatus;
    private String description;


    //GETTERS
    public Long getAppointmentId() {
        return appointmentId;
    }
    public Long getDoctorId() {
        return doctorId;
    }
    public Long getPatientId() {
       return patientId;
    }
    public Long getOfficeId() {
        return officeId;
    }
    public Long getAvailId() {
        return availId;
    }
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    public String getAppointmentStatus() {
        return appointmentStatus;
    }
    public String getDescription() {
        return description;
    }


    //SETTERS
    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }
    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }
    public void setAvailId(Long availId) {
        this.availId = availId;
    }
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    //CONSTRUCTOR
    public Appointment(){};

}
