package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.exceptions.ResourceNotFoundException;
import com.lambdaschool.bwpotluckplanner711.models.Attendee;
import com.lambdaschool.bwpotluckplanner711.models.Potluck;
import com.lambdaschool.bwpotluckplanner711.models.Type;
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

    @Autowired
    private TypeService typeService;

    @Autowired PotluckService potluckService;

    @Autowired
    private HelperFunctions helperFunctions;

    @Transactional
    @Override
    public Attendee save(long potluckid,
                         String fname,
                         String lname,
                         Type type,
                         boolean isgoing)
    {
        Potluck currentPotluck = potluckService.findPotluckById(potluckid);

        if ( helperFunctions.isAuthorizedToMakeChange(currentPotluck.getUser().getUsername()))
        {
            Attendee newAttendee = new Attendee(currentPotluck, fname, lname, type, isgoing);

            return attendeeRepos.save(newAttendee);
        } else
        {
            throw new ResourceNotFoundException("This user is not authorized to make a change");
        }
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        attendeeRepos.deleteAll();
    }
}
