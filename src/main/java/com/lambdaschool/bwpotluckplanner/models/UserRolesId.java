package com.lambdaschool.bwpotluckplanner.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserRolesId implements Serializable
{
    private long user;
    private long role;

    public UserRolesId()
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

    public long getRole()
    {
        return role;
    }

    public void setRole(long role)
    {
        this.role = role;
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
        UserRolesId that = (UserRolesId) o;
        return user == that.user &&
                role == that.role;
    }

    @Override
    public int hashCode()
    {
//        return Objects.hash(user,
//                role);
        return 37;
    }
}