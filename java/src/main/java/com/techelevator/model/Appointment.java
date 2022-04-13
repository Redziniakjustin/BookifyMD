package com.techelevator.model;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class Appointment {

    @NotNull
    private int appointmentId;
    @NotNull
    private int doctorId;
    @NotNull
    private int patientId;
    @NotNull
    private int officeId;
    private LocalDate appointmentDate;
    private String appointmentStatus;
    @NotNull
    private String description;
    private String reasonSelected;

    //GETTERS
    public int getAppointmentId() {
        return appointmentId;
    }
    public int getDoctorId() {
        return doctorId;
    }
    public int getPatientId() {
        return patientId;
    }
    public int getOfficeId() {
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
    public String getReasonSelected() {
        return reasonSelected;
    }

    //SETTERS
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public void setOfficeId(int officeId) {
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
    public void setReasonSelected(String reasonSelected) {
        this.reasonSelected = reasonSelected;
    }

    //CONSTRUCTOR
    public Appointment(){};

}
