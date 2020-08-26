package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.repositories.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "attendeeservice")
public class AttendeeServiceImp implements AttendeeService
{
    @Autowired
    private AttendeeRepository attendeeRepos;

    @Transactional
    @Override
    public void deleteAll()
    {
        attendeeRepos.deleteAll();
    }
}
