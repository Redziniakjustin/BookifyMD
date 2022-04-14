package com.techelevator.model;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class Appointment {

    @NotNull
    private Long appointmentId;
    @NotNull
    private Long doctorId;
    @NotNull
    private Long patientId;
    @NotNull
    private Long officeId;
    private LocalDate appointmentDate;
    private String appointmentStatus;
    @NotNull
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
    public LocalDate getAppointmentDate() {
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
    public void setAppointmentDate(LocalDate appointmentDate) {
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
