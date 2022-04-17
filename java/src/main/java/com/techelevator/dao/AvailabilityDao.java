package com.techelevator.dao;

import com.techelevator.model.Availability;

import java.util.List;

public interface AvailabilityDao {

    //TODO availabilityByDay

    //availabilityByDoctor
    List<Availability> findAvailabilityByDoctorId (Long doctorId);

    //TODO availabilityByOffice

    List<Availability> findAllAvailabilityByOfficeId(Long officeId);

    List<Availability> findAvailabilityByIsAvailable(Long officeId);


    //create availability
    boolean create (Availability newAvailability);

    //update availability
    boolean update (Availability availability, Long availId);

    boolean isAvailableFalse(Long availId);

    boolean updateAvailabilityByDoctorId(boolean isAvailable, Long doctorId, Long availId);
}
