package com.example.pack.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "chauffeur")
public class Chauffeur extends Person implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idVehicle", referencedColumnName = "id")
    private Vehicle vehicle;
    @OneToMany
    @JoinColumn(name = "chauffeurId",referencedColumnName = "id")
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Collection<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Orders> orders) {
        this.orders = orders;
    }
}
