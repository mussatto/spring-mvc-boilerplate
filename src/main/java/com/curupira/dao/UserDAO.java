package com.curupira.dao;


import com.curupira.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.setEntityManager(em);
    }

    public EntityManager getEntityManager() {
        return em;
    }


}
