package com.lambdaschool.bwpotluckplanner.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserTypesId implements Serializable
{
    private long user;
    private long type;

    public UserTypesId()
    {
    }

    public long getUser()
    {
        return user;
    }

    public void setUser(long user)
    {
        this.user = user;
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
        UserTypesId that = (UserTypesId) o;
        return user == that.user &&
                type == that.type;
    }

    @Override
    public int hashCode()
    {
//        return Objects.hash(user,
//                role);
        return 37;
    }
}
