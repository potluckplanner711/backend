package com.lambdaschool.bwpotluckplanner.services;

import com.lambdaschool.bwpotluckplanner.models.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();

    User save(User user);
}
