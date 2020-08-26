package com.lambdaschool.bwpotluckplanner711.models;

import javax.persistence.*;

@Entity
@Table(name = "types")
public class Type extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long typeid;

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
}
