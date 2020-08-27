package com.lambdaschool.bwpotluckplanner711.controllers;

import com.lambdaschool.bwpotluckplanner711.models.*;
import com.lambdaschool.bwpotluckplanner711.service.*;
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

    @Autowired
    private UserService userService;

    @Autowired
    private AttendeeService attendeeService;

    @Autowired
    private TypeService typeService;

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

    @PostMapping(value = "/potluck/{potluckid}/attendee/{userid}")
    public ResponseEntity<?> addNewAttendee(@PathVariable long potluckid, @PathVariable long userid, @RequestBody long typeid)
            throws URISyntaxException
    {
        User currentUser = userService.findByUserId(userid);

        Type userType = typeService.findTypeById(typeid);

        Attendee newAttendee = attendeeService.save(potluckid, currentUser.getFname(), currentUser.getLname(), userType, true);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAtteneeURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{attendeeid}")
                .buildAndExpand(newAttendee.getAttendeeid())
                .toUri();
        responseHeaders.setLocation(newAtteneeURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/potluck/{potluckid}", consumes = "application/json")
    public ResponseEntity<?> updatePotluck(@PathVariable long potluckid, @RequestBody Potluck updatepotluck)
    {
        potluckService.updatePotluck(updatepotluck, potluckid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
