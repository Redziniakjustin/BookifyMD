package com.techelevator.dao;

import com.techelevator.model.User;
import com.techelevator.model.UserType;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(Long userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    Long getUserIdByUsername(String username);

    boolean create(String username, String password, String role);

    //automatically done
    Long addToUserType(Long userId, boolean isDoctor);


    //FIND USER_TYPE BY USERNAME
    UserType findUserTypeByUsername(String username);






}
