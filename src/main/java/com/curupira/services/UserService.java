package com.curupira.services;

import com.curupira.dao.RoleDAO;
import com.curupira.dao.UserDAO;
import com.curupira.model.Role;
import com.curupira.model.RoleName;
import com.curupira.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private UserDAO userDAO;


    public void setRoleDAO(RoleDAO roleDAO){
        this.roleDAO=roleDAO;
    }

    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void createDefaultAdmin(){
        User user = User.createUser("admin@curupira.com","Admin");

        user = userDAO.saveOrUpdate(user);

        addRoleToUser(user, RoleName.ADMIN);
    }

    public void addRoleToUser(User user, RoleName roleName){
        Role role = roleDAO.findByName(roleName.toString());
        user.getRoles().add(role);
        userDAO.saveOrUpdate(user);

    }



}
