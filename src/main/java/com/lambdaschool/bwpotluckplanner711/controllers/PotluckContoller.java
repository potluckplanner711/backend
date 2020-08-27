package com.lambdaschool.bwpotluckplanner711.controllers;

import com.lambdaschool.bwpotluckplanner711.models.Item;
import com.lambdaschool.bwpotluckplanner711.models.Potluck;
import com.lambdaschool.bwpotluckplanner711.service.ItemService;
import com.lambdaschool.bwpotluckplanner711.service.PotluckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/potlucks")
public class PotluckContoller
{
    @Autowired
    private PotluckService potluckService;

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/potlucks", produces = "application/json")
    public ResponseEntity<?> listAllPotlucks()
    {
        List<Potluck> potlucks = potluckService.findAll();
        return new ResponseEntity<>(potlucks, HttpStatus.OK);
    }

    @PostMapping(value = "/users/{userid}/potluck")
    public ResponseEntity<?> addNewPotluck(@PathVariable long userid, @RequestBody Potluck potluck)
            throws URISyntaxException
    {
        potluck.setPotluckid(0);
        potluck = potluckService.save(userid, potluck.getTitle(), potluck.getDate(), potluck.getTime(), potluck.getAddress(), potluck.getCity(), potluck.getState(), potluck.getZip());

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPotluckURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(potluck.getPotluckid())
                .toUri();
        responseHeaders.setLocation(newPotluckURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PostMapping(value = "/potluck/{potluckid}/items")
    public ResponseEntity<?> addNewItem(@PathVariable long potluckid, @RequestBody Item item)
        throws URISyntaxException
    {
        Item newItem = itemService.save(potluckid, item.getItemname(), false);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newItemURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{itemid}")
                .buildAndExpand(newItem.getItemid())
                .toUri();
        responseHeaders.setLocation(newItemURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
