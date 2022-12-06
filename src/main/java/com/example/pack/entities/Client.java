package com.example.pack.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "client")
public class Client extends Person{
    @OneToMany
    @JoinColumn(name = "clientId",referencedColumnName = "id")
    private Collection<Orders> orders;
    public Integer getId()
    {
        return this.id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getFullName()
    {
        return this.fullName;
    }
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getPassward()
    {
        return this.passward;
    }
    public void setPassward(String passward)
    {
        this.passward = passward;
    }
}
