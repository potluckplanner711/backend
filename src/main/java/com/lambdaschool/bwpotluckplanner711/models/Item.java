package com.lambdaschool.bwpotluckplanner711.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemid;
    private String itemname;
    private boolean claimed;

    @ManyToOne
    @JoinColumn(name = "potluckid", nullable = false)
    @JsonIgnoreProperties(value = "items", allowSetters = true)
    private Potluck potluck;

    public Item()
    {
    }

    public Item(Potluck potluck,
                String itemname,
                boolean claimed)
    {
        this.potluck = potluck;
        this.itemname = itemname;
        this.claimed = claimed;
    }

    public long getItemid()
    {
        return itemid;
    }

    public void setItemid(long itemid)
    {
        this.itemid = itemid;
    }

    public String getItemname()
    {
        return itemname;
    }

    public void setItemname(String itemname)
    {
        this.itemname = itemname;
    }

    public boolean isClaimed()
    {
        return claimed;
    }

    public void setClaimed(boolean claimed)
    {
        this.claimed = claimed;
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
