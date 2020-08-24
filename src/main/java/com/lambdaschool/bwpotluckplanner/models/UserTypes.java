package com.lambdaschool.bwpotluckplanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usertypes")
@IdClass(UserTypesId.class)
public class UserTypes extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "types", allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "typeid")
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private Type type;

    public UserTypes()
    {
    }

    public UserTypes(User user,
                     Type type)
    {
        this.user = user;
        this.type = type;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
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
        if (!(o instanceof UserRoles))
        {
            return false;
        }
        UserTypes that = (UserTypes) o;
        return ((user == null) ? 0 : user.getUserid()) == ((that.user == null) ? 0 : that.user.getUserid()) &&
                ((type == null) ? 0 : type.getTypeid()) == ((that.type == null) ? 0 : that.type.getTypeid());
    }

    @Override
    public int hashCode()
    {
//        return Objects.hash(user,
//                type);
        return 37;
    }
}
