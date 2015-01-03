package com.curupira.services;

import com.curupira.dao.RoleDAO;
import com.curupira.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public void createDefaultRoles(){
        Role role = Role.create("ADMIN");
        roleDAO.saveOrUpdate(role);
        Role role2 = Role.create("USER");
        roleDAO.saveOrUpdate(role2);
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public Role getRole(String roleName){
        return roleDAO.findByName(roleName);
    }
}
