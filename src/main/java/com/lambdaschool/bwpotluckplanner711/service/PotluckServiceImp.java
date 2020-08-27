package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.exceptions.ResourceNotFoundException;
import com.lambdaschool.bwpotluckplanner711.models.Attendee;
import com.lambdaschool.bwpotluckplanner711.models.Item;
import com.lambdaschool.bwpotluckplanner711.models.Potluck;
import com.lambdaschool.bwpotluckplanner711.models.User;
import com.lambdaschool.bwpotluckplanner711.repositories.PotluckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "potluckservice")
public class PotluckServiceImp implements PotluckService
{
    @Autowired
    private PotluckRepository potluckRepos;

    @Autowired
    private UserService userService;

    @Autowired
    private HelperFunctions helperFunctions;

    @Override
    public List<Potluck> findAll()
    {
        List<Potluck> list = new ArrayList<>();
        potluckRepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Potluck findPotluckById(long id)
    {
        return potluckRepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Potluck id " + id + " not found!"));
    }

    @Override
    public Potluck save(long userid,
                        String title,
                        String date,
                        String time,
                        String address,
                        String city,
                        String state,
                        int zip)
    {
        User currentUser = userService.findByUserId(userid);

        if (helperFunctions.isAuthorizedToMakeChange(currentUser.getUsername()))
        {
            Potluck newPotluck = new Potluck(currentUser, title, date, time, address, city, state, zip);

            newPotluck.getAttendees().clear();
            for (Attendee ae : newPotluck.getAttendees())
            {
                newPotluck.getAttendees().add(new Attendee(ae.getPotluck(), ae.getFname(), ae.getLname(), ae.getType(), ae.isIsgoing()));
            }

            newPotluck.getItems().clear();
            for (Item i : newPotluck.getItems())
            {
                newPotluck.getItems().add(new Item(i.getPotluck(), i.getItemname(), i.isClaimed()));
            }

            return potluckRepos.save(newPotluck);
        } else
        {
            throw  new ResourceNotFoundException("This user is not authorized to make a change");
        }
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        potluckRepos.deleteAll();
    }
}
