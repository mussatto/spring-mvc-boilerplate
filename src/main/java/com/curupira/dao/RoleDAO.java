package com.curupira.dao;

import com.curupira.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class RoleDAO{

    @PersistenceContext
    private EntityManager em;


    public void setEntityManager(EntityManager em) {
        this.em=em;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public Role saveOrUpdate(Role model){
        if(model.getId()==null){
            getEntityManager().persist(model);
            return model;
        }
        else{
            return getEntityManager().merge(model);
        }
    }

    public void delete(Role model){

        getEntityManager().remove(model);
    }

    public Role find(Long id) {
        return getEntityManager().find(Role.class,id);
    }

    public Role findByName(String roleName){
        Query query = getEntityManager().createQuery("select role from Role role where role.roleName=?");
        query.setParameter(1,roleName);
        Role role = (Role) query.getSingleResult();

        return role;
    }
}
