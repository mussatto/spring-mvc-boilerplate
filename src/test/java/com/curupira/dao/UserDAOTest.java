package com.curupira.dao;

import com.curupira.SpringTest;
import com.curupira.model.Role;
import com.curupira.model.RoleName;
import com.curupira.model.User;
import com.curupira.services.RoleService;
import com.curupira.services.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserDAOTest extends SpringTest {
    private UserDAO userDAO;
    private UserService userService;
    private RoleService roleService;

    @Before
    public void setup(){
        userDAO= getApplicationContext().getBean(UserDAO.class);

        userService= getApplicationContext().getBean(UserService.class);
        roleService= getApplicationContext().getBean(RoleService.class);

        roleService.createDefaultRoles();
        userService.createDefaultAdmin();
    }

    @Test
    public void defaultUserTest(){
        User user = userDAO.findByUsername(RoleName.ADMIN.toString());

        assertEquals(RoleName.ADMIN.toString(),user.getName());

    }

    @Test
    public void findNonExistentUser(){
        User user = userDAO.findByUsername("non existant");
        assertEquals(null,user);
    }

    @Test
    public void addRoleTest(){
        User user = userService.findByUsername(RoleName.ADMIN.toString());

        boolean hasAdmin = false;

        for(Role role : user.getRoles()){
            System.out.println("=====");
            System.out.println(role.getRoleName());
            if(role.getRoleName().equals(RoleName.ADMIN.toString())){
                hasAdmin=true;
            }
        }

        assertEquals(true, hasAdmin);
    }

}
