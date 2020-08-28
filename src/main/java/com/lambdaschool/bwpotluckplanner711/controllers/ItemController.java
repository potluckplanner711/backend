package com.lambdaschool.bwpotluckplanner711.controllers;

import com.lambdaschool.bwpotluckplanner711.models.Item;
import com.lambdaschool.bwpotluckplanner711.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController
{
    @Autowired
    private ItemService itemService;

    @PutMapping(value = "/{itemid}/claim")
    public ResponseEntity<?> claimItem(@PathVariable long itemid)
    {
        Item currentItem = itemService.findItemById(itemid);

        currentItem.setItemid(itemid);
        itemService.updateItem(currentItem, currentItem.getItemid());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
