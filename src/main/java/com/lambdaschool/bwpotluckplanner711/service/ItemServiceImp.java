package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.exceptions.ResourceNotFoundException;
import com.lambdaschool.bwpotluckplanner711.models.Item;
import com.lambdaschool.bwpotluckplanner711.models.Potluck;
import com.lambdaschool.bwpotluckplanner711.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "itemservice")
public class ItemServiceImp implements ItemService
{
    @Autowired
    private ItemRepository itemRepos;

    @Autowired
    private PotluckService potluckService;

    @Autowired
    private HelperFunctions helperFunctions;

    @Override
    public Item save(long potluckid,
                     String item,
                     boolean claimed)
    {
        Potluck currentPotluck = potluckService.findPotluckById(potluckid);

        if (helperFunctions.isAuthorizedToMakeChange(currentPotluck.getUser().getUsername()))
        {
            Item newItem = new Item(currentPotluck, item, claimed);
            return itemRepos.save(newItem);
        } else
        {
            throw new ResourceNotFoundException("This user is not authorized to make change");
        }
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        itemRepos.deleteAll();
    }
}
