package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(Long userId);

    Long getUserIdByUsername(String username);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);

    Long addToUserType(Long userId, boolean isDoctor);

    //method to getUserTypeIdByUsername
    Long getUserTypeIdByUsername (String username);



}
