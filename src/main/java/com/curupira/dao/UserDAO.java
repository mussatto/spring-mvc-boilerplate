package com.curupira.dao;


import com.curupira.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public User saveOrUpdate(User model){
        if(model.getId()==null){
            getEntityManager().persist(model);
            return model;
        }
        else{
            return getEntityManager().merge(model);
        }
    }


}
