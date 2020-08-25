package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.models.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();

    User save(User user);

    public void deleteAll();
}