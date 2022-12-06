package com.example.pack.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Function;

public class DbConfig {
    private static DbConfig instance;

    private EntityManagerFactory entityManagerFactory;

    private DbConfig(){
        entityManagerFactory = Persistence.createEntityManagerFactory("my_pack");
    }

    public static synchronized DbConfig getInstance(){
        return instance == null ? instance = new DbConfig() : instance;
    }

    public void shutdown(){
        if(entityManagerFactory != null)
            entityManagerFactory.close();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public <T> T runInTransaction(Function<EntityManager,T> function){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        boolean success=false;
        transaction.begin();
        try{
            T returnValue = function.apply(entityManager);
            success = true;
            return returnValue;
        }finally {
            if(success){
                transaction.commit();
            }else{
                transaction.rollback();
            }
        }
    }

}
