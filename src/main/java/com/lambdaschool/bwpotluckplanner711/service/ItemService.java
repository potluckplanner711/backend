package com.lambdaschool.bwpotluckplanner711.service;

import com.lambdaschool.bwpotluckplanner711.models.Item;

public interface ItemService
{
    Item save(long potluckid, String item, boolean claimed);

    public void deleteAll();
}
