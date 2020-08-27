package com.lambdaschool.bwpotluckplanner711.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "types")
public class Type extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long typeid;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "type", allowSetters = true)
    private List<Attendee> attendees = new ArrayList<>();

    private String name;

    public Type()
    {
    }

    public Type(String name)
    {
        this.name = name;
    }

    public long getTypeid()
    {
        return typeid;
    }

    public void setTypeid(long typeid)
    {
        this.typeid = typeid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Attendee> getAttendees()
    {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees)
    {
        this.attendees = attendees;
    }
}
