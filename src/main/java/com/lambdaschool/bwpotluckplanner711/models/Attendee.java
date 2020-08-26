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

    @OneToMany(mappedBy = "attendee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "attendee", allowSetters = true)
    private Set<AttendeeTypes> types = new HashSet<>();

    private boolean isgoing;

    @ManyToOne
    @JoinColumn(name = "potluckid", nullable = false)
    @JsonIgnoreProperties(value = "attendees", allowSetters = true)
    private Potluck potluck;

    public Attendee()
    {
    }

    public Attendee(String fname,
                    String lname,
                    boolean isgoing)
    {
        this.fname = fname;
        this.lname = lname;
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

    public Set<AttendeeTypes> getTypes()
    {
        return types;
    }

    public void setTypes(Set<AttendeeTypes> types)
    {
        this.types = types;
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