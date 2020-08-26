package com.lambdaschool.bwpotluckplanner711.service;

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

    @Transactional
    @Override
    public void deleteAll()
    {
        itemRepos.deleteAll();
    }
}
