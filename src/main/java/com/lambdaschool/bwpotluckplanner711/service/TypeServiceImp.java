package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "typeservice")
public class TypeServiceImp implements TypeService
{
    @Autowired
    private TypeRepository typeRepos;

    @Transactional

    @Override
    public void deleteAll()
    {
        typeRepos.deleteAll();
    }
}
