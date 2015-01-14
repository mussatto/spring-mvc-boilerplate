package com.curupira.services;

import com.curupira.dao.RoleDAO;
import com.curupira.dao.UserDAO;
import com.curupira.model.Role;
import com.curupira.model.RoleName;
import com.curupira.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void createUser(String email, String username, String password, List<RoleName> roles){
        User user = findByUsername(username);
        if(user==null){
            user = User.createUser(email, username, password);

            user = userDAO.saveOrUpdate(user);
            for(RoleName roleName: roles){
                addRoleToUser(user, roleName);
            }
        }
    }



    public void addRoleToUser(User user, RoleName roleName){
        Role role = roleDAO.findByName(roleName.toString());
        if(user.getRoles()==null)
            user.setRoles(new ArrayList<Role>());
        user.getRoles().add(role);
        userDAO.saveOrUpdate(user);

    }

    public User findByUsername(String username){
        return userDAO.findByUsernameWithRoles(username);
    }

    public List<User> listAll(int page){
        return userDAO.listAll(page);
    }



}
