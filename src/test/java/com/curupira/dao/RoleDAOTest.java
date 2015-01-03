package com.curupira.dao;

import com.curupira.SpringTest;
import com.curupira.model.Role;
import com.curupira.services.RoleService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RoleDAOTest extends SpringTest {

    @Test
    public void commonSetupTest(){
        RoleDAO roleDAO = getApplicationContext().getBean(RoleDAO.class);
        RoleService roleService = getApplicationContext().getBean(RoleService.class);
        roleService.createDefaultRoles();

        Role role = roleDAO.findByName("ADMIN");

        assertEquals("ADMIN", role.getRoleName());
    }
}
