package com.curupira.dao;

import com.curupira.SpringTest;
import com.curupira.model.Role;
import com.curupira.model.RoleName;
import com.curupira.model.User;
import com.curupira.services.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserDAOTest extends SpringTest {
    private UserDAO userDAO;
    private UserService userService;

    private static final String defaultAdmin="curupira";

    @Before
    public void setup(){
        userDAO= getApplicationContext().getBean(UserDAO.class);
        userService= getApplicationContext().getBean(UserService.class);
    }

    @Test
    public void defaultUserTest(){
        User user = userDAO.findByUsername(defaultAdmin);
        assertEquals(defaultAdmin,user.getName());

    }

    @Test
    public void findNonExistentUser(){
        User user = userDAO.findByUsername("non existant");
        assertEquals(null,user);
    }

    @Test
    public void addRoleTest(){
        User user = userService.findByUsername(defaultAdmin);

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

    @Test
    public void listAllTest(){

        List<User> userList = userDAO.listAll(0);

        assertEquals(1, userList.size());
        List<RoleName> roleNames = new ArrayList<>();
        roleNames.add(RoleName.USER);

        userService.createUser("new1@user.com", "new_user1", "new_user1",roleNames);

        userList = userDAO.listAll(0);
        assertEquals(2, userList.size());

        for(int i=0; i<20;i++){
            userService.createUser("new"+i+"1@user.com", "new_user"+i, "new_user"+i,roleNames);
        }

        userList = userDAO.listAll(0);
        assertEquals(10, userList.size());

    }

}
