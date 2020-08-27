package com.lambdaschool.bwpotluckplanner711.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "attendees")
public class Attendee extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long attendeeid;
    private String fname;
    private String lname;

    @ManyToOne
    @JoinColumn(name = "typeid", nullable = false)
    @JsonIgnoreProperties(value = "attendees", allowSetters = true)
    private Type type;

    private boolean isgoing;

    @ManyToOne
    @JoinColumn(name = "potluckid", nullable = false)
    @JsonIgnoreProperties(value = "attendees", allowSetters = true)
    private Potluck potluck;

    public Attendee()
    {
    }

    public Attendee(Potluck potluck,
                    String fname,
                    String lname,
                    Type type,
                    boolean isgoing)
    {
        this.potluck = potluck;
        this.fname = fname;
        this.lname = lname;
        this.type = type;
        this.isgoing = isgoing;
    }

    public long getAttendeeid()
    {
        return attendeeid;
    }

    public void setAttendeeid(long attendeeid)
    {
        this.attendeeid = attendeeid;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public boolean isIsgoing()
    {
        return isgoing;
    }

    public void setIsgoing(boolean isgoing)
    {
        this.isgoing = isgoing;
    }

    public Potluck getPotluck()
    {
        return potluck;
    }

    public void setPotluck(Potluck potluck)
    {
        this.potluck = potluck;
    }
}