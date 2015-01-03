package com.curupira.dao;

import com.curupira.SpringTest;
import com.curupira.model.Role;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RoleDAOTest extends SpringTest {

    @Test
    public void commonSetupTest(){
        RoleDAO roleDAO = getApplicationContext().getBean(RoleDAO.class);

        Role role = roleDAO.findByName("ADMIN");

        assertEquals("ADMIN", role.getRoleName());
    }
}
