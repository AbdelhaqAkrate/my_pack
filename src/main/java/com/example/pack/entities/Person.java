package com.example.pack.entities;

import jakarta.persistence.*;

@MappedSuperclass
    abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(name = "fullName",nullable = false)
    protected String fullName;
    @Column(name = "email",nullable = false)
    protected String email;
    @Column(name = "passward",nullable = false)
    protected String passward;


}
