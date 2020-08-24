package com.lambdaschool.bwpotluckplanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "types")
public class Type
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long typeid;

    private String name;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "type", allowSetters = true)
    private Set<UserTypes> user = new HashSet<>();

    public Type()
    {
    }

    public Type(String name)
    {
        this.name = name.toUpperCase();
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

    public Set<UserTypes> getUser()
    {
        return user;
    }

    public void setUser(Set<UserTypes> user)
    {
        this.user = user;
    }
}
