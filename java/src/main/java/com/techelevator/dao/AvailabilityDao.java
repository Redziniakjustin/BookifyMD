package com.techelevator.dao;

import com.techelevator.model.Availability;

import java.util.List;

public interface AvailabilityDao {

    //TODO availabilityByDay

    //availabilityByDoctor
    List<Availability> getAvailabilityByDoctorId (Long doctorId);

    //TODO availabilityByOffice



    //create availability
    boolean create (Availability newAvailability);

    //update availability
    boolean update (Availability availability, Long availId);
}
