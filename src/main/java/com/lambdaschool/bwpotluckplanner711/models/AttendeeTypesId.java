package com.lambdaschool.bwpotluckplanner711.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AttendeeTypesId implements Serializable
{
    private long attendee;
    private long type;

    public AttendeeTypesId()
    {
    }

    public long getAttendee()
    {
        return attendee;
    }

    public void setAttendee(long attendee)
    {
        this.attendee = attendee;
    }

    public long getType()
    {
        return type;
    }

    public void setType(long type)
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
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        AttendeeTypesId that = (AttendeeTypesId) o;
        return attendee == that.attendee &&
                type == that.type;
    }

    @Override
    public int hashCode()
    {
//        return Objects.hash(attendee,
//                type);
        return 37;
    }
}
