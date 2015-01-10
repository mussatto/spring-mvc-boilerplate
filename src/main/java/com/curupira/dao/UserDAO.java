package com.curupira.dao;

import com.curupira.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
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

    public User findByUsername(String username){
        User user=null;
        try{
        Query query = getEntityManager().createQuery("select user from User user where user.name=?");
        query.setParameter(1,username);
            user= (User) query.getSingleResult();
        }catch(NoResultException exception){
            return user;
        }
        return user;
    }


}
