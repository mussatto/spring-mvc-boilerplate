package com.curupira.dao;

import com.curupira.SpringTest;
import com.curupira.model.RoleName;
import com.curupira.model.User;
import com.curupira.services.RoleService;
import com.curupira.services.UserService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserDAOTest extends SpringTest {

    @Test
    public void defaultUserTest(){
        UserDAO userDAO = getApplicationContext().getBean(UserDAO.class);

        UserService userService = getApplicationContext().getBean(UserService.class);
        RoleService roleService = getApplicationContext().getBean(RoleService.class);

        roleService.createDefaultRoles();
        userService.createDefaultAdmin();


        User user = userDAO.findByUsername(RoleName.ADMIN.toString());

        assertEquals(RoleName.ADMIN.toString(),user.getName());

    }
}
