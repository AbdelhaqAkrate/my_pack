package com.example.pack.controller;


import com.example.pack.config.DbConfig;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;

@Named("handler")
@RequestScoped
public class ServletHandler {
    public void initFC() {
        DbConfig dbConfig =  DbConfig.getInstance();
        EntityManager em = dbConfig.getEntityManagerFactory().createEntityManager();
        em.close();
        dbConfig.getEntityManagerFactory().close();
        System.out.println("hello");
    }
}
