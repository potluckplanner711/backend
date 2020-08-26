package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.models.Potluck;

import java.util.List;

public interface PotluckService
{
    List<Potluck> findAll();

    Potluck findPotluckById(long id);

    Potluck save(long userid, String title, String date, String time, String address, String city, String state, int zip);

    public void deleteAll();
}
