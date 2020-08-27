package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.models.Type;

public interface TypeService
{
    Type findTypeById(long id);

    Type save(Type type);

    Type findByName(String name);

    public void deleteAll();
}
