package com.lambdaschool.bwpotluckplanner711.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "attendeetypes")
@IdClass(AttendeeTypesId.class)
public class AttendeeTypes extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "attendeeid")
    @JsonIgnoreProperties(value = "types", allowSetters = true)
    private Attendee attendee;

    @Id
    @ManyToOne
    @JoinColumn(name = "typeid")
    @JsonIgnoreProperties(value = "attendees", allowSetters = true)
    private Type type;

    public AttendeeTypes()
    {
    }

    public AttendeeTypes(Attendee attendee,
                         Type type)
    {
        this.attendee = attendee;
        this.type = type;
    }

    public Attendee getAttendee()
    {
        return attendee;
    }

    public void setAttendee(Attendee attendee)
    {
        this.attendee = attendee;
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof AttendeeTypes))
        {
            return false;
        }
        AttendeeTypes that = (AttendeeTypes) o;
        return ((attendee == null) ? 0 : attendee.getAttendeeid()) == ((that.attendee == null) ? 0 : that.attendee.getAttendeeid()) &&
                ((type == null) ? 0 : type.getTypeid()) == ((that.type == null) ? 0 : that.type.getTypeid());
    }

    @Override
    public int hashCode()
    {
//        return Objects.hash(attendee,
//                type);
        return 37;
    }
}
