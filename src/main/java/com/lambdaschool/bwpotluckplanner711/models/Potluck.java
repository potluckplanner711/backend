package com.lambdaschool.bwpotluckplanner711.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "potlucks")
public class Potluck extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long potluckid;
    private String title;
    private String date;
    private String time;
    private String address;
    private String city;
    private String state;
    private int zip;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = "potlucks", allowSetters = true)
    private User user;

    @OneToMany(mappedBy = "potluck", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "potluck", allowSetters = true)
    private List<Attendee> attendees = new ArrayList<>();

    @OneToMany(mappedBy = "potluck", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "potluck", allowSetters = true)
    private List<Item> items = new ArrayList<>();

    public Potluck()
    {
    }

    public Potluck(User user,
                   String title,
                   String date,
                   String time,
                   String address,
                   String city,
                   String state,
                   int zip)
    {
        this.user = user;
        this.title = title;
        this.date = date;
        this.time = time;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public long getPotluckid()
    {
        return potluckid;
    }

    public void setPotluckid(long potluckid)
    {
        this.potluckid = potluckid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public int getZip()
    {
        return zip;
    }

    public void setZip(int zip)
    {
        this.zip = zip;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public List<Attendee> getAttendees()
    {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees)
    {
        this.attendees = attendees;
    }

    public List<Item> getItems()
    {
        return items;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
    }
}
