package com.techelevator.dao;

import com.techelevator.model.Availability;

import java.util.List;

public class JdbcAvailabilityDao implements AvailabilityDao {


    @Override
    public List<Availability> getAvailabilityByDoctorId(Long doctorId) {
        return null;
    }

    @Override
    public boolean create(Availability newAvailability) {
        return false;
    }

    @Override
    public boolean update(Availability availability, Long availId) {
        return false;
    }



}